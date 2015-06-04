package v02

import v02.model.*

def binding = new Binding(
    robot: new Robot(),
    *: Direction.values().collectEntries { [(it.name()): it] }   //#1
)

def shell = new GroovyShell(this.class.classLoader, binding)
shell.evaluate '''
    robot.move left
'''
//#1 Inject directions using spread-map operator
