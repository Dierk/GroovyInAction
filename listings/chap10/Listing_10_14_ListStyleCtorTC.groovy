import org.codehaus.groovy.control.CompilationFailedException
import static groovy.test.GroovyAssert.shouldFail

def e = shouldFail CompilationFailedException, '''
    @groovy.transform.TypeChecked
    void alsoOneDimensional() {
        java.awt.Dimension d = [100]              //#A
    }
'''
assert e.message.contains(
    'No matching constructor found: java.awt.Dimension<init>(int)')
//#A Two parameters required. Compilation fails!
