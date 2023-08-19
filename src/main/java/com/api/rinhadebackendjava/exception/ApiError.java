package com.api.rinhadebackendjava.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ApiError {

  private String error;

  private String message;

  private Integer status;
}
