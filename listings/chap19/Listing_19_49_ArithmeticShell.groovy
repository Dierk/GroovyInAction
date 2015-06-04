import org.codehaus.groovy.ast.expr.*
import org.codehaus.groovy.ast.stmt.*
import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.customizers.ImportCustomizer
import org.codehaus.groovy.control.customizers.SecureASTCustomizer

import static org.codehaus.groovy.syntax.Types.*

def imports = new ImportCustomizer().addStaticStars('java.lang.Math')
def secure = new SecureASTCustomizer()

secure.with {
  closuresAllowed = false                                           //#1
  methodDefinitionAllowed = false                                   //#2

  importsWhitelist = []                                             //#3
  staticImportsWhitelist = []                                       //#3
  staticStarImportsWhitelist = ['java.lang.Math']                   //#3

  tokensWhitelist = [                                               //#4
    PLUS, MINUS, MULTIPLY, DIVIDE, MOD, POWER, PLUS_PLUS,
    MINUS_MINUS, COMPARE_EQUAL, COMPARE_NOT_EQUAL,
    COMPARE_LESS_THAN, COMPARE_LESS_THAN_EQUAL,
    COMPARE_GREATER_THAN, COMPARE_GREATER_THAN_EQUAL,
  ]

  constantTypesClassesWhiteList = [                                 //#5
    Integer, Float, Long, Double, BigDecimal,
    Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE
  ]

  receiversClassesWhiteList = [                                     //#6
    Math, Integer, Float, Double, Long, BigDecimal
  ]

  statementsWhitelist = [                                           //#7
    BlockStatement, ExpressionStatement
  ]

  expressionsWhitelist = [                                          //#8
    BinaryExpression,       ConstantExpression,
    MethodCallExpression,   StaticMethodCallExpression,
    ArgumentListExpression, PropertyExpression,
    UnaryMinusExpression,   UnaryPlusExpression,
    PrefixExpression,       PostfixExpression,
    TernaryExpression,      ElvisOperatorExpression,
    BooleanExpression,      ClassExpression
  ]
}
def config = new CompilerConfiguration()
config.addCompilationCustomizers(imports, secure)
def shell = new GroovyShell(config)
def result = shell.evaluate('1+cos(PI/2)')                          //#9
assert result == 1
//#1 Disable closures
//#2 Disable methods
//#3 Disable imports and static imports except lava.lang.Math
//#4 Allow mathematical tokens
//#5 Allow number types
//#6 Allow number receivers
//#7 Allow only blocks and statements
//#8 Allow only math-related expressions
//#9 Run the shell
