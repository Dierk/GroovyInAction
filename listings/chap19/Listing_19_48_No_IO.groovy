import org.codehaus.groovy.control.*
import org.codehaus.groovy.control.customizers.*

def secure = new SecureASTCustomizer()
secure.starImportsBlacklist = ['java.io.*']          //#1
secure.indirectImportCheckEnabled = true             //#2

def config = new CompilerConfiguration()
config.addCompilationCustomizers(secure)

def shell = new GroovyShell(config)

groovy.test.GroovyAssert.shouldFail {
  shell.evaluate '''                                 //#3
    new File('.')                                    //#3
  '''                                                //#3
}
//#1 Disallow java.io imports
//#2 Disallow explicit java.io class references
//#3 Evaluate violating script
