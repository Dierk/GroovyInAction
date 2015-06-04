package v02.integration

import v02.model.Direction

class CustomBinding extends Binding {
  private Map variables

  CustomBinding(Map vars) {
    this.variables = [
        *: vars,                                                    //#1
        *: Direction.values().collectEntries { [(it.name()): it] }  //#1
    ]
  }

  def getVariable(String name) {
    variables[name.toLowerCase()]                                   //#2
  }

}
//#1 Merge constructor variables and Direction constants
//#2 Variable lookup via lowercase key
