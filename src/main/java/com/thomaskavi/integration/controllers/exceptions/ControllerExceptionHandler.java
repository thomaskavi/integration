package com.thomaskavi.integration.controllers.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.thomaskavi.integration.services.exceptions.EmailException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(EmailException.class)
  public ResponseEntity<StandardError> email(EmailException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.BAD_REQUEST;
    StandardError err = new StandardError();
    err.setTimestamp(Instant.now());
    err.setStatus(status.value());
    err.setError("Email error");
    err.setMessage(e.getMessage());
    err.setPath(request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }
}
