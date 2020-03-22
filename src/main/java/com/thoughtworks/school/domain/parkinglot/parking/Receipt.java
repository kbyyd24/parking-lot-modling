package com.thoughtworks.school.domain.parkinglot.parking;

import com.thoughtworks.school.annotation.ValueObject;
import lombok.Value;

@ValueObject
@Value
public class Receipt {
  String parkingLotId;
  String token;
}
