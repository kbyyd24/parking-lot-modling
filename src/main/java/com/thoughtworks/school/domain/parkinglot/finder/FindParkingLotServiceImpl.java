package com.thoughtworks.school.domain.parkinglot.finder;

import com.thoughtworks.school.domain.parkinglot.parking.FindParkingLotService;
import com.thoughtworks.school.domain.parkinglot.parking.ParkingLot;
import com.thoughtworks.school.domain.parkinglot.parking.ParkingLotFinderFactory;
import com.thoughtworks.school.domain.parkinglot.parking.ParkingLotSpecification;

public class FindParkingLotServiceImpl implements FindParkingLotService {
  private final ParkingLotFinderFactory parkingLotFinderFactory;

  public FindParkingLotServiceImpl(ParkingLotFinderFactory parkingLotFinderFactory) {
    this.parkingLotFinderFactory = parkingLotFinderFactory;
  }

  @Override
  public ParkingLot find(ParkingLotSpecification specification) {
    return parkingLotFinderFactory.create(specification).findParkingLot();
  }
}
