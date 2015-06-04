import groovy.transform.ToString
import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.customizers.*

def conf = new CompilerConfiguration()
def astCustomizer = new ASTTransformationCustomizer(ToString)       //#1
def sourceAwareCustomizer =
    new SourceAwareCustomizer(astCustomizer)                        //#2
sourceAwareCustomizer.baseNameValidator = {                         //#3
  name -> name.endsWith 'Bean'
}
conf.addCompilationCustomizers(sourceAwareCustomizer)

def gcl = new GroovyClassLoader(getClass().classLoader, conf)       //#4
def clazz = gcl.parseClass '''
class MrBean { String first, last }
''', 'MrBean.groovy'
def result = clazz.newInstance()
result.first = 'Rowan'
result.last = 'Atkinson'
assert result.toString() == 'MrBean(Rowan, Atkinson)'
//#1 Create ToString AST customizer
//#2 Wrap into a source aware customizer
//#3 Create a basename filter
//#4 Use conf with GroovyClassLoader
