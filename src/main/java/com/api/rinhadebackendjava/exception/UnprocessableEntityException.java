package com.api.rinhadebackendjava.exception;

import org.springframework.http.HttpStatus;

public class UnprocessableEntityException extends ApiException {

  public UnprocessableEntityException(String message) {
    super(HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase(), message, HttpStatus.UNPROCESSABLE_ENTITY.value());
  }
}
