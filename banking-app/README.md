# 🏦 banking-app: infrastructure skeleton

![Phase](https://img.shields.io/badge/Phase-1%20Retail%20core-blue) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.2-brightgreen) ![Java](https://img.shields.io/badge/Java-21-blue) ![DB](https://img.shields.io/badge/PostgreSQL-16%20in%20Docker-blue) ![Status](https://img.shields.io/badge/status-skeleton-yellow)

> [!NOTE]
> Plumbing only: no entities, services or endpoints. Every `TODO(write by hand)` is **your** practice. Layout: [`STRUCTURE.md`](STRUCTURE.md).

## 🗂️ What's here
```text
banking-app/
├── pom.xml                  Boot 4.1.2, Java 21, springdoc 3.2.0, Testcontainers (no H2, no Lombok)
├── docker-compose.yml       postgres:16 on localhost:5433, healthcheck
├── docker/init/01-roles.sh  creates banking_migrator (DDL) + banking_app (DML only)
├── .env.example             copy to .env (git-ignored)
└── src/
    ├── main/java/com/prashant/banking/  common/ config/ security/ + 6 feature packages
    ├── main/resources/application.yml   all secrets from env vars, ddl-auto=validate
    ├── main/resources/db/migration/V1__create_schemas.sql   auth, core, audit
    └── test/  AbstractIntegrationTest (Testcontainers) + BankingApplicationIT
```

## 🛡️ Two database roles
| Role | Used by | Can do |
|---|---|---|
| `banking_migrator` | Flyway | owns schemas and tables, DDL |
| `banking_app` | the running app | `SELECT, INSERT, UPDATE, DELETE` only (via default privileges) |

> [!IMPORTANT]
> Why 5433? Your PostgreSQL installed on Windows already uses **5432**. Docker's Postgres is published on **5433**, so both can run side by side. The app uses the Docker one.

## ✅ Tonight's steps (≈ 40 min)

### 1. Pull and create `.env`
```bash
git pull
cd banking-app
copy .env.example .env
```
- [ ] Open `.env` and replace every `CHANGE_ME` with your own passwords.

> [!CAUTION]
> `.env` is git-ignored. Never commit it, and never put passwords in `application.yml`.

### 2. 🐳 Start PostgreSQL (Docker Desktop must be running)
```bash
docker compose up -d
docker compose ps        # STATUS should say (healthy)
```
> [!WARNING]
> The roles script runs only on the **first** start of an empty volume. If you change passwords later: `docker compose down -v` then `up -d` (this wipes the Docker DB).

### 3. 🐘 Connect pgAdmin
- [ ] Register server → Host `localhost`, Port **5433**, DB `java_switch`, user `postgres` (password from `.env`).
- [ ] Check **Login/Group Roles** shows `banking_migrator` and `banking_app`.

### 4. 🔑 Create the JWT key pair (outside the repo)
Git Bash (comes with Git for Windows) has `openssl`:
```bash
mkdir -p /c/dev/banking-keys && cd /c/dev/banking-keys
openssl genpkey -algorithm RSA -pkeyopt rsa_keygen_bits:2048 -out jwt-private.pem
openssl rsa -in jwt-private.pem -pubout -out jwt-public.pem
```
- [ ] In `.env`: `JWT_PUBLIC_KEY_LOCATION=file:C:/dev/banking-keys/jwt-public.pem`
> [!TIP]
> The private key is for the `/auth/login` you'll write later (JwtEncoder). The app only needs the public key today.

### 5. ⚙️ IntelliJ
- [ ] Open `banking-app/pom.xml` as a Maven project, Project SDK = JDK 21+ (language level 21).
- [ ] Run config for `BankingApplication` → **Environment variables**: either install the **EnvFile** plugin and point it at `.env`, or paste the `.env` lines in manually (`DB_URL`, `DB_APP_USER`, `DB_APP_PASSWORD`, `DB_MIGRATOR_USER`, `DB_MIGRATOR_PASSWORD`, `JWT_PUBLIC_KEY_LOCATION`).

### 6. 🧪 Verify
```bash
mvn verify
```
- [ ] `BankingApplicationIT` passes (it starts its own throwaway Postgres; Docker Desktop must be running).

### 7. ▶️ Run the app
- [ ] Log shows `Successfully applied 1 migration` … `v1`.
- [ ] http://localhost:8080/actuator/health → `{"status":"UP"}`
- [ ] http://localhost:8080/swagger-ui.html opens.
- [ ] Any other URL returns **401** (security works).

### 8. 🔒 Before committing anything
```bash
git status    # .env and *.pem must NOT appear
```

> [!IMPORTANT]
> Done when: tests pass, the app is UP on Docker Postgres, pgAdmin shows both roles, and `git status` is clean of secrets.

## ✍️ What you write by hand
- 🔥 Flyway migrations V2+: auth (users, roles, permissions), core (customers, accounts, transactions), audit_logs + its trigger and `REVOKE UPDATE, DELETE, TRUNCATE`
- 🔥 JPA entities and relations, fetch types, and the N+1 you create and then fix
- 🔥 Services: deposit, withdraw, transfer, idempotency (key + request hash), `@Version` and `FOR UPDATE` (lock accounts in fixed order)
- 🔥 `/auth/login` with `JwtEncoder`, `@PreAuthorize` rules, `AccountSecurity.isOwner`, maker-checker for KYC
- 🔥 The concurrent-withdrawal test and the migration test
- 🔥 All SQL evening queries and the `generate_series` seed script

> [!WARNING]
> **Explain every line of `SecurityConfig`** before you build on it: why CSRF is off, what STATELESS means, how the JWT is validated, and what `@EnableMethodSecurity` enables. "The agent wrote it" won't work in an interview.

> [!NOTE]
> In tests, Flyway and the app both use the Testcontainers superuser; the two-role split applies to the Docker Compose database.
