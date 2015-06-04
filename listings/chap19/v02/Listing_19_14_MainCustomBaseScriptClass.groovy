package v02

import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.customizers.*
import v02.integration.RobotBaseScript
import v02.model.*

def binding = new Binding(robot: new Robot())

def importCustomizer = new ImportCustomizer()
importCustomizer.addStaticStars Direction.name

def config = new CompilerConfiguration()
config.addCompilationCustomizers importCustomizer
config.scriptBaseClass = RobotBaseScript.name                   //#A

def shell = new GroovyShell(this.class.classLoader, binding, config)
shell.evaluate '''
    move left
'''
//#A Specify script base class