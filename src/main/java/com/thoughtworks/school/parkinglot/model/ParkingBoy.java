package com.thoughtworks.school.parkinglot.model;

import com.thoughtworks.school.parkinglot.annotation.Entity;
import com.thoughtworks.school.parkinglot.exception.NoAvailableParkingLotException;
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
    return parkingLots.stream()
        .filter(ParkingLot::isAvailable)
        .findFirst()
        .map(parkingLot -> parkingLot.park(car))
        .orElseThrow(NoAvailableParkingLotException::new);
  }

  public Car pickUp(Receipt receipt) {
    return parkingLots.get(0).pickUp(receipt);
  }
}
