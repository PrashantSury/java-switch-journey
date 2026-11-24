#!/bin/bash
# Runs once, on first start of an empty volume, as the postgres superuser.
# Passwords come from .env via docker-compose (never hardcoded).
set -euo pipefail

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" \
  -v migrator_pw="$DB_MIGRATOR_PASSWORD" -v app_pw="$DB_APP_PASSWORD" \
  -v db="$POSTGRES_DB" <<'SQL'
-- Migrator: owns the database objects, runs Flyway (DDL).
CREATE ROLE banking_migrator LOGIN PASSWORD :'migrator_pw';
-- App: runtime user, DML only, can never ALTER/DROP/CREATE.
CREATE ROLE banking_app LOGIN PASSWORD :'app_pw' NOSUPERUSER NOCREATEDB NOCREATEROLE;

REVOKE ALL ON DATABASE :"db" FROM PUBLIC;
GRANT CONNECT, CREATE ON DATABASE :"db" TO banking_migrator;   -- CREATE = may create schemas (V1)
GRANT CONNECT ON DATABASE :"db" TO banking_app;

-- public holds only flyway_schema_history
REVOKE CREATE ON SCHEMA public FROM PUBLIC;
GRANT USAGE, CREATE ON SCHEMA public TO banking_migrator;
GRANT USAGE ON SCHEMA public TO banking_app;

-- Everything banking_migrator creates later is automatically usable (DML only) by banking_app.
ALTER DEFAULT PRIVILEGES FOR ROLE banking_migrator GRANT USAGE ON SCHEMAS TO banking_app;
ALTER DEFAULT PRIVILEGES FOR ROLE banking_migrator GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO banking_app;
ALTER DEFAULT PRIVILEGES FOR ROLE banking_migrator GRANT USAGE, SELECT ON SEQUENCES TO banking_app;
-- TODO(write by hand, audit migration): REVOKE UPDATE, DELETE, TRUNCATE ON audit.audit_logs FROM banking_app;
SQL
