package com.thoughtworks.school.parkingboy;

import com.thoughtworks.school.parkingboy.model.ParkingBoy;
import com.thoughtworks.school.parkinglot.model.Car;
import com.thoughtworks.school.parkinglot.model.Receipt;

public class ParkingBoyApplicationService {

  private final ParkingBoyRepository parkingBoyRepository;
  private final ParkingBoyParkService parkingBoyParkService;

  public ParkingBoyApplicationService(ParkingBoyRepository parkingBoyRepository, ParkingBoyParkService parkingBoyParkService) {
    this.parkingBoyRepository = parkingBoyRepository;
    this.parkingBoyParkService = parkingBoyParkService;
  }

  public Receipt park(String parkingBoyId, Car car) {
    ParkingBoy parkingBoy = parkingBoyRepository.findById(parkingBoyId);
    Receipt receipt = parkingBoyParkService.park(parkingBoy, car);
    parkingBoyRepository.save(parkingBoy);
    return receipt;
  }
}
