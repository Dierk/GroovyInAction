package v03

import v03.model.Robot
import static v03.model.Direction.*

def robot = new Robot()

robot.with {       //#1
  move left            //#2
  move forward         //#2
}
//#1 Demarcate block where robot will be delegate
//#2 Streamlined syntax available within block
