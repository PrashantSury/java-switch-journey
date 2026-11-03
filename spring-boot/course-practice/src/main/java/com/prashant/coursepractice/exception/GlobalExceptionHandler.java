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
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // ---- Domain exceptions (thrown by the service layer) ----

    /**
     * {@link StudentNotFoundException} -> 404 Not Found (errorCode STUDENT_NOT_FOUND).
     * Thrown by StudentService for an unknown id.
     * Controller: GET /{id}, PUT /{id}, DELETE /{id}.
     * Tests: StudentControllerTest.GetStudentById, UpdateStudent, DeleteStudent.
     */
    @ExceptionHandler(StudentNotFoundException.class)
    public ProblemDetail notFound(StudentNotFoundException ex) {

        ProblemDetail problemDetail =
                ProblemDetail.forStatus(HttpStatus.NOT_FOUND);

        problemDetail.setTitle("Student Not Found");
        problemDetail.setDetail(ex.getMessage());
        problemDetail.setProperty("errorCode", "STUDENT_NOT_FOUND");

        return problemDetail;
    }

    /**
     * {@link DuplicateEmailException} -> 409 Conflict (errorCode DUPLICATE_EMAIL).
     * Thrown by StudentService when the email belongs to another student.
     * Controller: POST /api/students (create) and PUT /{id} (update).
     * Tests: StudentControllerTest.CreateStudent#createDuplicateEmail,
     * UpdateStudent#updateWithAnotherStudentsEmail.
     */
    @ExceptionHandler(DuplicateEmailException.class)
    public ProblemDetail handleDuplicateEmail(DuplicateEmailException ex) {

        ProblemDetail problemDetail =
                ProblemDetail.forStatus(HttpStatus.CONFLICT);

        problemDetail.setTitle("Duplicate Email");
        problemDetail.setDetail("Email already exists. Please use a different email address.");
        problemDetail.setProperty("errorCode", "DUPLICATE_EMAIL");

        return problemDetail;
    }

    // ---- Bad client requests (400) ----

    /**
     * {@link MethodArgumentNotValidException} -> 400 Bad Request (errorCode VALIDATION_FAILED).
     * Raised by {@code @Valid @RequestBody} when a field breaks a bean-validation rule.
     * Controller: POST /api/students (create) and PUT /{id} (update).
     * Tests: StudentControllerTest.CreateStudent#createInvalid, #validationErrorsAreListed.
     */
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

    /**
     * {@link MissingServletRequestParameterException} -> 400 Bad Request
     * (errorCode MISSING_REQUEST_PARAMETER).
     * Raised when the required {@code name} query parameter is absent.
     * Controller: GET /api/students/search.
     * Tests: StudentControllerTest.SearchStudents#searchMissingName.
     */
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

    /**
     * {@link HttpMessageNotReadableException} -> 400 Bad Request (errorCode MALFORMED_REQUEST).
     * Raised when the request body is missing or is not valid JSON.
     * Controller: POST /api/students (create) and PUT /{id} (update).
     * Tests: StudentControllerTest.CreateStudent#malformedJsonReturnsProblemDetail.
     */
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

    // ---- Safety net (must stay last) ----

    /**
     * Catch-all for any exception no handler above matches -> 500 Internal Server Error
     * (errorCode INTERNAL_ERROR). Keep this LAST; it is the safety net, not the normal path.
     * Controller: any endpoint.
     * Tests: StudentControllerTest.CreateStudent#unsupportedMediaTypeReturns415 (the case
     * that exposed this handler turning client errors into 500).
     */
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
