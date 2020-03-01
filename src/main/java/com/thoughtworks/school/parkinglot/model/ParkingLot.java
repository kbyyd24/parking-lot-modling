package com.thoughtworks.school.parkinglot.model;

import static java.util.Collections.emptySet;

import com.thoughtworks.school.parkinglot.annotation.Entity;
import java.util.Collection;

@Entity
public class ParkingLot {
  private String id;
  private int capacity;
  private Collection<Receipt> validReceipts = emptySet();
}
