package com.thoughtworks.school.parkinglot.model;

import com.thoughtworks.school.parkinglot.annotation.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ParkingBoy {

  private List<ParkingLot> parkingLots = new ArrayList<>();

  public void addNextParkingLot(ParkingLot parkingLot) {
    parkingLots.add(parkingLot);
  }

  public void removeParkingLot(ParkingLot parkingLot) {
    parkingLots.removeIf(parkingLot::equals);
  }

  public Receipt park(Car car) {
    return parkingLots.get(0).park(car);
  }
}
