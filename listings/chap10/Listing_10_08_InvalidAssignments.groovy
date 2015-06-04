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
// massage to account for error message typo fixed in 2.4.1
def message = e.message.replaceAll('loose of precision', 'loss of precision')
[
  'Cannot assign value of type java.lang.Object to variable of ' +
      'type java.util.Set',
    // typo loose should be loss in 2.4.1
  'Possible loss of precision from long to byte',
  'Incompatible generic argument types. Cannot assign ' +
      'java.util.List <java.lang.String> to: java.util.List <Integer>',
  'Cannot assign value of type java.lang.Object to variable of type int'
].each{ assert message.contains(it) }
//#A Cannot cast Object into Set
//#B Possible loss of precision
//#C Wrong generics
//#D Primitives cannot be null
