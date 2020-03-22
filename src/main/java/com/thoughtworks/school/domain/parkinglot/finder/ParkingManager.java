package com.thoughtworks.school.domain.parkinglot.finder;

import com.thoughtworks.school.domain.parkinglot.exception.NoAvailableParkingLotException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Random;

public class ParkingManager {

  private Collection<ParkingBoy> parkingBoys;

  public ParkingManager(Collection<ParkingBoy> parkingBoys) {
    this.parkingBoys = parkingBoys;
  }

  public ParkingBoy dispatchOneParkingBoy() {
    int index = Math.abs(new Random().nextInt()) % parkingBoys.size();
    return new ArrayList<>(parkingBoys).get(index);
  }

  public boolean hasAvailableParkingLot() {
    return parkingBoys.stream()
        .map(
            parkingBoy -> {
              try {
                return parkingBoy.findOneParkingLot();
              } catch (NoAvailableParkingLotException ignore) {
                return null;
              }
            })
        .anyMatch(Objects::nonNull);
  }
}
