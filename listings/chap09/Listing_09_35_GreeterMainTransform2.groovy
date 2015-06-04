import org.codehaus.groovy.ast.*
import org.codehaus.groovy.ast.stmt.BlockStatement
import org.codehaus.groovy.transform.*
import java.lang.annotation.*
import org.codehaus.groovy.control.*

@Retention(RetentionPolicy.SOURCE)
@Target([ElementType.METHOD])
@GroovyASTTransformationClass(classes = [MainTransformation2])
@interface Main2 {
  boolean merge() default false                                       //#A
}

import static org.codehaus.groovy.ast.ClassHelper.VOID_TYPE
import static org.codehaus.groovy.ast.tools.GeneralUtils.*

@GroovyASTTransformation(phase = CompilePhase.INSTRUCTION_SELECTION)
class MainTransformation2 extends AbstractASTTransformation {
  private MSG1 = "@Main2 annotation use requires no-arg constructor!"
  private MSG2 = "@Main2 annotation used but main already exists!"
  private NO_EXCEPTIONS = ClassNode.EMPTY_ARRAY
  private NO_PARAMS = Parameter.EMPTY_ARRAY
  private STRING_ARRAY = ClassHelper.STRING_TYPE.makeArray()

  void visit(ASTNode[] astNodes, SourceUnit sourceUnit) {
    init(astNodes, sourceUnit)
    def (anno, mainMethod) = astNodes

    boolean merge = getMemberValue(anno, 'merge')                     //#B
    def mainClass = mainMethod.declaringClass
    def callTarget
    if (mainMethod.isStatic()) {
      callTarget = mainClass
    } else {
      if (!hasNoArgConstructor(mainClass)) {
        addError(MSG1, mainMethod)                                    //#C
        return
      }
      callTarget = ctorX(mainClass)
    }
    def callStatement = stmt(callX(callTarget, mainMethod.name))
    def parameters = params(param(STRING_ARRAY, 'args'))
    def existingMain = mainClass.getDeclaredMethod('main', parameters)
    if (existingMain && !merge) {
      addError(MSG2, mainMethod)                                      //#D
      return
    }

    if (existingMain) {
      if (existingMain.code instanceof BlockStatement) {
        existingMain.code.addStatement(callStatement)                 //#E
      } else {
        block(existingMain.code).addStatement(callStatement)          //#F
      }
    } else {
      mainClass.addMethod('main', ACC_STATIC | ACC_PUBLIC,
          VOID_TYPE, parameters, NO_EXCEPTIONS, block(callStatement))
    }
  }

  private hasNoArgConstructor(mainClass) {
    def constructors = mainClass.declaredConstructors
    def explicitNoArg = constructors.find { it.parameters == NO_PARAMS }
    def implicitNoArg = constructors.size() == 0
    implicitNoArg || explicitNoArg
  }
}

new GroovyShell(getClass().classLoader).evaluate '''
class Greeter {
    public static void main(String[] args) {
        println 'Hello from main()'
    }

    @Main2(merge=true)
    def greet() {
        println "Hello from the greet() instance method!"
    }

    @Main2(merge=true)
    static greet2() {
        println "Hello from the greet2() static method!"
    }
}
'''
//#A Define an annotation attribute
//#B Read annotation attribute value
//#C Indicate error if missing no-arg constructor
//#D Indicate error unless explicit merging
//#E Handle block statement case
//#F Handle single statement case
