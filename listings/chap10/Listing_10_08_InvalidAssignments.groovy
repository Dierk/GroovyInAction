import static groovy.test.GroovyAssert.shouldFail

def e = shouldFail '''
@groovy.transform.TypeChecked
void testAssignmentsShouldThrowCompilationErrors() {
  Set set = new Object()                              //#A
  byte b = 200L                                       //#B
  List<Integer> list = ['Richard', 'Mary']            //#C
  int prim = null                                     //#D
}
'''

def message = e.message
[
  'Cannot assign',
  'Possible loss of precision',
  'Incompatible generic argument types',
  'Cannot assign value of type java.lang.Object to variable of type int'
].each{ assert message.contains(it) }
//#A Cannot cast Object into Set
//#B Possible loss of precision
//#C Wrong generics
//#D Primitives cannot be null
