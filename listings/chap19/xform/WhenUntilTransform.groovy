package xform

import org.codehaus.groovy.ast.*
import org.codehaus.groovy.ast.expr.*
import org.codehaus.groovy.ast.stmt.*
import org.codehaus.groovy.control.*
import org.codehaus.groovy.transform.*

@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
class WhenUntilTransform implements ASTTransformation {
    void visit(ASTNode[] nodes, SourceUnit unit) {
        ClassNode annotatedClass = nodes[1]
        new ClassCodeVisitorSupport() {
            def currentMethod
            def currentBlock
            def currentStatement
            void visitMethod(MethodNode method) {
                currentMethod = method
                super.visitMethod(method)
            }
            void visitBlockStatement(BlockStatement block) {
                currentBlock = block
                super.visitBlockStatement(block)
            }
            void visitExpressionStatement(ExpressionStatement statement) {
                currentStatement = statement
                super.visitExpressionStatement(statement)
            }
            void visitMethodCallExpression(MethodCallExpression mCall) {
                if (
                    mCall.objectExpression instanceof VariableExpression &&
                    mCall.objectExpression.variable == 'this' &&
                    mCall.method instanceof ConstantExpression &&
                    mCall.method.value == 'when' &&
                    mCall.arguments.expressions.size() == 1
                ) {
                    def idx = currentBlock.statements.findIndexOf {
                        it == currentStatement
                    }
                    if (idx + 1 >= currentBlock.statements.size()) {
                        addError(
                            "The when instruction has no body.", mCall)
                    } else {
                        def whenCode = currentBlock.statements[idx + 1]
                        def closureExp = new ClosureExpression(
                            Parameter.EMPTY_ARRAY, whenCode)
                        closureExp.variableScope = new VariableScope()
                        closureExp.variableScope.parent =
                            currentBlock.variableScope
                        mCall.arguments.addExpression(closureExp)
                        currentBlock.statements.remove(idx + 1)
                    }
                }
                super.visitMethodCallExpression(mCall)
            }
            protected SourceUnit getSourceUnit() { unit }
        }.visitClass(annotatedClass)
    }
}
