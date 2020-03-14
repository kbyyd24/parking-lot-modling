package com.thoughtworks.school.parkingboy;

import com.thoughtworks.school.parkingboy.model.ParkingBoy;
import com.thoughtworks.school.parkinglot.model.Car;
import com.thoughtworks.school.parkinglot.model.Receipt;

public class ParkingBoyParkService {

  public Receipt park(ParkingBoy parkingBoy, Car car) {
    return parkingBoy.findOneParkingLot().park(car);
  }
}
