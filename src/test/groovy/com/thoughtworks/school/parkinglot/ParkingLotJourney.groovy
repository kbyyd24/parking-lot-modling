package com.thoughtworks.school.parkinglot

import com.thoughtworks.school.parkinglot.model.*

static def thereIsAParkingManager() {
  def parkingLots = (1..10).collect({ new ParkingLot(10) })
  def parkingBoys = (1..2).collect({
    if (it == 1) {
      return new ParkingBoy((0..4).collect({ parkingLots[it] }), new FirstAvailableStrategy())
    } else {
      return new ParkingBoy((5..9).collect({ parkingLots[it] }), new MostAvailableSpaceStrategy())
    }
  })
  new ParkingManager(parkingBoys)
}

static def journey(ParkingManager parkingManager) {
  def car = new Car()

  println("Beginning journey...")

  def parkingBoy = parkingManager.dispatchOneParkingBoy()
  println("Get a parking boy with strategy: ${parkingBoy.strategy.class.simpleName}")

  def parkingLot = parkingBoy.findOneParkingLot()
  println("Get a parking lot with ${parkingLot.availableSpaceCount()} available spaces")

  def receipt = parkingLot.park(car)
  println("Park car success, get receipt with token ${receipt.token}")

  def pickedUpCar = parkingLot.pickUp(receipt)
  println("Pick up car success")

  assert car == pickedUpCar
  println("The journey finished.")
}

def parkingManager = thereIsAParkingManager()

journey(parkingManager)

