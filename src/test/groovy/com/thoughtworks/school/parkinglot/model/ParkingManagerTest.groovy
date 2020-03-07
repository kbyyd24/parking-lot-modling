package com.thoughtworks.school.parkinglot.model

import spock.lang.Specification

class ParkingManagerTest extends Specification {
  def "should return a parking boy"() {
    given:
    def parkingBoys = [new ParkingBoy([new ParkingLot(1)], new FirstAvailableStrategy()),
                       new ParkingBoy([new ParkingLot(2)], new MostAvailableSpaceStrategy())]
    def parkingManager = new ParkingManager(parkingBoys)

    when:
    def parkingBoy = parkingManager.dispatchOneParkingBoy()

    then:
    parkingBoy in parkingBoys
  }
}
