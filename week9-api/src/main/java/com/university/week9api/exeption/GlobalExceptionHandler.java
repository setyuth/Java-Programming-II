package com.university.week9api.exeption;

import com.university.week9api.model.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * GlobalExceptionHandler — catches unhandled exceptions across ALL controllers.
 *
 * Without this, Spring Boot returns a generic white-label HTML error page
 * when something goes wrong. This handler intercepts exceptions and returns
 * clean JSON responses instead, making the API easier to use.
 *
 * @RestControllerAdvice  = applies to ALL @RestController classes in the project
 * @ExceptionHandler      = marks a method as the handler for a specific exception type
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles the case where a path variable or query param has the wrong type.
     * Example: GET /api/students/abc  (where abc should be an int)
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiResponse> handleTypeMismatch(
            MethodArgumentTypeMismatchException ex) {

        String message = "Invalid parameter '" + ex.getName() + "': " +
                "expected a " + ex.getRequiredType().getSimpleName() +
                " but received '" + ex.getValue() + "'";

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.error(message));
    }

    /**
     * Catches any other exception not handled elsewhere.
     * Returns 500 Internal Server Error.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.error("Server error: " + ex.getMessage()));
    }
}