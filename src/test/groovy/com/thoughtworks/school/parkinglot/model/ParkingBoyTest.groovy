package com.thoughtworks.school.parkinglot.model

import com.thoughtworks.school.parkinglot.exception.NoAvailableParkingLotException
import spock.lang.Specification

class ParkingBoyTest extends Specification {
  def "should return parking lot selected by strategy"(ParkingStrategy strategy, List<ParkingLot> parkingLots, ParkingLot expectedParkingLot) {
    expect:
    def parkingBoy = new ParkingBoy(parkingLots, strategy)
    parkingBoy.findOneParkingLot() == expectedParkingLot

    where:
    strategy                                              | parkingLots                              | expectedParkingLot
    new FirstAvailableStrategy()                          | [0, 1].collect { new ParkingLot(it) }    | parkingLots.get(1)
    { lots -> lots.reverse().find({ it.isAvailable() }) } | [1, 2, 0].collect { new ParkingLot(it) } | parkingLots.get(1)
  }

  def "should throw exception when no available parking lot found"() {
    given:
    def parkingBoy = new ParkingBoy([], { return null })

    when:
    parkingBoy.findOneParkingLot()

    then:
    thrown(NoAvailableParkingLotException.class)
  }
}
