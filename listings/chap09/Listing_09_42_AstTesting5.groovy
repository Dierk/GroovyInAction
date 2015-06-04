import groovy.transform.ASTTest
import org.codehaus.groovy.ast.stmt.ForStatement
import org.codehaus.groovy.control.CompilePhase

@ASTTest(phase=CompilePhase.SEMANTIC_ANALYSIS, value={       //#A
  lookup('anchor').each { n ->                               //#B
    assert n instanceof ForStatement                         //#C
  }
})
void doSomething() {
  println 'Hello, Groovy!'
  anchor: for (int i=0; i<10;i++) { println "Iteration $i" } //#D
}
//#A annotate an enclosing node
//#B call lookup to find a node labeled with “anchor”
//#C perform assertion on each matching node
//#D use a label on the node
