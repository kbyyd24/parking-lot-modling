package com.thoughtworks.school.parkinglot.model;

import com.thoughtworks.school.parkinglot.annotation.Entity;
import java.util.List;

@Entity
public class ParkingBoy {

  private List<ParkingLot> parkingLots;
  private ParkingStrategy strategy;

  public ParkingBoy(List<ParkingLot> parkingLots, ParkingStrategy strategy) {
    this.parkingLots = parkingLots;
    this.strategy = strategy;
  }

  public ParkingLot findOneParkingLot() {
    return strategy.apply(parkingLots);
  }
}
