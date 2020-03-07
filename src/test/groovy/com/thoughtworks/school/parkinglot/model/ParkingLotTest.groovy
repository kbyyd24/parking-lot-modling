package com.thoughtworks.school.parkinglot.model

import com.thoughtworks.school.parkinglot.exception.InvalidReceiptException
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
    receipt.token != null
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

  def 'should pick up car success when receipt is valid'() {
    given:
    def parkingLot = new ParkingLot(2)
    def car = new Car()
    def receipt = parkingLot.park(car)

    when:
    Car pickedUpCar = parkingLot.pickUp(receipt)

    then:
    car == pickedUpCar
  }

  def "should throw exception when pick up car by an invalid receipt"() {
    given:
    def parkingLot = new ParkingLot(2)
    def car = new Car()
    parkingLot.park(car)
    def invalidReceipt = new Receipt(parkingLot.id, null)

    when:
    parkingLot.pickUp(invalidReceipt)

    then:
    thrown(InvalidReceiptException.class)
  }

  def "should throw exception when pick up car by a receipt already used"() {
    given:
    def parkingLot = new ParkingLot(2)
    def car = new Car()
    def receipt = parkingLot.park(car)
    parkingLot.pickUp(receipt)

    when:
    parkingLot.pickUp(receipt)

    then:
    thrown(InvalidReceiptException.class)
  }

  def "should return true when check if parking lot is available given there are some parking space"() {
    given:
    def parkingLot = new ParkingLot(1)

    when:
    def available = parkingLot.isAvailable()

    then:
    available
  }

  def "should return false when check if parking lot is available given there are not parking space"() {
    given:
    def parkingLot = new ParkingLot(0)

    when:
    def available = parkingLot.isAvailable()

    then:
    !available
  }

  def "should return available space count"() {
    expect:
    def parkingLot = new ParkingLot(capacity)
    parkInCarNumber.times { parkingLot.park(new Car()) }
    parkingLot.availableSpaceCount() == availableSpaceCount

    where:
    capacity | parkInCarNumber | availableSpaceCount
    3        | 0               | 3
    5        | 3               | 2
  }
}
