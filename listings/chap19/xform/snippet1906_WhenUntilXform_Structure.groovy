package xform

// checks that our skeleton contains no typos
new GroovyShell().parse '''
import org.codehaus.groovy.ast.*
import org.codehaus.groovy.control.*
import org.codehaus.groovy.transform.*

@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
class WhenUntilTransform implements ASTTransformation {
    void visit(ASTNode[] nodes, SourceUnit unit) {
        // we’ll fill in the gaps!
    }
}
'''
