package com.thoughtworks.school.parkingmanager;

import com.thoughtworks.school.parkingmanager.model.ParkingManager;

public interface ParkingManagerRepository {

  ParkingManager find();

  void save(ParkingManager parkingManager);
}
