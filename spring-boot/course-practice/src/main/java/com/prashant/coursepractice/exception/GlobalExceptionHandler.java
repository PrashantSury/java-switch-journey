package com.prashant.coursepractice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * One place that turns exceptions into RFC 9457 ProblemDetail responses.
 *
 * <p>Handlers are ordered by HTTP status. Every response carries an {@code errorCode}:
 * <pre>
 *  400  MethodArgumentNotValidException            VALIDATION_FAILED
 *  400  HttpMessageNotReadableException            MALFORMED_REQUEST
 *  400  MissingServletRequestParameterException    MISSING_REQUEST_PARAMETER
 *  404  StudentNotFoundException                   STUDENT_NOT_FOUND
 *  405  HttpRequestMethodNotSupportedException     METHOD_NOT_ALLOWED
 *  409  DuplicateEmailException                    DUPLICATE_EMAIL
 *  415  HttpMediaTypeNotSupportedException         UNSUPPORTED_MEDIA_TYPE
 *  500  Exception (catch-all, LAST)                INTERNAL_ERROR
 * </pre>
 * Framework client errors (405, 415) get their own handlers, otherwise the catch-all
 * would wrongly report them as 500.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // ===================== 400 Bad Request =====================

    /** 400 VALIDATION_FAILED: a field broke a bean-validation rule on POST / PUT. */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail invalid(MethodArgumentNotValidException ex) {

        ProblemDetail problemDetail =
                ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        problemDetail.setTitle("Validation Failed");
        problemDetail.setDetail("One or more fields have validation errors.");

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(error ->
                        errors.put(error.getField(), error.getDefaultMessage())
                );

        problemDetail.setProperty("errors", errors);
        problemDetail.setProperty("errorCode", "VALIDATION_FAILED");

        return problemDetail;
    }

    /** 400 MALFORMED_REQUEST: body missing or not valid JSON on POST / PUT. Parser text is logged, never returned. */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ProblemDetail badJsonOrEmptyJson(
            HttpMessageNotReadableException ex) {

        log.warn(ex.getMessage());

        ProblemDetail problemDetail =
                ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        problemDetail.setTitle("Malformed Request");
        problemDetail.setDetail(
                "Request body is missing or not valid JSON."
        );
        problemDetail.setProperty("errorCode", "MALFORMED_REQUEST");
        return problemDetail;
    }

    /** 400 MISSING_REQUEST_PARAMETER: required query parameter absent (GET /search without name). */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ProblemDetail missingParameter(
            MissingServletRequestParameterException ex) {

        ProblemDetail problemDetail =
                ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        problemDetail.setTitle("Missing Request Parameter");
        problemDetail.setDetail(
                "Required parameter '" + ex.getParameterName() + "' is missing."
        );
        problemDetail.setProperty("errorCode", "MISSING_REQUEST_PARAMETER");
        problemDetail.setProperty("parameter", ex.getParameterName());

        return problemDetail;
    }

    // ===================== 404 Not Found =====================

    /** 404 STUDENT_NOT_FOUND: unknown id on GET /{id}, PUT /{id}, DELETE /{id}. */
    @ExceptionHandler(StudentNotFoundException.class)
    public ProblemDetail notFound(StudentNotFoundException ex) {

        ProblemDetail problemDetail =
                ProblemDetail.forStatus(HttpStatus.NOT_FOUND);

        problemDetail.setTitle("Student Not Found");
        problemDetail.setDetail(ex.getMessage());
        problemDetail.setProperty("errorCode", "STUDENT_NOT_FOUND");

        return problemDetail;
    }

    // ===================== 405 Method Not Allowed =====================

    /** 405 METHOD_NOT_ALLOWED: right path, wrong HTTP verb. Keeps Spring's Allow header. */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ProblemDetail> methodNotAllowed(
            HttpRequestMethodNotSupportedException ex) {

        ProblemDetail problemDetail =
                ProblemDetail.forStatus(HttpStatus.METHOD_NOT_ALLOWED);

        problemDetail.setTitle("Method Not Allowed");
        problemDetail.setDetail("HTTP method '" + ex.getMethod() + "' is not supported for this endpoint.");
        problemDetail.setProperty("errorCode", "METHOD_NOT_ALLOWED");

        return ResponseEntity
                .status(HttpStatus.METHOD_NOT_ALLOWED)
                .headers(ex.getHeaders())
                .body(problemDetail);
    }

    // ===================== 409 Conflict =====================

    /** 409 DUPLICATE_EMAIL: email already owned by another student on POST / PUT. */
    @ExceptionHandler(DuplicateEmailException.class)
    public ProblemDetail handleDuplicateEmail(DuplicateEmailException ex) {

        ProblemDetail problemDetail =
                ProblemDetail.forStatus(HttpStatus.CONFLICT);

        problemDetail.setTitle("Duplicate Email");
        problemDetail.setDetail("Email already exists. Please use a different email address.");
        problemDetail.setProperty("errorCode", "DUPLICATE_EMAIL");

        return problemDetail;
    }

    // ===================== 415 Unsupported Media Type =====================

    /** 415 UNSUPPORTED_MEDIA_TYPE: body sent with a Content-Type we do not read (e.g. text/plain). Keeps the Accept header. */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ProblemDetail> unsupportedMediaType(
            HttpMediaTypeNotSupportedException ex) {

        ProblemDetail problemDetail =
                ProblemDetail.forStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE);

        problemDetail.setTitle("Unsupported Media Type");
        problemDetail.setDetail("Content type is not supported. Send application/json.");
        problemDetail.setProperty("errorCode", "UNSUPPORTED_MEDIA_TYPE");

        return ResponseEntity
                .status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
                .headers(ex.getHeaders())
                .body(problemDetail);
    }

    // ===================== 500 Internal Server Error (keep LAST) =====================

    /** 500 INTERNAL_ERROR: safety net for anything no handler above matches. Logged, never leaked. */
    @ExceptionHandler(Exception.class)
    public ProblemDetail handleException(Exception ex) {

        log.error("Unhandled", ex);
        ProblemDetail problemDetail =
                ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        problemDetail.setTitle("Internal Server Error");
        problemDetail.setDetail(
                "Unexpected error"
        );
        problemDetail.setProperty("errorCode", "INTERNAL_ERROR");
        return problemDetail;
    }
}
