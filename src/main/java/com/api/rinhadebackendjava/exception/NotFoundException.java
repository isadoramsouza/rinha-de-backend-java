package com.api.rinhadebackendjava.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ApiException {

  public NotFoundException(String message) {
    super(HttpStatus.NOT_FOUND.getReasonPhrase(), message,HttpStatus.NOT_IMPLEMENTED.value());
  }
}
