import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.ast.stmt.BlockStatement
import org.codehaus.groovy.ast.stmt.ReturnStatement

def ast = new AstBuilder().buildFromString('new Date()')
assert ast[0] instanceof BlockStatement
assert ast[0].statements[0] instanceof ReturnStatement
