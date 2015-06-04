package v03.model

import groovy.transform.TupleConstructor

@TupleConstructor
class Distance {
  Number amount
  Unit unit

  Speed div(Duration dur) {
    new Speed(amount, unit)
  }

  String toString() { "$amount$unit" }
}
