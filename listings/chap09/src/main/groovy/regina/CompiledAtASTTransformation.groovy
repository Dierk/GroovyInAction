package regina

import org.codehaus.groovy.ast.*
import org.codehaus.groovy.transform.*
import org.codehaus.groovy.control.*
import org.codehaus.groovy.ast.builder.AstBuilder
import static groovyjarjarasm.asm.Opcodes.*

@GroovyASTTransformation(phase=CompilePhase.CONVERSION)
class CompiledAtASTTransformation implements ASTTransformation {

  private static final compileTime = new Date().toString()

  void visit(ASTNode[] astNodes, SourceUnit sourceUnit) {
    List classes = sourceUnit.ast?.classes
    classes.each { ClassNode clazz ->
      clazz.addMethod(makeMethod())
    }
  }

  MethodNode makeMethod() {
    def ast = new AstBuilder().buildFromSpec {
      method('getCompiledTime', ACC_PUBLIC | ACC_STATIC, String) {
        parameters {}
        exceptions {}
        block {
          returnStatement {
            constant(compileTime)
          }
        }
        annotations {}
      }
    }
    ast[0]
  }
}
