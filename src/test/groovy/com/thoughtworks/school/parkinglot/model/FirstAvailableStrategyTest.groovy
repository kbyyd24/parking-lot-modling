package com.thoughtworks.school.parkinglot.model

import com.thoughtworks.school.parkinglot.exception.NoAvailableParkingLotException
import spock.lang.Specification

class FirstAvailableStrategyTest extends Specification {
  private FirstAvailableStrategy strategy = new FirstAvailableStrategy()

  def "should return first available parking lot"() {
    expect:
    strategy.apply(parkingLots) == expectedParkingLot

    where:
    parkingLots                            | expectedParkingLot
    [new ParkingLot(1), new ParkingLot(2)] | parkingLots.get(0)
    [new ParkingLot(0), new ParkingLot(2)] | parkingLots.get(1)
    [new ParkingLot(1), new ParkingLot(0)] | parkingLots.get(0)
  }

  def "should throw exception when not found available parking lot"() {
    when:
    strategy.apply([new ParkingLot(0)])

    then:
    thrown(NoAvailableParkingLotException.class)
  }
}
