package com.api.rinhadebackendjava.controller;

import com.api.rinhadebackendjava.exception.ApiError;
import com.api.rinhadebackendjava.exception.BadRequestException;
import com.api.rinhadebackendjava.exception.NotFoundException;
import com.api.rinhadebackendjava.exception.UnprocessableEntityException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ControllerExceptionHandler {


  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ApiError> notFoundException(final NotFoundException e) {

    ApiError apiError = new ApiError(e.getCode(), e.getDescription(), e.getStatusCode());
    return ResponseEntity.status(apiError.getStatus()).body(apiError);
  }

  @ExceptionHandler(UnprocessableEntityException.class)
  public ResponseEntity<ApiError> unprocessableEntityException(final UnprocessableEntityException e) {

    ApiError apiError = new ApiError(e.getCode(), e.getDescription(), e.getStatusCode());
    return ResponseEntity.status(apiError.getStatus()).body(apiError);
  }

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<ApiError> badRequest(final BadRequestException e) {

    ApiError apiError = new ApiError(e.getCode(), e.getDescription(), e.getStatusCode());
    return ResponseEntity.status(apiError.getStatus()).body(apiError);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest req) {
    ApiError apiError = new ApiError(HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase(),
        e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY.value());
    return ResponseEntity.status(apiError.getStatus()).body(apiError);
  }
}
