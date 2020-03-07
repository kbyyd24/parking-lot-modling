package com.thoughtworks.school.parkinglot.model

import spock.lang.Specification

class FirstAvailableStrategyTest extends Specification {
  private FirstAvailableStrategy strategy = new FirstAvailableStrategy()

  def "should_return_first_available_parking_lot"() {
    expect:
    strategy.apply(parkingLots) == expectedParkingLot

    where:
    parkingLots                            | expectedParkingLot
    [new ParkingLot(1), new ParkingLot(2)] | parkingLots.get(0)
    [new ParkingLot(0), new ParkingLot(2)] | parkingLots.get(1)
    [new ParkingLot(1), new ParkingLot(0)] | parkingLots.get(0)
  }
}
