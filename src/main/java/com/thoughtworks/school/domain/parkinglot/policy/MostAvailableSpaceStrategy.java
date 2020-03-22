package com.thoughtworks.school.domain.parkinglot.policy;

import static java.util.Comparator.comparing;

import com.thoughtworks.school.domain.parkinglot.parking.ParkingLot;
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
