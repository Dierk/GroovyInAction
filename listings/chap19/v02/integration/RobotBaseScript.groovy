package v02.integration

import v02.model.Direction

abstract class RobotBaseScript extends Script {
  void move(Direction dir) {
    this.binding.robot.move dir
  }
}
