import org.codehaus.groovy.ast.*
import org.codehaus.groovy.transform.*
import java.lang.annotation.*
import org.codehaus.groovy.control.*

@Retention(RetentionPolicy.SOURCE)                              //#A
@Target([ElementType.METHOD])                                   //#A
@GroovyASTTransformationClass(classes = [MainTransformation])   //#A
@interface Main {}                                              //#A

import static groovyjarjarasm.asm.Opcodes.*
import static org.codehaus.groovy.ast.ClassHelper.VOID_TYPE
import static org.codehaus.groovy.ast.tools.GeneralUtils.*

@GroovyASTTransformation(phase = CompilePhase.INSTRUCTION_SELECTION)
class MainTransformation implements ASTTransformation {
  private NO_EXCEPTIONS = ClassNode.EMPTY_ARRAY
  private STRING_ARRAY = ClassHelper.STRING_TYPE.makeArray()

  void visit(ASTNode[] astNodes, SourceUnit sourceUnit) {
    if (astNodes?.size() != 2) return                           //#B
    if (!(astNodes[0] instanceof AnnotationNode)) return        //#B
    if (astNodes[0].classNode.name != Main.name) return         //#B
    if (!(astNodes[1] instanceof MethodNode)) return            //#B

    def targetMethod = astNodes[1]
    def targetClass = targetMethod.declaringClass
    def targetInstance = ctorX(targetClass)
    def callTarget = callX(targetInstance, targetMethod.name)   //#C
    def mainBody = block(stmt(callTarget))
    def visibility = ACC_STATIC | ACC_PUBLIC
    def parameters = params(param(STRING_ARRAY, 'args'))
    targetClass.addMethod('main', visibility,                   //#D
        VOID_TYPE, parameters, NO_EXCEPTIONS, mainBody)         //#D
  }
}

new GroovyShell(getClass().classLoader).evaluate '''
class Greeter {
  @Main
  def greet() {
    println "Hello from the greet() method!"
  }
}
'''
//#A Annotation class definition
//#B Defensive programming via guard clauses
//#C new Greeter().greet()
//#D add public static void main method
