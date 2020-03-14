package com.thoughtworks.school.parkingmanager.model

import com.thoughtworks.school.parkingboy.model.FirstAvailableStrategy
import com.thoughtworks.school.parkingboy.model.MostAvailableSpaceStrategy
import com.thoughtworks.school.parkingboy.model.ParkingBoy
import com.thoughtworks.school.parkinglot.model.ParkingLot
import spock.lang.Specification
import spock.lang.Unroll

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

  @Unroll
  def "should return #result when #situation"() {
    expect:
    parkingManager.hasAvailableParkingLot() == result

    where:
    parkingManager                                                                          | result | situation
    new ParkingManager([new ParkingBoy([new ParkingLot(1)], new FirstAvailableStrategy())]) | true   | "has available parking lot"
    new ParkingManager([new ParkingBoy([new ParkingLot(0)], new FirstAvailableStrategy())]) | false  | "does not have available parking lot"
    new ParkingManager([])                                                                  | false  | "does not have any parking boy"
  }
}
