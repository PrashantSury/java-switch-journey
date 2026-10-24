-- V1__auth.sql
CREATE SCHEMA IF NOT EXISTS auth;

CREATE TABLE auth.users (
  id              BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  public_id       UUID NOT NULL DEFAULT gen_random_uuid() UNIQUE,  -- exposed in APIs
  username        VARCHAR(50)  NOT NULL,
  email           VARCHAR(255) NOT NULL,
  phone           VARCHAR(15),
  password_hash   VARCHAR(100) NOT NULL,                -- BCrypt
  status          VARCHAR(20)  NOT NULL DEFAULT 'ACTIVE'
                  CHECK (status IN ('PENDING','ACTIVE','LOCKED','DISABLED')),
  failed_attempts INT NOT NULL DEFAULT 0 CHECK (failed_attempts >= 0),
  locked_until    TIMESTAMPTZ,
  last_login_at   TIMESTAMPTZ,
  password_changed_at TIMESTAMPTZ NOT NULL DEFAULT now(),
  mfa_enabled     BOOLEAN NOT NULL DEFAULT false,
  version         BIGINT NOT NULL DEFAULT 0,
  created_at      TIMESTAMPTZ NOT NULL DEFAULT now(),
  updated_at      TIMESTAMPTZ NOT NULL DEFAULT now(),
  created_by      VARCHAR(50),
  deleted_at      TIMESTAMPTZ                           -- soft delete
);
CREATE UNIQUE INDEX ux_users_username ON auth.users (lower(username)) WHERE deleted_at IS NULL;
CREATE UNIQUE INDEX ux_users_email    ON auth.users (lower(email))    WHERE deleted_at IS NULL;

CREATE TABLE auth.roles (
  id          SMALLINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  code        VARCHAR(40) NOT NULL UNIQUE,   -- CUSTOMER, TELLER, BRANCH_MANAGER, ADMIN, AUDITOR
  description VARCHAR(255)
);

CREATE TABLE auth.permissions (
  id          SMALLINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  code        VARCHAR(60) NOT NULL UNIQUE,   -- e.g. ACCOUNT_READ_OWN, ACCOUNT_FREEZE, KYC_APPROVE
  description VARCHAR(255)
);

CREATE TABLE auth.role_permissions (
  role_id       SMALLINT NOT NULL REFERENCES auth.roles(id),
  permission_id SMALLINT NOT NULL REFERENCES auth.permissions(id),
  PRIMARY KEY (role_id, permission_id)
);

CREATE TABLE auth.user_roles (
  user_id    BIGINT   NOT NULL REFERENCES auth.users(id),
  role_id    SMALLINT NOT NULL REFERENCES auth.roles(id),
  granted_by BIGINT REFERENCES auth.users(id),
  granted_at TIMESTAMPTZ NOT NULL DEFAULT now(),
  PRIMARY KEY (user_id, role_id)
);

CREATE TABLE auth.refresh_tokens (
  id          BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  user_id     BIGINT NOT NULL REFERENCES auth.users(id),
  token_hash  CHAR(64) NOT NULL UNIQUE,      -- SHA-256 of token, never the raw token
  family_id   UUID NOT NULL,                 -- rotation chain; reuse => revoke family
  expires_at  TIMESTAMPTZ NOT NULL,
  revoked_at  TIMESTAMPTZ,
  replaced_by BIGINT REFERENCES auth.refresh_tokens(id),
  user_agent  VARCHAR(255),
  ip_address  INET,
  created_at  TIMESTAMPTZ NOT NULL DEFAULT now()
);
CREATE INDEX ix_refresh_user ON auth.refresh_tokens (user_id) WHERE revoked_at IS NULL;

CREATE TABLE auth.login_attempts (
  id         BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  username   VARCHAR(255) NOT NULL,
  user_id    BIGINT REFERENCES auth.users(id),
  success    BOOLEAN NOT NULL,
  reason     VARCHAR(40),                    -- BAD_PASSWORD, LOCKED, UNKNOWN_USER
  ip_address INET,
  attempted_at TIMESTAMPTZ NOT NULL DEFAULT now()
);
CREATE INDEX ix_login_attempts_user_time ON auth.login_attempts (user_id, attempted_at DESC);

CREATE TABLE auth.password_reset_tokens (
  id         BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  user_id    BIGINT NOT NULL REFERENCES auth.users(id),
  token_hash CHAR(64) NOT NULL UNIQUE,
  expires_at TIMESTAMPTZ NOT NULL,           -- e.g. 15 minutes
  used_at    TIMESTAMPTZ,
  created_at TIMESTAMPTZ NOT NULL DEFAULT now()
);
