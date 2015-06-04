def a = 2
def b = 3

assert a + b == a.plus(b)
assert a - b == a.minus(b)
assert a * b == a.multiply(b)
assert a / b == a.div(b)
assert a % b == a.mod(b)

a = 2
assert ++a == 2.next()
assert a == 3

a = 2
assert a++ == 2
assert a == 3

a = 2
assert --a == 2.previous()
assert a == 1

a = 2
assert a-- == 2
assert a == 1

a = 2
assert -a == a.unaryMinus()
// added in 2.2.0-beta-2
//assert (+a) == a.unaryPlus()

assert a ** b == a.power(b)

assert (a | b) == a.or(b)
assert (a & b) == a.and(b)
assert (a ^ b) == a.xor(b)

// added in 2.2.0-beta-2
//assert ~a == a.bitwiseNegate()

a = [foo:5]
assert a['foo'] == a.getAt('foo')
a['bar'] = 6
assert a == [foo:5, bar:6]
a = [foo:5]
a.putAt('bar', 6)
assert a == [foo:5, bar:6]

a = 2
assert a << b == a.leftShift(b)
assert a >> b == a.rightShift(b)
assert a >>> b == a.rightShiftUnsigned(b)

enum AgeBand {
  OLD, YOUNG
  def isCase(Person p) {
    p.age in 0..21 == (this == AgeBand.YOUNG)
  }
}
class Person {
  String name
  int age
}
def classify(p) {
  switch(p) {
    case AgeBand.OLD: return "$p.name is old!"
    case AgeBand.YOUNG: return "$p.name is young!"
  }
}
assert classify(new Person(name: 'Tom', age: 15)) == 'Tom is young!'
assert classify(new Person(name: 'Mary', age: 25)) == 'Mary is old!'

assert a in b == b.isCase(a)
assert (a != b) == !(a == b)
assert a <=> b == a.compareTo(b)
assert a > b == a.compareTo(b) > 0
assert a >= b == a.compareTo(b) >= 0
assert a < b == a.compareTo(b) < 0
assert a <= b == a.compareTo(b) <= 0
assert a as Integer == a.asType(Integer)

