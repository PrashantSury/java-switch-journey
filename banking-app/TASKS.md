# 🏦 Banking app · Module 1: AuthN / AuthZ

**Goal:** a user logs in and gets a JWT; a protected endpoint answers 401 without a token, 403 without the permission, 200 with it.
**Run:** `docker compose up -d` in `banking-app/`, then `mvn -f banking-app/pom.xml verify` (Docker Desktop running).
**Rules:** you write the code and the test bodies · stuck 15 min → ask Lumi · one task per day, ~25-45 min · status lives in [PROGRESS.md](../PROGRESS.md#-banking-app).

| # | Task | Time | Done when | Status |
|---|---|---|---|---|
| 1.1 | V2 auth tables + `AuthSchemaIT` | 45 | `AuthSchemaIT` 2/2, `BankingApplicationIT` still green | 🟡 |
| 1.2 | Entities + `UserRepository` | 40 | app boots with `ddl-auto=validate`; `UserRepositoryIT` green | ⬜ |
| 1.3 | `PasswordEncoder` + first admin, no password in git | 30 | `PasswordHashingTest` green; admin created from an env var or a one-off SQL | ⬜ |
| 1.4 | `JwtEncoder` + `TokenService` | 45 | `TokenServiceTest` green: `sub`, `exp - iat = 900`, `permissions` | ⬜ |
| 1.5 | `POST /auth/login` | 45 | `AuthControllerIT` green: 200 · 400 · 401 ×3 (same body) | ⬜ |
| 1.6 | What Spring already handles (grid check) | 30 | curl gives 405 · 415 · 400, not 401 or 500 | ⬜ |
| 1.7 | Permissions → authorities + one protected endpoint | 40 | `SecuredEndpointIT` green: 401 · 401 · 403 · 200 | ⬜ |
| 1.8 | Hardening + module review | 40 | edge cases green, interview Qs graded ≥ 7 → Module 1 ✅ | ⬜ |

## 🧭 The method × outcomes grid (use it for every endpoint, every module)

Before you write a handler, fill this in. Mark each cell **Spring** (already handled), **mine** (your code) or **n/a**.

| Endpoint | Happy | 400 | 401 | 403 | 404 | 405 / 415 | 409 |
|---|---|---|---|---|---|---|---|
| `POST /auth/login` | 200 + token | blank field (mine, via `@Valid`) · malformed JSON (Spring) | bad credentials (mine) | n/a | n/a | Spring | n/a |
| `GET /api/v1/me` | 200 | n/a | no / bad / expired token (Spring Security) | missing `ACCOUNT_READ` (Spring + your advice) | n/a | Spring | n/a |
| Later: `GET /{id}` · list · `POST` · `PUT/PATCH /{id}` · `DELETE /{id}` | 200 · 200 · 201 + `Location` · 200 · 204 | validation | token | owner / permission | missing id | Spring | duplicate, stale `@Version` |

> Golden rule: **check what Spring already does first** (curl it), then add only the handlers you need. A catch-all `@ExceptionHandler(Exception.class)` turns Spring's 405/415/400 into 500s.

---

## 1.1 · V2 auth tables + `AuthSchemaIT` (~45 min)

- **Goal:** write `V2__create_auth_tables.sql` by hand: `users`, `roles`, `permissions`, `user_roles`, `role_permissions` in schema `auth`.
- **Files:** `src/main/resources/db/migration/V2__create_auth_tables.sql` (you create it) · `src/test/java/com/prashant/banking/auth/AuthSchemaIT.java` (2 stub tests, bodies are yours).
- **Done when:** `mvn -f banking-app/pom.xml verify` → `AuthSchemaIT` 2/2 and `BankingApplicationIT` 1/1.
- **First:** 5 decisions as comment lines at the top of V2 (table list, PK type, case-insensitive username, password column, `BaseEntity` columns).
- **Interview:** why a unique index on `lower(username)`, and not an `existsByUsername` check in the service?

<details><summary>📖 Teaching</summary>

**Why it matters.** Every rule later ("only the owner", "a checker approves") needs users and permissions. And Flyway checksums a migration once it has run, so the shape you pick today is the one you live with. You change it with a V3, never by editing V2.

**The concept.** Users get roles, roles get permissions (two join tables). The token will carry the **permissions**, because "may this user read accounts?" is about a permission, not a job title.

**Small example.** A case-insensitive unique username:

```sql
CREATE TABLE auth.users (
  id            BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  public_id     UUID         NOT NULL UNIQUE,
  username      VARCHAR(50)  NOT NULL,
  password_hash VARCHAR(100) NOT NULL,
  enabled       BOOLEAN      NOT NULL DEFAULT TRUE
  -- + the BaseEntity columns: created_at, updated_at, created_by, version
);
CREATE UNIQUE INDEX ux_users_username_lower ON auth.users (lower(username));
```

| Insert | Result |
|---|---|
| `'Teller01'` | ✅ 1 row |
| `'teller01'` | ❌ `duplicate key value violates unique constraint "ux_users_username_lower"` |
| `'teller02'` | ✅ 1 row: `lower` differs |

Row 2 is out because `lower('teller01') = lower('Teller01')`. In `JdbcTemplate` that error arrives as `DuplicateKeyException`, which is what your second test expects.

**Gotchas**
- No password, hash or seed user in V2. Ever.
- `password_hash` holds a BCrypt string (60 chars), not the password.
- `ddl-auto=validate` will compare your Task 1.2 entities with this SQL, so names and types must match.
- If V2 already ran on your local DB and you change it: reset the dev DB or add V3.

**Checks (letters only)**
1. Why not `UNIQUE (username)`? A. slower · B. `Teller01` and `teller01` would both get in · C. Postgres forbids it
2. Two requests register `teller01` at the same moment and both pass `existsByUsername`. What stops the second one? A. `@Transactional` · B. the unique index · C. nothing
3. V2 ran yesterday. Today you need a new column. A. edit V2 · B. add V3 · C. `ddl-auto=update`

</details>

## 1.2 · Entities + `UserRepository` (~40 min)

- **Goal:** `User`, `Role`, `Permission` in `auth.model` (extend `BaseEntity`), mapped to the `auth` schema; `UserRepository.findByUsernameIgnoreCase`.
- **Files:** `auth/model/*.java`, `auth/repository/UserRepository.java`, test `auth/UserRepositoryIT.java` (you write it).
- **Done when:** the app boots (`BankingApplicationIT` green, so `validate` agrees with V2), and `UserRepositoryIT` saves a user with 1 role and 2 permissions, then finds it by `"TELLER01"` with permissions loaded.
- **Interview:** with `open-in-view: false`, where must the user's permissions be loaded, and what fails if they aren't?

<details><summary>📖 Teaching</summary>

**Why it matters.** Login needs the user *and* their permissions in one go. Getting this wrong gives you the famous `LazyInitializationException`, or an N+1 storm.

**The concept.** `@ManyToMany` is LAZY by default. With `open-in-view: false` (our setting), lazy data must be loaded **inside the service transaction**.

**Small example.**

```java
@Query("select u from User u left join fetch u.roles r left join fetch r.permissions "
     + "where lower(u.username) = lower(:username)")
Optional<User> findWithPermissions(@Param("username") String username);
```

| Call | Result |
|---|---|
| `findByUsernameIgnoreCase("TELLER01")` then `user.getRoles().size()` outside a transaction | ❌ `LazyInitializationException` |
| `findWithPermissions("TELLER01")` then read permissions | ✅ loaded in one query |

**Gotchas**
- `@Table(schema = "auth", name = "users")`. Without the schema, `validate` looks in `public` and fails at startup.
- No Lombok, and no `toString()` that prints `passwordHash` or walks lazy collections.
- Ids: BIGINT identity inside, public `UUID` outside (it goes into the token's `sub`).

**Checks**
1. `ddl-auto=validate` finds a column type mismatch. A. it fixes the column · B. startup fails · C. it logs a warning
2. Default fetch type of `@ManyToMany`? A. EAGER · B. LAZY

</details>

## 1.3 · `PasswordEncoder` + first admin (~30 min)

- **Goal:** a BCrypt `PasswordEncoder` bean, plus a way to create the first admin that keeps the password out of git.
- **Files:** `security/SecurityConfig.java` (bean), test `security/PasswordHashingTest.java` (plain unit test, no Docker).
- **Done when:** the test shows the hash starts with `$2a$`, is 60 chars, `matches` is true, and two encodes of the same password differ. The admin comes from an env var (e.g. `BOOTSTRAP_ADMIN_PASSWORD`, added to `.env.example` as `CHANGE_ME`) or a one-off SQL you run yourself.
- **Interview:** why is a slow hash a feature here, and what does the salt protect against?

<details><summary>📖 Teaching</summary>

**Why it matters.** If the DB leaks, hashes must be expensive to crack. And a password in a migration or `application.yml` lives in git history forever.

**Small example.**

```java
PasswordEncoder enc = new BCryptPasswordEncoder();
String h1 = enc.encode("<password>");
String h2 = enc.encode("<password>");
```

| Expression | Value |
|---|---|
| `h1.startsWith("$2a$10$")` | true (version 2a, cost 10) |
| `h1.length()` | 60 |
| `h1.equals(h2)` | **false**: each hash has its own random salt |
| `enc.matches("<password>", h1)` | true |

**Gotchas**
- BCrypt only uses the first 72 bytes. Check what your Spring Security version does with a longer password.
- A bootstrap runner must do nothing when users already exist, and must never log the password.

**Checks**
1. Same password, two encodes, two different strings. Why? A. a bug · B. a random salt · C. the clock
2. The first admin's password should come from: A. V2 · B. `application.yml` · C. an env var or a manual step

</details>

## 1.4 · `JwtEncoder` + `TokenService` (~45 min)

- **Goal:** sign tokens with the RSA **private** key (`JWT_PRIVATE_KEY_LOCATION`), claims `sub` (public id), `iat`, `exp` (+900 s, from the injected `Clock`), `permissions`.
- **Files:** `security/SecurityConfig.java` (or `auth/config`), `auth/service/TokenService.java`, test `auth/TokenServiceTest.java`.
- **Done when:** `TokenServiceTest` issues a token with a fixed `Clock`, decodes it with the public key, and asserts `sub`, `exp - iat = 900` and `permissions = ["ACCOUNT_READ"]`.
- **Keys:** real keys live outside the repo. For tests, generate a **test-only** pair in `src/test/resources`, named clearly.
- **Interview:** why RS256 and not HS256 when several services verify tokens?

<details><summary>📖 Teaching</summary>

**Why it matters.** The private key signs and the public key verifies. The API config only ever holds the public key, so leaking it can't mint tokens.

**Small example.**

```bash
openssl genpkey -algorithm RSA -pkeyopt rsa_keygen_bits:2048 -out jwt-private.pem   # PKCS#8
openssl pkey -in jwt-private.pem -pubout -out jwt-public.pem
```

```java
RSAKey jwk = new RSAKey.Builder(publicKey).privateKey(privateKey).build();
JwtEncoder encoder = new NimbusJwtEncoder(new ImmutableJWKSet<>(new JWKSet(jwk)));
```

Decoded payload you should see:

```json
{ "sub": "6f1c…", "iat": 1790922600, "exp": 1790923500, "permissions": ["ACCOUNT_READ"] }
```

`exp - iat = 900` only because the `Clock` is fixed in the test. With `Instant.now()` the test would be flaky.

**Gotchas**
- Reading a PEM private key: `RsaKeyConverters.pkcs8()` expects PKCS#8 (`BEGIN PRIVATE KEY`).
- The private key missing at startup → fail fast with a clear message (Task 1.8).
- Never put the password, or anything secret, in claims. The payload is only Base64URL, not encrypted.

**Checks**
1. Which key does the API need to verify? A. private · B. public · C. both
2. Can anyone read a JWT's payload without the key? A. yes · B. no

</details>

## 1.5 · `POST /auth/login` (~45 min)

- **Goal:** `LoginRequest(username, password)` with `@NotBlank` → `AuthService` → `{tokenType, accessToken, expiresInSeconds}`.
- **Files:** `auth/dto/`, `auth/service/AuthService.java`, `auth/controller/AuthController.java`, test `auth/AuthControllerIT.java`.
- **Done when:** `AuthControllerIT` green: 200 with a token · 400 blank username (`violations[]`) · 401 wrong password · 401 unknown user · 401 disabled user, **all three 401 bodies identical**.
- **First:** fill the grid row for this endpoint (top of this file). Only the 401 cell is new code.
- **Interview:** why must "unknown user" and "wrong password" look the same, and what else (timing) can leak the difference?

<details><summary>📖 Teaching</summary>

**Why it matters.** Login is an attacker's favourite endpoint. Two different messages hand them a list of valid usernames.

**Small example** (curl, app on 9078):

```bash
curl -s -X POST localhost:9078/auth/login -H 'Content-Type: application/json' \
     -d '{"username":"teller01","password":"<wrong>"}'
```

| Request | Status | `message` |
|---|---|---|
| right user, right password | 200 | (token body) |
| right user, wrong password | 401 | `Invalid credentials` |
| unknown user | 401 | `Invalid credentials` |
| disabled user | 401 | `Invalid credentials` |
| `"username": ""` | 400 | `Validation failed` + `violations` |

Rows 2-4 are the same on purpose. Row 5 is already handled by the existing `GlobalExceptionHandler` (`MethodArgumentNotValidException`), so you write nothing for it.

**Gotchas**
- Throw your own exception (e.g. `InvalidCredentialsException`) and map it to 401 in `GlobalExceptionHandler`, so the body is your `ApiError`.
- Unknown user: still run one `matches` against a dummy hash, so the timing looks like a wrong password.
- A `record LoginRequest` prints the password in its default `toString()`. Override it.

**Checks**
1. Which status for a wrong password? A. 400 · B. 401 · C. 403 · D. 404
2. Who produces the 400 for a blank username? A. your new code · B. the existing validation handler

</details>

## 1.6 · What Spring already handles: grid check (~30 min)

- **Goal:** prove the "Spring" cells of the grid against the **running app**, before adding any handler.
- **Run:** start the app, then three curls (below). Write the results as a comment table at the top of `AuthController`.
- **Done when:** `GET /auth/login` → 405 · `text/plain` body → 415 · malformed JSON → 400. If you see 401 or 500 instead, find out why and make the smallest fix.
- **Interview:** your MockMvc test says 400, but curl says 401 for the same malformed body. Why?

<details><summary>📖 Teaching</summary>

**Why it matters.** Most "our API returns 500 for a typo" bugs come from handlers written before anyone checked the defaults.

**Small example.**

```bash
curl -s -o /dev/null -w '%{http_code}\n' localhost:9078/auth/login
curl -s -o /dev/null -w '%{http_code}\n' -X POST localhost:9078/auth/login -H 'Content-Type: text/plain' -d 'hi'
curl -s -o /dev/null -w '%{http_code}\n' -X POST localhost:9078/auth/login -H 'Content-Type: application/json' -d '{bad'
```

| Curl | Expected | Who handles it |
|---|---|---|
| GET on a POST-only path | 405 | Spring MVC |
| wrong content type | 415 | Spring MVC |
| broken JSON | 400 | Spring MVC |

**Gotchas**
- Spring MVC answers these by sending an error, which is forwarded to `/error`. If `/error` isn't permitted in `SecurityConfig`, an anonymous caller can get **401** instead of the real status.
- MockMvc doesn't forward to `/error`, so it can't show that bug. That's why this task uses curl (or a `RANDOM_PORT` test).
- A catch-all `@ExceptionHandler(Exception.class)` would turn all three into 500s.

**Checks**
1. Who should answer 405 here? A. your handler · B. Spring MVC
2. Does MockMvc go through the `/error` forward? A. yes · B. no

</details>

## 1.7 · Permissions → authorities + one protected endpoint (~40 min)

- **Goal:** a `JwtAuthenticationConverter` that turns the `permissions` claim into authorities (no prefix), and `GET /api/v1/me` guarded by `@PreAuthorize("hasAuthority('ACCOUNT_READ')")`.
- **Files:** `security/SecurityConfig.java`, `auth/controller/MeController.java`, test `security/SecuredEndpointIT.java`.
- **Done when:** `SecuredEndpointIT` green: no token → 401 · token signed by another key → 401 · valid token without `ACCOUNT_READ` → 403 (your `ApiError`) · with it → 200.
- **Interview:** why does `@PreAuthorize` do nothing when the method is called from inside the same class?

<details><summary>📖 Teaching</summary>

**Why it matters.** This is the 401-vs-403 question every interview asks, and the base of every ownership rule later on.

**The concept.** 401 = "who are you?" (authentication failed). 403 = "I know you, but no" (authorization failed).

**Small example.** By default Spring reads the `scope` claim and adds `SCOPE_`:

| Token claims | Default authorities | With your converter |
|---|---|---|
| `"permissions": ["ACCOUNT_READ"]` | none | `ACCOUNT_READ` ✅ |
| `"scope": "ACCOUNT_READ"` | `SCOPE_ACCOUNT_READ` | (not used) |

```java
var authorities = new JwtGrantedAuthoritiesConverter();
authorities.setAuthoritiesClaimName("permissions");
authorities.setAuthorityPrefix("");
```

| Request | Status | Body from |
|---|---|---|
| no token | 401 | Spring Security (`WWW-Authenticate: Bearer`) |
| bad signature or expired | 401 | Spring Security |
| no `ACCOUNT_READ` | 403 | your `GlobalExceptionHandler` (`AccessDeniedException`) |
| `ACCOUNT_READ` | 200 | `MeController` |

**Gotchas**
- Forget the prefix and `hasAuthority('ACCOUNT_READ')` never matches, so every call is 403.
- Method security works through a proxy, so `this.someGuardedMethod()` skips the check.

**Checks**
1. Valid token, missing permission? A. 401 · B. 403 · C. 404
2. Token signed with a different key? A. 401 · B. 403

</details>

## 1.8 · Hardening + module review (~40 min)

- **Goal:** close the edge cases, then defend the module out loud.
- **Do:** disabled user → 401 · no password in logs or `toString()` · app fails fast if the private key is missing · `.env.example` gets `JWT_PRIVATE_KEY_LOCATION=CHANGE_ME`.
- **Done when:** all Module 1 tests green on `verify`, and the 5 interview questions below are graded ≥ 7 (in chat). Then Module 1 is ✅ and Module 2 (Customer) opens.
- **Interview:** (1) RS256 vs HS256 · (2) permissions in the token vs in the DB: cost of revoking · (3) revoking a still-valid token · (4) no user enumeration · (5) `@PreAuthorize` and self-invocation.

<details><summary>📖 Teaching</summary>

**Why it matters.** Senior interviews skip "does it work?" and ask "what happens when…". This task is those "when"s.

| Case | Expected |
|---|---|
| disabled user logs in | 401, same body as a wrong password |
| password in a log line | never (search the logs after a test run) |
| private key file missing | startup fails, message names the variable |
| permission removed from a role | old tokens keep it until `exp` (that's why 15 min) |

**Checks**
1. A permission is revoked. When does an existing token lose it? A. at once · B. when it expires · C. never
2. Where should the token lifetime come from? A. hard-coded · B. config + the injected `Clock` in tests

</details>
