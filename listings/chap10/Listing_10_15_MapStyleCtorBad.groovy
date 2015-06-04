import static groovy.test.GroovyAssert.shouldFail

def e = shouldFail '''
import groovy.transform.TypeChecked

class Athlete {
  String first
  String last
  int age
}

@TypeChecked
void ageInteger() {
  Athlete ok = [first: 'Michael', last: 'Jordan', age: 52]          //#A
}

@TypeChecked
void ageString() {
  Athlete bad = [first: 'Michael', last: 'Jordan', age: '52']       //#B
}

@TypeChecked
void ageStringNormal() {
  def alsoBad =
      new Athlete(first: 'Michael', last: 'Jordan', age: '52')      //#B
}
//#A Passes
//#B Fails
'''
assert e.message.contains(
    'Cannot assign value of type java.lang.String to variable of type int')
