package com.prashant.banking.auth;

import static org.junit.jupiter.api.Assertions.fail;

import com.prashant.banking.AbstractIntegrationTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Module 1, step 1: proves that V2__create_auth_tables.sql ran and the auth schema is shaped as designed.
 * Spec: tasks/day13.md, "Banking module 1, step 1". Write the bodies by hand; both tests are red until V2 exists.
 * Needs Docker Desktop running (Testcontainers), like BankingApplicationIT.
 */
class AuthSchemaIT extends AbstractIntegrationTest {

    @Autowired
    JdbcTemplate jdbc;

    @Test
    @DisplayName("V2 creates the five auth tables")
    void v2CreatesFiveAuthTables() {
        // TODO(write by hand)
        // query information_schema.tables for table_schema = 'auth'
        // expect exactly: users, roles, permissions, user_roles, role_permissions
        fail("TODO: write this test");
    }

    @Test
    @DisplayName("usernames are unique ignoring case: 'Teller01' and 'teller01' cannot both exist")
    void usernameIsUniqueIgnoringCase() {
        // TODO(write by hand)
        // insert one user, then a second whose username differs only by case; expect DuplicateKeyException
        // (placeholder password HASH values only, never a real password)
        fail("TODO: write this test");
    }
}
