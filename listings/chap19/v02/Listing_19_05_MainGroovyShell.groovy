package v02

def shell = new GroovyShell()                                    //#1
shell.evaluate '''                                               //#2
import v02.model.Robot                                           //#2
import static v02.model.Direction.*                              //#2
                                                                 //#2
def robot = new Robot()                                          //#2
                                                                 //#2
robot.move left                                                  //#2
'''                                                              //#2
//#1 Instantiates the shell
//#2 Shell evaluates inline script
