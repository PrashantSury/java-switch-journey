-- V2__core.sql
CREATE SCHEMA IF NOT EXISTS core;

CREATE TABLE core.branches (
  id        SMALLINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  code      VARCHAR(10) NOT NULL UNIQUE,
  ifsc      CHAR(11) NOT NULL UNIQUE CHECK (ifsc ~ '^[A-Z]{4}0[A-Z0-9]{6}$'),
  name      VARCHAR(100) NOT NULL,
  city      VARCHAR(60) NOT NULL,
  created_at TIMESTAMPTZ NOT NULL DEFAULT now()
);

CREATE TABLE core.customers (
  id            BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  public_id     UUID NOT NULL DEFAULT gen_random_uuid() UNIQUE,
  user_id       BIGINT UNIQUE REFERENCES auth.users(id),   -- null until net-banking signup
  customer_no   VARCHAR(12) NOT NULL UNIQUE,               -- CIF number
  first_name    VARCHAR(60) NOT NULL,
  last_name     VARCHAR(60) NOT NULL,
  dob           DATE NOT NULL CHECK (dob < CURRENT_DATE),
  email         VARCHAR(255) NOT NULL,
  phone         VARCHAR(15) NOT NULL,
  pan           CHAR(10) CHECK (pan ~ '^[A-Z]{5}[0-9]{4}[A-Z]$'),
  address_line  VARCHAR(255),
  city          VARCHAR(60),
  pincode       CHAR(6),
  home_branch_id SMALLINT NOT NULL REFERENCES core.branches(id),
  segment       VARCHAR(20) NOT NULL DEFAULT 'RETAIL' CHECK (segment IN ('RETAIL','PRIORITY','NRI')),
  kyc_status    VARCHAR(20) NOT NULL DEFAULT 'PENDING'
                CHECK (kyc_status IN ('PENDING','SUBMITTED','VERIFIED','REJECTED','EXPIRED')),
  version       BIGINT NOT NULL DEFAULT 0,
  created_at    TIMESTAMPTZ NOT NULL DEFAULT now(),
  updated_at    TIMESTAMPTZ NOT NULL DEFAULT now(),
  created_by    VARCHAR(50),
  deleted_at    TIMESTAMPTZ
);
CREATE UNIQUE INDEX ux_customers_pan ON core.customers (pan) WHERE deleted_at IS NULL AND pan IS NOT NULL;
CREATE INDEX ix_customers_branch ON core.customers (home_branch_id);

CREATE TABLE core.kyc_documents (
  id           BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  customer_id  BIGINT NOT NULL REFERENCES core.customers(id),
  doc_type     VARCHAR(20) NOT NULL CHECK (doc_type IN ('PAN','AADHAAR','PASSPORT','VOTER_ID','DL')),
  doc_number_masked VARCHAR(30) NOT NULL,    -- store masked, e.g. XXXX-XXXX-1234
  file_ref     VARCHAR(255),                 -- object-storage key, not the file
  status       VARCHAR(20) NOT NULL DEFAULT 'SUBMITTED'
               CHECK (status IN ('SUBMITTED','APPROVED','REJECTED')),
  reviewed_by  BIGINT REFERENCES auth.users(id),
  reviewed_at  TIMESTAMPTZ,
  rejection_reason VARCHAR(255),
  created_at   TIMESTAMPTZ NOT NULL DEFAULT now(),
  CHECK (status = 'SUBMITTED' OR reviewed_by IS NOT NULL)  -- decision needs a reviewer
);

CREATE TABLE core.account_types (           -- lookup table instead of hardcoded enum
  code              VARCHAR(20) PRIMARY KEY, -- SAVINGS, CURRENT, SALARY, FD
  min_balance       NUMERIC(19,4) NOT NULL DEFAULT 0,
  interest_rate_pct NUMERIC(5,2)  NOT NULL DEFAULT 0,
  daily_debit_limit NUMERIC(19,4) NOT NULL
);

CREATE TABLE core.accounts (
  id            BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  public_id     UUID NOT NULL DEFAULT gen_random_uuid() UNIQUE,
  account_no    VARCHAR(18) NOT NULL UNIQUE,
  customer_id   BIGINT NOT NULL REFERENCES core.customers(id),
  branch_id     SMALLINT NOT NULL REFERENCES core.branches(id),
  account_type  VARCHAR(20) NOT NULL REFERENCES core.account_types(code),
  currency      CHAR(3) NOT NULL DEFAULT 'INR',
  balance       NUMERIC(19,4) NOT NULL DEFAULT 0,
  status        VARCHAR(20) NOT NULL DEFAULT 'ACTIVE'
                CHECK (status IN ('PENDING','ACTIVE','FROZEN','DORMANT','CLOSED')),
  opened_at     TIMESTAMPTZ NOT NULL DEFAULT now(),
  closed_at     TIMESTAMPTZ,
  version       BIGINT NOT NULL DEFAULT 0,   -- @Version optimistic lock
  created_at    TIMESTAMPTZ NOT NULL DEFAULT now(),
  updated_at    TIMESTAMPTZ NOT NULL DEFAULT now(),
  created_by    VARCHAR(50),
  CHECK (balance >= 0 OR account_type = 'CURRENT'),       -- overdraft only on current
  CHECK ((status = 'CLOSED') = (closed_at IS NOT NULL))
);
CREATE INDEX ix_accounts_customer ON core.accounts (customer_id);

CREATE TABLE core.transactions (
  id              BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  public_id       UUID NOT NULL DEFAULT gen_random_uuid() UNIQUE,
  account_id      BIGINT NOT NULL REFERENCES core.accounts(id),
  txn_type        VARCHAR(20) NOT NULL
                  CHECK (txn_type IN ('DEPOSIT','WITHDRAWAL','TRANSFER_IN','TRANSFER_OUT','FEE','INTEREST','REVERSAL')),
  direction       CHAR(2) NOT NULL CHECK (direction IN ('CR','DR')),
  amount          NUMERIC(19,4) NOT NULL CHECK (amount > 0),
  balance_after   NUMERIC(19,4) NOT NULL,    -- makes statements cheap
  channel         VARCHAR(20) NOT NULL CHECK (channel IN ('BRANCH','ATM','NETBANKING','UPI','SYSTEM')),
  reference_no    VARCHAR(30) NOT NULL UNIQUE,
  idempotency_key VARCHAR(64),               -- client-generated, per request
  description     VARCHAR(255),
  status          VARCHAR(20) NOT NULL DEFAULT 'POSTED' CHECK (status IN ('PENDING','POSTED','FAILED','REVERSED')),
  reversal_of     BIGINT REFERENCES core.transactions(id),
  performed_by    BIGINT REFERENCES auth.users(id),
  created_at      TIMESTAMPTZ NOT NULL DEFAULT now()  -- no updated_at: immutable rows
);
CREATE UNIQUE INDEX ux_txn_idem ON core.transactions (account_id, idempotency_key) WHERE idempotency_key IS NOT NULL;
CREATE INDEX ix_txn_account_time ON core.transactions (account_id, created_at DESC);  -- statements
