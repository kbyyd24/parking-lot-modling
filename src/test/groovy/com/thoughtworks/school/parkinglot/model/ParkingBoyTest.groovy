package com.thoughtworks.school.parkinglot.model

import spock.lang.Specification

class ParkingBoyTest extends Specification {

  def "should add parking lot at last success"() {
    given:
    def parkingBoy = new ParkingBoy()
    parkingBoy.addNextParkingLot(new ParkingLot(1))
    def parkingLot = new ParkingLot(1)

    when:
    parkingBoy.addNextParkingLot(parkingLot)

    then:
    parkingBoy.parkingLots[1].id == parkingLot.id
  }
}
