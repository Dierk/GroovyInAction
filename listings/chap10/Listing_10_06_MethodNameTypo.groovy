import static groovy.test.GroovyAssert.shouldFail

def e = shouldFail '''
@groovy.transform.TypeChecked
class Person {
  String name
  String getFullName() { name.toUppercase() }        //#A
}
'''
println e.message
assert e.message.contains(
    'Cannot find matching method java.lang.String#toUppercase()')
//#A Incorrect lowercase c
