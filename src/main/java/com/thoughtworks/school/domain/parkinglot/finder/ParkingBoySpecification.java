package com.thoughtworks.school.domain.parkinglot.finder;

import com.thoughtworks.school.domain.parkinglot.parking.ParkingLotSpecification;
import lombok.Value;

@Value
public class ParkingBoySpecification implements ParkingLotSpecification {
  private String parkingBoyId;
}
