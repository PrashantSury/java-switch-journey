package com.prashant.coursepractice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(StudentNotFoundException.class)
    public ProblemDetail notFound(StudentNotFoundException ex) {

        ProblemDetail problemDetail =
                ProblemDetail.forStatus(HttpStatus.NOT_FOUND);

        problemDetail.setTitle("Student Not Found");
        problemDetail.setDetail(ex.getMessage());
        problemDetail.setProperty("errorCode", "STUDENT_NOT_FOUND");

        return problemDetail;
    }

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

    @ExceptionHandler(DuplicateEmailException.class)
    public ProblemDetail handleDuplicateEmail(DuplicateEmailException ex) {

        ProblemDetail problemDetail = ProblemDetail.forStatus(
                HttpStatus.CONFLICT
        );

        problemDetail.setTitle("Duplicate Email");
        problemDetail.setDetail("Email already exists. Please use a different email address.");
        problemDetail.setProperty("errorCode", "DUPLICATE_EMAIL");

        return problemDetail;
    }

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

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleException(Exception ex) {

        ProblemDetail problemDetail =
                ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        problemDetail.setTitle("Internal Server Error");
        problemDetail.setDetail(
                "Required json body is bad or empty."
        );
        problemDetail.setProperty("errorCode", "BAD_JSON_OR_EMPTY_JSON");
        return problemDetail;
    }
}
