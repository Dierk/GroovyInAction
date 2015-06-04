package v02.integration

abstract class CaseRobotBaseScript extends RobotBaseScript {
  def invokeMethod(String name, args) {                           //#1
    getBinding().robot."${name.toLowerCase()}"(*args)             //#2
  }
}
//#1 Intercept method invocation
//#2 Mixed-case script calls become lowercase robot calls
