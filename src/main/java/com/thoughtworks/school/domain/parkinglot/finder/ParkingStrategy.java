package com.thoughtworks.school.domain.parkinglot.finder;

import com.thoughtworks.school.domain.parkinglot.parking.ParkingLot;
import java.util.List;

public interface ParkingStrategy {

  ParkingLot apply(List<ParkingLot> parkingLots);
}
