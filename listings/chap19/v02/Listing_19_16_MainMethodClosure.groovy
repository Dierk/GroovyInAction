package v02

import v02.model.*

def robot = new Robot()
def binding = new Binding(
    robot: robot,
    move: robot.&move,                                              //#1
    *: Direction.values().collectEntries { [(it.name()): it] }
)

def shell = new GroovyShell(this.class.classLoader, binding)
shell.evaluate '''
    move left
'''
//#1 Method closure reference to robot’s move() method
