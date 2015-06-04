import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.ast.*

def approxPI = 3.14G
def ast = new AstBuilder().buildFromString(
    CompilePhase.CLASS_GENERATION,
    false,
    'static double getTwoPI() { def pi = ' + approxPI + '; pi * 2 }'
)

assert ast[1] instanceof ClassNode
def method = ast[1].methods.find { it.name == 'getTwoPI' }
assert method instanceof MethodNode
