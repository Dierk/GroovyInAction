package v02

import v02.model.*

def binding = new Binding(
    robot:     new Robot(),
    left:      Direction.left,            //#1
    right:     Direction.right,           //#1
    forward:   Direction.forward,         //#1
    backward:  Direction.backward         //#1
)

def shell = new GroovyShell(this.class.classLoader, binding)
shell.evaluate '''
    robot.move left                       //#2
'''
//#1 Inject directions
//#2 Import free script
