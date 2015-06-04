package v03.model

import groovy.transform.TupleConstructor

@TupleConstructor
class Speed {
  Number amount
  Unit unit

  String toString() { "$amount $unit/h" }
}
