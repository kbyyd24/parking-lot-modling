package com.thoughtworks.school.domain.parkinglot.policy

import com.thoughtworks.school.domain.parkinglot.parking.ParkingLot
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

  def "should return null when not found available parking lot"() {
    when:
    def parkingLot = strategy.apply([new ParkingLot(0)])

    then:
    parkingLot == null
  }
}
