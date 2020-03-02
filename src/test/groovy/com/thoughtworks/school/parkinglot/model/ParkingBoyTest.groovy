package com.thoughtworks.school.parkinglot.model

import com.thoughtworks.school.parkinglot.exception.InvalidReceiptException
import com.thoughtworks.school.parkinglot.exception.NoAvailableParkingLotException
import spock.lang.Specification

class ParkingBoyTest extends Specification {

  ParkingBoy parkingBoy

  void setup() {
    parkingBoy = new ParkingBoy()
  }

  void cleanup() {
    parkingBoy == null
  }

  def "should add parking lot at last success"() {
    given:
    parkingBoy.addNextParkingLot(new ParkingLot(1))
    def parkingLot = new ParkingLot(1)

    when:
    parkingBoy.addNextParkingLot(parkingLot)

    then:
    parkingBoy.parkingLots[1].id == parkingLot.id
  }

  def "should remove parking lot success"() {
    given:
    parkingBoy.addNextParkingLot(new ParkingLot(1))
    def parkingLot = new ParkingLot(1)

    when:
    parkingBoy.removeParkingLot(parkingLot)

    then:
    !parkingBoy.parkingLots.contains(parkingLot)
  }

  def "should park car success when parking boy has available parking lot"() {
    given:
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

  def "should park car at first available parking lot"() {
    given:
    def notAvailableParkingLot = new ParkingLot(1)
    notAvailableParkingLot.park(new Car())
    def firstAvailableParkingLot = new ParkingLot(2)
    firstAvailableParkingLot.park(new Car())
    def secondAvailableParkingLot = new ParkingLot(3)
    [notAvailableParkingLot, firstAvailableParkingLot, secondAvailableParkingLot]
      .forEach { parkingBoy.addNextParkingLot(it) }
    def car = new Car()

    when:
    def receipt = parkingBoy.park(car)

    then:
    receipt.parkingLotId == firstAvailableParkingLot.id
  }

  def "should throw exception if parking boy has no available parking lot"() {
    given:
    def parkingLot = new ParkingLot(1)
    parkingLot.park(new Car())
    parkingBoy.addNextParkingLot(parkingLot)

    when:
    parkingBoy.park(new Car())

    then:
    thrown(NoAvailableParkingLotException.class)
  }

  def "should pick up car success"() {
    given:
    def parkingLot = new ParkingLot(1)
    parkingBoy.addNextParkingLot(parkingLot)
    def car = new Car()
    def receipt = parkingBoy.park(car)

    when:
    Car pickedUpCar = parkingBoy.pickUp(receipt)

    then:
    pickedUpCar == car
    parkingLot.validReceipts.size() == 0
  }

  def "should throw exception when pick up car by an invalid receipt"() {
    given:
    parkingBoy.addNextParkingLot(new ParkingLot(1))
    def car = new Car()
    def parkingLotId = parkingBoy.park(car).parkingLotId
    def invalidReceipt = new Receipt(parkingLotId, "any", car)

    when:
    parkingBoy.pickUp(invalidReceipt)

    then:
    thrown(InvalidReceiptException.class)
  }

  def "should throw exception when pick car by a receipt already used"() {
    given:
    parkingBoy.addNextParkingLot(new ParkingLot(1))
    def car = new Car()
    def receipt = parkingBoy.park(car)
    parkingBoy.pickUp(receipt)

    when:
    parkingBoy.pickUp(receipt)

    then:
    thrown(InvalidReceiptException.class)
  }
}
