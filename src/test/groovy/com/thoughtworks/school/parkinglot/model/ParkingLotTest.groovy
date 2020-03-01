package com.thoughtworks.school.parkinglot.model

import com.thoughtworks.school.parkinglot.exception.ParkingLotNotAvailableException
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

  def 'should throw exception when the parking lot is not available'() {
    given:
    def parkingLot = new ParkingLot(1)
    parkingLot.park(new Car())

    when:
    parkingLot.park(new Car())

    then:
    thrown(ParkingLotNotAvailableException.class)
  }
}
