package com.thoughtworks.school.domain.parkinglot.parking;

public interface ParkingLotFinderFactory {

  ParkingLotFinder create(ParkingLotSpecification specification);

}
