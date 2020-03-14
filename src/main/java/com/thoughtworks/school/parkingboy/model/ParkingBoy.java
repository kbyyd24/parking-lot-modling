package com.thoughtworks.school.parkingboy.model;

import com.thoughtworks.school.annotation.Entity;
import com.thoughtworks.school.exception.NoAvailableParkingLotException;
import com.thoughtworks.school.parkinglot.model.ParkingLot;
import java.util.List;
import java.util.Optional;

@Entity
public class ParkingBoy {

  private List<ParkingLot> parkingLots;
  private ParkingStrategy strategy;

  public ParkingBoy(List<ParkingLot> parkingLots, ParkingStrategy strategy) {
    this.parkingLots = parkingLots;
    this.strategy = strategy;
  }

  public ParkingLot findOneParkingLot() {
    return Optional.ofNullable(strategy.apply(parkingLots))
        .orElseThrow(NoAvailableParkingLotException::new);
  }
}
