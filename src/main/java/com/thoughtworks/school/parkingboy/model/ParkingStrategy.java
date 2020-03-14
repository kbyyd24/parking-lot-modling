package com.thoughtworks.school.parkingboy.model;

import com.thoughtworks.school.parkinglot.model.ParkingLot;
import java.util.List;

public interface ParkingStrategy {

  ParkingLot apply(List<ParkingLot> parkingLots);
}
