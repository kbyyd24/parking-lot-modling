package com.thoughtworks.school.domain.parkinglot.policy;

import com.thoughtworks.school.domain.parkinglot.parking.ParkingLot;
import java.util.List;

public class FirstAvailableStrategy implements ParkingStrategy {

  @Override
  public ParkingLot apply(List<ParkingLot> parkingLots) {
    return parkingLots.stream().filter(ParkingLot::isAvailable).findFirst().orElse(null);
  }
}
