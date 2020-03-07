package com.thoughtworks.school.parkinglot.model;

import java.util.List;

public interface ParkingStrategy {

  ParkingLot apply(List<ParkingLot> parkingLots);
}
