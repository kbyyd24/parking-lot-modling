package com.thoughtworks.school.parkinglot.model;

import static java.util.Comparator.comparing;

import java.util.List;

public class MostAvailableSpaceStrategy implements ParkingStrategy {

  @Override
  public ParkingLot apply(List<ParkingLot> parkingLots) {
    return parkingLots
        .parallelStream()
        .filter(ParkingLot::isAvailable)
        .max(comparing(ParkingLot::availableSpaceCount))
        .orElse(null);
  }
}
