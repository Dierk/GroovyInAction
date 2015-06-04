import groovy.transform.*

interface Term {}

@Canonical
class Value implements Term {
  def content
}

@Canonical
class Add implements Term {
  def left, right
}

@Canonical
class Mult implements Term {
  def left, right
}

def term =
    new Mult(new Value('a'), new Add(new Value('b'), new Value('c')))

@Newify([Value, Mult, Add])
def term2 = Mult(Value('a'), Add(Value('b'), Value('c')))

import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.customizers.ASTTransformationCustomizer

def config = new CompilerConfiguration()
config.addCompilationCustomizers(
    new ASTTransformationCustomizer(                    //#1
        value: [Value, Mult, Add], Newify)              //#1
)
def shell = new GroovyShell(
    this.class.classLoader, new Binding(), config)      //#2

def term3 = shell.evaluate '''
    Mult(                                               //#3
        Value('a'),                                     //#3
        Add(                                            //#3
            Value('b'),                                 //#3
            Value('c')                                  //#3
        )                                               //#3
    )                                                   //#3
'''

assert term3.toString() == 'Mult(Value(a), Add(Value(b), Value(c)))'
//#1 Pass annotation and parameters to customizer
//#2 Pass config to GroovyShell
//#3 Implicit Newify
