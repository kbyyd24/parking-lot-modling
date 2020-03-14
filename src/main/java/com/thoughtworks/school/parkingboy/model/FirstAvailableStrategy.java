package com.thoughtworks.school.parkingboy.model;

import com.thoughtworks.school.parkinglot.model.ParkingLot;
import java.util.List;

public class FirstAvailableStrategy implements ParkingStrategy {

  @Override
  public ParkingLot apply(List<ParkingLot> parkingLots) {
    return parkingLots.stream().filter(ParkingLot::isAvailable).findFirst().orElse(null);
  }
}
