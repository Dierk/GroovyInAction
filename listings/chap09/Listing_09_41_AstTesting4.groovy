import org.codehaus.groovy.tools.ast.TransformTestHelper
import static groovy.test.GroovyAssert.shouldFail
import static org.codehaus.groovy.control.CompilePhase.*

def DATE_FMT = /\w{3} \w{3} \d\d \d\d:\d\d:\d\d \S{3,9} \d{4}/

def folder = new File('src/main/groovy/regina')
def source = new File(folder, 'CompiledAtASTTransformation.groovy')
def transform = getClass().classLoader.parseClass(source).newInstance()

def helper = new TransformTestHelper(transform, PARSING)
def clazz = helper.parse(' class MyClass {} ')
shouldFail(MissingMethodException) {
  clazz.getCompileTime()
}

helper = new TransformTestHelper(transform, CONVERSION)
clazz = helper.parse(' class MyClass {} ')
assert clazz.getCompiledTime()
assert clazz.getCompiledTime() =~ DATE_FMT
