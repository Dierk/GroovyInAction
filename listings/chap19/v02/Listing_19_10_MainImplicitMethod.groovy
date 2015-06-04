package v02

import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.customizers.*
import v02.model.Robot

def binding = new Binding(robot: new Robot())

def importCustomizer = new ImportCustomizer()
importCustomizer.addStaticStars 'v02.model.Direction'

def config = new CompilerConfiguration()
config.addCompilationCustomizers importCustomizer

def shell = new GroovyShell(this.class.classLoader, binding, config)
shell.evaluate '''
    move left
''' + '''
    def move(dir) {
        robot.move dir
    }
'''