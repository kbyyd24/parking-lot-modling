package com.thoughtworks.school.parkingboy;

import com.thoughtworks.school.parkingboy.model.ParkingBoy;

public interface ParkingBoyRepository {

  ParkingBoy findById(String parkingBoyId);

  void save(ParkingBoy parkingBoy);
}
