package v03.integration

import v03.model.*

class DistanceCategory {
  static Distance getCentimeters(Number num) {
    new Distance(num, DistanceUnit.centimeter)
  }

  static Distance getMeters(Number num) {
    new Distance(num, DistanceUnit.meter)
  }

  static Distance getKilometers(Number num) {
    new Distance(num, DistanceUnit.kilometer)
  }

  static Distance getCm(Number num) { getCentimeters(num) }

  static Distance getM(Number num) { getMeters(num) }

  static Distance getKm(Number num) { getKilometers(num) }
}
