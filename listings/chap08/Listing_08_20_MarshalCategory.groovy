@Category(Integer)                                     //#1
class IntegerMarshal {
  String marshal() {
    toString()                                         //#2
  }
}

@Category(String)
class StringMarshal {
  Integer unMarshal() {
    this.toInteger()                                   //#3
  }
}

use ([IntegerMarshal, StringMarshal]) {                //#4
  assert   1.marshal()   == "1"
  assert "1".unMarshal() == 1
}
//#1 Specify the type of self
//#2 Implicit this
//#3 Explicit this
//#4 List variant of use
