import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.ast.stmt.ReturnStatement

def ast = new AstBuilder().buildFromSpec {
  returnStatement {
    constructorCall(Date) {
      argumentList {}
    }
  }
}

assert ast[0] instanceof ReturnStatement
