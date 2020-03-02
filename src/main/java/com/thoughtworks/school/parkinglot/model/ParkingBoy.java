package com.thoughtworks.school.parkinglot.model;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

  private List<ParkingLot> parkingLots = new ArrayList<>();

  public void addNextParkingLot(ParkingLot parkingLot) {
    parkingLots.add(parkingLot);
  }
}
