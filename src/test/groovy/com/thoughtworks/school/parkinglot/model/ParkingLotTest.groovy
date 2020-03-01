package com.thoughtworks.school.parkinglot.model

import spock.lang.Specification

class ParkingLotTest extends Specification {

  def 'should park car success when the parking lot is available'() {
    given:
    def parkingLot = new ParkingLot(2)
    def car = new Car()

    when:
    Receipt receipt = parkingLot.park(car)

    then:
    receipt.parkingLotId == parkingLot.id
    receipt.car == car
  }
}
