package com.thoughtworks.school.parkinglot.model;

import static java.util.Collections.emptySet;
import static java.util.stream.Collectors.toSet;

import com.thoughtworks.school.parkinglot.annotation.Entity;
import com.thoughtworks.school.parkinglot.exception.InvalidReceiptException;
import com.thoughtworks.school.parkinglot.exception.ParkingLotNotAvailableException;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Stream;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Entity
@EqualsAndHashCode(of = {"id"})
public class ParkingLot {
  @Getter private String id;
  private int capacity;
  private Collection<Receipt> validReceipts = emptySet();

  public ParkingLot(int capacity) {
    this.id = UUID.randomUUID().toString();
    this.capacity = capacity;
  }

  public Receipt park(Car car) {
    if (!this.isAvailable()) {
      throw new ParkingLotNotAvailableException();
    }
    Receipt receipt = new Receipt(this.id, UUID.randomUUID().toString(), car);
    validReceipts = Stream.concat(validReceipts.stream(), Stream.of(receipt)).collect(toSet());
    return receipt;
  }

  public Car pickUp(Receipt receipt) {
    Car car =
        validReceipts.stream()
            .filter(receipt::equals)
            .findFirst()
            .map(Receipt::getCar)
            .orElseThrow(InvalidReceiptException::new);
    validReceipts =
        validReceipts.stream()
            .filter(validReceipt -> !receipt.equals(validReceipt))
            .collect(toSet());
    return car;
  }

  public Boolean isAvailable() {
    return capacity > validReceipts.size();
  }
}
