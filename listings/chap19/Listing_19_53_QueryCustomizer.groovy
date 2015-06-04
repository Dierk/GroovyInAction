import org.codehaus.groovy.ast.ClassCodeVisitorSupport
import org.codehaus.groovy.ast.ClassNode
import org.codehaus.groovy.ast.expr.MethodCallExpression
import org.codehaus.groovy.ast.expr.StaticMethodCallExpression
import org.codehaus.groovy.classgen.GeneratorContext
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.control.customizers.CompilationCustomizer
import org.codehaus.groovy.syntax.SyntaxException
import static org.codehaus.groovy.control.CompilePhase.*

new CompilationCustomizer(SEMANTIC_ANALYSIS) {
  void call(SourceUnit src, GeneratorContext ctxt, ClassNode cn) {
    new ClassCodeVisitorSupport() {
      boolean inQueryClosure = false

      void visitStaticMethodCallExpression(                           //#1
          StaticMethodCallExpression call) {                          //#1
        if (call.method == 'query' && call.ownerType.name == 'Query') //#1
          inQueryClosure = true
        super.visitStaticMethodCallExpression(call)
        if (inQueryClosure) 
          inQueryClosure = false
      }

      void visitMethodCallExpression(MethodCallExpression call) {
        def methName = call.method.text 
        if (
          inQueryClosure &&                                         //#2
          call.objectExpression.text == 'this' &&                   //#2
          !(methName in ['select', 'from', 'where'])) {             //#2
            src.addError(new SyntaxException(                       //#3
              "No query verb ${methName}, only select/from/where",  //#3
              call.lineNumber, call.columnNumber))                  //#3
        }
        super.visitMethodCallExpression(call)
      }

      SourceUnit getSourceUnit() { src }
    }.visitClass(cn)
  }
}

Query.query {
    select all from table where true
}
//#1 Track when inside Query.query
//#2 Check  method calls are to known methods
//#3 Add error if unknown methods found
