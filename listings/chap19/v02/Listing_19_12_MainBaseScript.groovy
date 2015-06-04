package v02

import v02.model.*

def binding = new Binding(
    robot: new Robot(),
    *: Direction.values().collectEntries { [(it.name()): it] }
)

def shell = new GroovyShell(this.class.classLoader, binding)
shell.evaluate '''
@BaseScript(v02.integration.RobotBaseScript)
import groovy.transform.BaseScript

move left
'''
