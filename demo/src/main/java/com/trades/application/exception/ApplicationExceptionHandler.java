/*
 * package com.trades.application.exception;
 * 
 * import org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.ControllerAdvice; import
 * org.springframework.web.bind.annotation.ExceptionHandler; import
 * org.springframework.web.bind.annotation.ResponseStatus;
 * 
 * @ControllerAdvice public class ApplicationExceptionHandler {
 * 
 * @ExceptionHandler(ResourceNotFoundException.class) public
 * ResponseEntity<Error> handleException(ResourceNotFoundException e) { Error
 * error = new Error(HttpStatus.NOT_FOUND, e.getLocalizedMessage()); return new
 * ResponseEntity<>(error, error.getHttpStatus()); }
 * 
 * }
 */