package com.thoughtworks.school.parkinglot.model;

import com.thoughtworks.school.parkinglot.annotation.ValueObject;
import lombok.Value;

@ValueObject
@Value
public class Receipt {
  private String token;
  private Car car;
}
