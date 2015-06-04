package v03.integration

import v03.model.SuperBot

abstract class SuperBotBaseScript extends Script {
  // In some older version of Groovy there was a bug where @Lazy
  // and @Delegate didn't work together. If you have troubles,
  // comment out the existing line and replace with next line:
  // @Delegate SuperBot robot = new SuperBot()
  @Delegate @Lazy SuperBot robot = this.binding.robot
}
