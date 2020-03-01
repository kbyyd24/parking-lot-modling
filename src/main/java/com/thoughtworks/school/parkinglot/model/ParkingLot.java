package com.thoughtworks.school.parkinglot.model;

import static java.util.Collections.emptySet;

import com.thoughtworks.school.parkinglot.annotation.Entity;
import java.util.Collection;
import java.util.UUID;

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
    return new Receipt(this.id, null, car);
  }
}
