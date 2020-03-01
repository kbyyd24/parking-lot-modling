package com.thoughtworks.school.parkinglot.model;

import static java.util.Collections.emptySet;

import com.thoughtworks.school.parkinglot.annotation.Entity;
import com.thoughtworks.school.parkinglot.exception.InvalidReceiptException;
import com.thoughtworks.school.parkinglot.exception.ParkingLotNotAvailableException;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
public class ParkingLot {
  private String id;
  private int capacity;
  private Collection<Receipt> validReceipts = emptySet();

  public ParkingLot(int capacity) {
    this.id = UUID.randomUUID().toString();
    this.capacity = capacity;
  }

  public Receipt park(Car car) {
    if (capacity <= validReceipts.size()) {
      throw new ParkingLotNotAvailableException();
    }
    Receipt receipt = new Receipt(this.id, UUID.randomUUID().toString(), car);
    validReceipts =
        Stream.concat(validReceipts.stream(), Stream.of(receipt)).collect(Collectors.toSet());
    return receipt;
  }

  public Car pickUp(Receipt receipt) {
    return validReceipts.stream()
        .filter(receipt::equals)
        .findFirst()
        .map(Receipt::getCar)
        .orElseThrow(InvalidReceiptException::new);
  }
}
