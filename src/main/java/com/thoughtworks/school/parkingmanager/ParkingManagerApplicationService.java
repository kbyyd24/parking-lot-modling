package com.thoughtworks.school.parkingmanager;

import com.thoughtworks.school.parkinglot.model.Car;
import com.thoughtworks.school.parkinglot.model.Receipt;
import com.thoughtworks.school.parkingmanager.model.ParkingManager;

public class ParkingManagerApplicationService {
  private final ParkingManagerRepository parkingManagerRepository;
  private final ParkingManagerParkService parkingManagerParkService;

  public ParkingManagerApplicationService(ParkingManagerRepository parkingManagerRepository,
      ParkingManagerParkService parkingManagerParkService) {
    this.parkingManagerRepository = parkingManagerRepository;
    this.parkingManagerParkService = parkingManagerParkService;
  }

  public Receipt park(Car car) {
    ParkingManager parkingManager = parkingManagerRepository.find();
    Receipt receipt = parkingManagerParkService.park(parkingManager, car);
    parkingManagerRepository.save(parkingManager);
    return receipt;
  }
}
