package com.thoughtworks.school.application;

import com.thoughtworks.school.domain.parkinglot.finder.ParkingBoySpecification;
import com.thoughtworks.school.domain.parkinglot.finder.ParkingManagerSpecification;
import com.thoughtworks.school.domain.parkinglot.parking.Car;
import com.thoughtworks.school.domain.parkinglot.parking.FindParkingLotService;
import com.thoughtworks.school.domain.parkinglot.parking.ParkingLot;
import com.thoughtworks.school.domain.parkinglot.parking.Receipt;
import com.thoughtworks.school.repository.ParkingLotRepository;

public class ParkingLotApplicationService {

  private final FindParkingLotService findParkingLotService;
  private final ParkingLotRepository parkingLotRepository;

  public ParkingLotApplicationService(
      FindParkingLotService findParkingLotService, ParkingLotRepository parkingLotRepository) {
    this.findParkingLotService = findParkingLotService;
    this.parkingLotRepository = parkingLotRepository;
  }

  public Receipt parkByParkingBoy(String parkingBoyId, Car car) {
    ParkingBoySpecification parkingBoySpecification = new ParkingBoySpecification(parkingBoyId);
    ParkingLot parkingLot = findParkingLotService.find(parkingBoySpecification);
    Receipt receipt = parkingLot.park(car);
    parkingLotRepository.save(parkingLot);
    return receipt;
  }

  public Receipt parkByParkingManager(Car car) {
    ParkingManagerSpecification parkingManagerSpecification = new ParkingManagerSpecification();
    ParkingLot parkingLot = findParkingLotService.find(parkingManagerSpecification);
    Receipt receipt = parkingLot.park(car);
    parkingLotRepository.save(parkingLot);
    return receipt;
  }
}
