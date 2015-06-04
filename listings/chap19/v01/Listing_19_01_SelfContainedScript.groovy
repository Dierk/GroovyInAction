package v01

import static Direction.*                //#2

enum Direction {                         //#1
  left, right, forward, backward         //#1
}                                        //#1

class Robot {                            //#3
  void move(Direction dir) {             //#4
    println "robot moved $dir"           //#4
  }                                      //#4
}

def robot = new Robot()                  //#5

robot.move left                          //#6
//#1 The enum definition
//#2 Make constants available in script
//#3 Define class
//#4 Method definition
//#5 Create instance
//#6 Instruct robot to move
