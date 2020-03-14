package com.thoughtworks.school.parkingmanager;

import com.thoughtworks.school.parkinglot.model.Car;
import com.thoughtworks.school.parkinglot.model.Receipt;
import com.thoughtworks.school.parkingmanager.model.ParkingManager;

public class ParkingManagerParkService {

  public Receipt park(ParkingManager parkingManager, Car car) {
    return parkingManager.dispatchOneParkingBoy().findOneParkingLot().park(car);
  }
}
