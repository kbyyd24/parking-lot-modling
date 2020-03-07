package com.thoughtworks.school.parkinglot.model;

import com.thoughtworks.school.parkinglot.annotation.ValueObject;
import lombok.Value;

@ValueObject
@Value
public class Receipt {
  String parkingLotId;
  String token;
}
