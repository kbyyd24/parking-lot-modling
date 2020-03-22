package com.thoughtworks.school.domain.parkinglot.finder;

import com.thoughtworks.school.annotation.ValueObject;
import com.thoughtworks.school.domain.parkinglot.exception.NoAvailableParkingLotException;
import com.thoughtworks.school.domain.parkinglot.parking.ParkingLot;
import com.thoughtworks.school.domain.parkinglot.parking.ParkingLotFinder;
import java.util.List;
import java.util.Optional;

@ValueObject
public class ParkingBoy implements ParkingLotFinder {

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

  @Override
  public ParkingLot findParkingLot() {
    return findOneParkingLot();
  }
}
