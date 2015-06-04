import static groovy.test.GroovyAssert.shouldFail

def e = shouldFail '''
import groovy.transform.TypeChecked

@TypeChecked
class Sleuth {
  String firstName
  String lastName                                        //#A
  String getFullName() { "$firstName $lastname" }        //#B
}
'''.trim()
println e.message
assert e.message.contains(
    '[Static type checking] - The variable [lastname] is undeclared')
//#A Uppercase N in lastName
//#B Incorrect lowercase n in lastname
