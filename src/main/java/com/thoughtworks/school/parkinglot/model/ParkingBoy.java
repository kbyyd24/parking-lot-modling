package com.thoughtworks.school.parkinglot.model;

import com.thoughtworks.school.parkinglot.annotation.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ParkingBoy {

  private List<ParkingLot> parkingLots = new ArrayList<>();
}
