import static groovy.test.GroovyAssert.shouldFail

def e = shouldFail '''
import groovy.transform.TypeChecked

class Logger {
  static void print(Closure<String> messageProvider) {
    println "Received message : ${messageProvider()}"
  }
}

@TypeChecked
void testMessage() {
  def returnsString = { 'Hello, Groovy!' }
  def returnsInt = { int x, int y -> x + y }
  Logger.print(returnsString)            //#1
  Logger.print(returnsInt)               //#2
}
'''
println e.message.readLines().find{ it.contains('[Static ') }
assert e.message.contains(
    'Cannot call Logger#print(groovy.lang.Closure <java.lang.String>)' +
        ' with arguments [groovy.lang.Closure <java.lang.Integer>]')
//#1 Passes
//#2 Compilation fails
