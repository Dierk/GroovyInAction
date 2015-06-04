package v02

import v02.model.Robot                            //#A
import static v02.model.Direction.*               //#B

def robot = new Robot()

robot.move left
//#A Import Robot class from model package
//#B Use static import for directions
