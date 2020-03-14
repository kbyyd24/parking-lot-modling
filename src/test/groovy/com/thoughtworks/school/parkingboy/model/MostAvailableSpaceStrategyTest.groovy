package com.thoughtworks.school.parkingboy.model

import com.thoughtworks.school.parkinglot.model.ParkingLot
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

  def "should return null when not found most available space parking lot"() {
    when:
    def parkingLot = strategy.apply([])

    then:
    parkingLot == null
  }

  def "should return null when most available space parking lot is not available"() {
    when:
    def parkingLot = strategy.apply([new ParkingLot(0)])

    then:
    parkingLot == null
  }
}
