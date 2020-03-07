package com.thoughtworks.school.parkinglot.model;

import java.util.List;

public class FirstAvailableStrategy implements ParkingStrategy {

  @Override
  public ParkingLot apply(List<ParkingLot> parkingLots) {
    return parkingLots.stream().filter(ParkingLot::isAvailable).findFirst().orElse(null);
  }
}
