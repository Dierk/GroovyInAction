import org.codehaus.groovy.ast.stmt.ReturnStatement
import static org.codehaus.groovy.ast.ClassHelper.make
import static org.codehaus.groovy.ast.tools.GeneralUtils.*

def ast = returnS(ctorX(make(Date)))
assert ast instanceof ReturnStatement
