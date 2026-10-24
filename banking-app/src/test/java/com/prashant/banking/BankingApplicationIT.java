package com.prashant.banking;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

class BankingApplicationIT extends AbstractIntegrationTest {

    @Autowired Flyway flyway;
    @Autowired JdbcTemplate jdbc;

    @Test
    void contextBootsAndV1CreatesSchemas() {
        assertThat(flyway.info().applied()).extracting(m -> m.getVersion().getVersion()).contains("1");

        List<String> schemas = jdbc.queryForList(
                "SELECT schema_name FROM information_schema.schemata WHERE schema_name IN ('auth','core','audit')",
                String.class);
        assertThat(schemas).containsExactlyInAnyOrder("auth", "core", "audit");
    }
}
