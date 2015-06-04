import org.codehaus.groovy.ast.ClassHelper
import org.codehaus.groovy.ast.expr.*
import org.codehaus.groovy.ast.stmt.ReturnStatement

def ast = new ReturnStatement(
    new ConstructorCallExpression(
        ClassHelper.make(Date),
        ArgumentListExpression.EMPTY_ARGUMENTS
    )
)

assert ast instanceof ReturnStatement
