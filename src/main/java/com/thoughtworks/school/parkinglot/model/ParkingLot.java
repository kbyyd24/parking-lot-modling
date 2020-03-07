package com.thoughtworks.school.parkinglot.model;

import com.thoughtworks.school.parkinglot.annotation.Entity;
import com.thoughtworks.school.parkinglot.exception.InvalidReceiptException;
import com.thoughtworks.school.parkinglot.exception.ParkingLotNotAvailableException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Entity
@EqualsAndHashCode(of = {"id"})
public class ParkingLot {
  @Getter private String id;
  private int capacity;
  private Map<Receipt, Car> currentParkingCars = new HashMap<>();

  public ParkingLot(int capacity) {
    this.id = UUID.randomUUID().toString();
    this.capacity = capacity;
  }

  public Receipt park(Car car) {
    if (!this.isAvailable()) {
      throw new ParkingLotNotAvailableException();
    }
    Receipt receipt = new Receipt(this.id, UUID.randomUUID().toString(), car);
    currentParkingCars.put(receipt, car);
    return receipt;
  }

  public Car pickUp(Receipt receipt) {
    return Optional.ofNullable(currentParkingCars.remove(receipt))
        .orElseThrow(InvalidReceiptException::new);
  }

  public Boolean isAvailable() {
    return capacity > currentParkingCars.size();
  }

  public int availableSpaceCount() {
    return capacity - currentParkingCars.size();
  }
}
