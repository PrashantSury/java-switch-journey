# 🏦 banking-app: project setup

![Phase](https://img.shields.io/badge/Phase-1%20Retail%20core-blue) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.1-brightgreen) ![DB](https://img.shields.io/badge/DB-PostgreSQL-blue) ![Status](https://img.shields.io/badge/status-skeleton-yellow)

> [!NOTE]
> Base package: `com.prashant.banking`. Layers follow [`spring-boot/course-practice/STRUCTURE.md`](../spring-boot/course-practice/STRUCTURE.md), plus `security` and `config`. Schema and roadmap: the **Banking Practice App: Schema & Security Design** Page.

## 🗂️ What's here
```text
banking-app/
├── pom.xml                         Boot 4.1.1: webmvc, validation, data-jpa, security, actuator, flyway + postgres
├── src/main/java/com/prashant/banking/
│   ├── BankingApplication.java
│   ├── controller/  service/  service/impl/  repository/
│   ├── model/  dto/  mapper/  exception/  config/
│   └── security/SecurityConfig.java   ⚠️ permit-all for now (TODO)
├── src/main/resources/
│   ├── application.yml             DB_URL / DB_USERNAME / DB_PASSWORD env vars
│   └── db/migration/V1__auth.sql, V2__core.sql
└── src/test/   BankingApplicationTests (context, /actuator/health, BCrypt) on H2, Flyway off
```

> [!WARNING]
> `SecurityConfig` currently **permits every request** so you can start. It gets replaced by the JWT chain in the auth week.

## ✅ Setup checklist for tomorrow

### 🐘 1. PostgreSQL + pgAdmin 4
- [ ] Open pgAdmin, connect to your local server as `postgres`.
- [ ] Open **Query Tool** on the `postgres` database and run:

```sql
CREATE ROLE banking_app LOGIN PASSWORD 'choose-a-local-password';
CREATE DATABASE java_switch OWNER banking_app;
```

- [ ] Check your version is 13+ (`SELECT version();`), because `gen_random_uuid()` is built in from PG 13.

> [!CAUTION]
> Never put the real password in `application.yml` or any committed file. It only lives in env vars.

### ⚙️ 2. Environment variables
| Variable | Value | Default if unset |
|---|---|---|
| `DB_URL` | `jdbc:postgresql://localhost:5432/java_switch` | same |
| `DB_USERNAME` | `banking_app` | `banking_app` |
| `DB_PASSWORD` | your local password | empty (will fail) |

- [ ] **IntelliJ:** Run ▸ Edit Configurations ▸ `BankingApplication` ▸ Environment variables:

```text
DB_URL=jdbc:postgresql://localhost:5432/java_switch;DB_USERNAME=banking_app;DB_PASSWORD=choose-a-local-password
```

- [ ] **Windows PowerShell** (current session only, for `mvn spring-boot:run`):

```bash
$env:DB_URL="jdbc:postgresql://localhost:5432/java_switch"
$env:DB_USERNAME="banking_app"
$env:DB_PASSWORD="choose-a-local-password"
mvn spring-boot:run
```

- [ ] **Windows CMD** alternative: `set DB_PASSWORD=choose-a-local-password` (or `setx DB_PASSWORD "..."` to keep it permanently, then reopen the terminal).

### ▶️ 3. Run the app so Flyway creates the schema
- [ ] In IntelliJ: right-click `banking-app/pom.xml` ▸ **Add as Maven Project** (it's a separate module), then reload Maven.
- [ ] Run `BankingApplication`. Look for `Successfully applied 2 migrations to schema "auth"` in the log.
- [ ] Open http://localhost:8080/actuator/health and expect `"status":"UP"` with `db` UP.

### 🔍 4. Verify in pgAdmin
- [ ] Refresh `java_switch` ▸ Schemas. You should see `auth`, `core` and Flyway's history table.
- [ ] `auth`: users, roles, permissions, role_permissions, user_roles, refresh_tokens, login_attempts, password_reset_tokens.
- [ ] `core`: branches, customers, kyc_documents, account_types, accounts, transactions.

```sql
SELECT table_schema, table_name FROM information_schema.tables
WHERE table_schema IN ('auth','core') ORDER BY 1, 2;
SELECT version, description, success FROM auth.flyway_schema_history;
```

> [!WARNING]
> Never edit `V1__auth.sql` or `V2__core.sql` after they've run: Flyway checksums them. Changes go in a new `V3__...sql`.

### 🧪 5. Tests
- [ ] `cd banking-app && mvn test` gives 3 tests green. They use H2 with Flyway off; Testcontainers (real PostgreSQL) replaces this in week 3.

### 🐳 6. Docker Desktop (needed by end of Phase 1)
- [ ] Install Docker Desktop for Windows with the WSL 2 backend, then check `docker run hello-world`.
- [ ] Needed for docker-compose (app + postgres) in week 4 and Testcontainers in week 3.

### ☁️ 7. AWS account (before Phase 2, not urgent)
- [ ] Create the account, enable **MFA on root**, then stop using root.
- [ ] Billing ▸ enable free tier usage alerts, create an **AWS Budget** ($1 and $5 email alerts).
- [ ] IAM Identity Center or an IAM user for yourself with MFA; use region `ap-south-1` (Mumbai).

> [!CAUTION]
> Stop or delete EC2/RDS when you're not practising. NAT gateways, load balancers and Fargate are not free.

### 📮 8. HTTP client
- [ ] Install Postman (or use IntelliJ's HTTP Client with `.http` files). Make a `Banking local` environment with `baseUrl = http://localhost:8080`.

> [!IMPORTANT]
> **Done when:** the app starts against PostgreSQL, `/actuator/health` is UP, pgAdmin shows the `auth` and `core` tables, and `mvn test` is green.
