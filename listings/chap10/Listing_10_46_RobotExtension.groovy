unresolvedVariable { var ->                                  //#1
  if (var.name == 'robot') {                                 //#1
    storeType(var, lookupClassNodeFor('Robot'))              //#1
    handled = true                                           //#1
  }
}

unresolvedProperty { pexp ->                                 //#2
  if (getType(pexp.objectExpression) == int_TYPE &&          //#2
      pexp.propertyAsString == 'meters') {                   //#2
    storeType(pexp, long_TYPE)                               //#2
    handled = true                                           //#2
  }
}
//#1 An unresolved 'robot' variable has type Robot
//#2 An unresolved 'meters' property on an int has type long