package v02

import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.customizers.*
import v02.model.Robot

def binding = new Binding(robot: new Robot())                       //#1

def importCustomizer = new ImportCustomizer()                       //#2
importCustomizer.addStaticStars 'v02.model.Direction'               //#3

def config = new CompilerConfiguration()
config.addCompilationCustomizers importCustomizer                   //#4

def shell = new GroovyShell(this.class.classLoader, binding, config)  //#5
shell.evaluate '''
    robot.move left
'''
//#1 Inject only variables into binding
//#2 Create import customizer
//#3 Direction.* enum values statically imported with star import
//#4 Import customizer added to compiler configuration
//#5 Compiler configuration passed to GroovyShell
