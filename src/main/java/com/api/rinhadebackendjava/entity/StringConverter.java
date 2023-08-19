package com.api.rinhadebackendjava.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.emptyList;

@Converter
public class StringConverter implements AttributeConverter<List<String>, String> {

  @Override
  public String convertToDatabaseColumn(List<String> stringList) {
    return stringList != null ? String.join(",", stringList) : null;
  }

  @Override
  public List<String> convertToEntityAttribute(String string) {
    return string != null ? Arrays.asList(string.split(",")) : emptyList();
  }
}