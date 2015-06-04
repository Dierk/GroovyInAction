import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.ast.stmt.ReturnStatement

def ast = new AstBuilder().buildFromCode {
  new Date()
}
assert ast[0].statements[0] instanceof ReturnStatement
