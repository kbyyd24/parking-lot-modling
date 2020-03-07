package com.thoughtworks.school.parkinglot.model;

import java.util.Collection;

public class ParkingManager {

  private Collection<ParkingBoy> parkingBoys;

  public ParkingManager(Collection<ParkingBoy> parkingBoys) {
    this.parkingBoys = parkingBoys;
  }

  public ParkingBoy dispatchOneParkingBoy() {
    return parkingBoys.stream().findAny().orElse(null);
  }
}
