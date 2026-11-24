package com.prashant.banking.config;

import java.time.Clock;
import java.time.Instant;
import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/** Fills @CreatedDate/@LastModifiedDate/@CreatedBy on {@code BaseEntity}. */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware", dateTimeProviderRef = "auditingDateTimeProvider")
public class JpaAuditingConfig {

    /** TODO(write by hand): read the user's public id from the JWT in SecurityContextHolder. */
    @Bean
    AuditorAware<String> auditorAware() {
        return () -> Optional.of("system");
    }

    /** Uses the shared Clock so tests can freeze time. */
    @Bean
    DateTimeProvider auditingDateTimeProvider(Clock clock) {
        return () -> Optional.of(Instant.now(clock));
    }
}
