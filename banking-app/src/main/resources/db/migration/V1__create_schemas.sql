-- V1: schemas only. Owned by the role running Flyway (banking_migrator).
-- TODO(write by hand): V2+ for auth.users/roles/permissions, core.*, audit.audit_logs + trigger.
-- Rule: never edit a migration that has already run; add a new one.
CREATE SCHEMA IF NOT EXISTS auth;
CREATE SCHEMA IF NOT EXISTS core;
CREATE SCHEMA IF NOT EXISTS audit;
