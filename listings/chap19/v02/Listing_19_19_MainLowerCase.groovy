package v02

import org.codehaus.groovy.control.*
import v02.integration.*
import v02.model.*

def binding = new CustomBinding(robot: new Robot())

def config = new CompilerConfiguration()
config.scriptBaseClass = CaseRobotBaseScript.name                 //#A

def shell = new GroovyShell(this.class.classLoader, binding, config)
shell.evaluate '''
    mOVe lEfT
'''
//#A Specify script base class
