package com.prashant.coursepractice.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Drill 1 (Day 13): what Spring already answers, and what the catch-all must not swallow.
 * Spec: tasks/day13.md, "Drill 1". Write each test body by hand; every test is red until you do.
 * Rule of the drill: a client mistake (4xx) must never come back as a 500.
 */
@SpringBootTest
@AutoConfigureMockMvc
class SpringDefaultsDrillTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("GET /api/students/abc returns 400 ProblemDetail (a non-numeric id), not 500")
    void nonNumericIdReturns400() throws Exception {
        // TODO(write by hand)
        // when:  GET /api/students/abc
        // then:  status 400; $.status 400; $.errorCode exists; body does not contain "MethodArgumentTypeMismatchException"
        fail("TODO: write this test");
    }

    @Test
    @DisplayName("GET /api/nothing returns 404 ProblemDetail (no handler for the path), not 500")
    void unknownPathReturns404() throws Exception {
        // TODO(write by hand)
        // when:  GET /api/nothing
        // then:  status 404; $.status 404; $.errorCode exists
        fail("TODO: write this test");
    }

    @Test
    @DisplayName("PATCH /api/students/1 returns 405 ProblemDetail and keeps the Allow header")
    void wrongVerbKeepsAllowHeader() throws Exception {
        // TODO(write by hand)
        // when:  PATCH /api/students/1
        // then:  status 405; header "Allow" is present and lists GET, PUT and DELETE; $.errorCode is METHOD_NOT_ALLOWED
        fail("TODO: write this test");
    }
}
