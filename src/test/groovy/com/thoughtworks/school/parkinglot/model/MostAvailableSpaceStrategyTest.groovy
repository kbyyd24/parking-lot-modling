package com.thoughtworks.school.parkinglot.model

import spock.lang.Specification

class MostAvailableSpaceStrategyTest extends Specification {
  def strategy = new MostAvailableSpaceStrategy()

  def "should return parking lot which has most available space"() {
    expect:
    strategy.apply(parkingLots) == expectedParkingLot

    where:
    parkingLots                              | expectedParkingLot
    [1, 0, 2].collect { new ParkingLot(it) } | parkingLots.get(2)
    [0, 2, 1].collect { new ParkingLot(it) } | parkingLots.get(1)
    [3, 2, 1].collect { new ParkingLot(it) } | parkingLots.get(0)
  }
}
