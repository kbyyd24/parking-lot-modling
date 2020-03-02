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

  def "should remove parking lot success"() {
    given:
    def parkingBoy = new ParkingBoy()
    parkingBoy.addNextParkingLot(new ParkingLot(1))
    def parkingLot = new ParkingLot(1)

    when:
    parkingBoy.removeParkingLot(parkingLot)

    then:
    !parkingBoy.parkingLots.contains(parkingLot)
  }

  def "should park car success when parking boy has available parking lot"() {
    given:
    def parkingBoy = new ParkingBoy()
    def parkingLot = new ParkingLot(1)
    parkingBoy.addNextParkingLot(parkingLot)
    def car = new Car()

    when:
    Receipt receipt = parkingBoy.park(car)

    then:
    receipt.parkingLotId == parkingLot.id
    receipt.token != null
    receipt.car == car
  }
}
