def numParams (Closure closure){
  closure.getMaximumNumberOfParameters()
}

assert numParams { one -> }      == 1
assert numParams { one, two -> } == 2

def paramTypes (Closure closure){
  closure.getParameterTypes()
}

assert paramTypes { String s -> } == [String]
assert paramTypes { Number n, Date d -> } == [Number, Date]
