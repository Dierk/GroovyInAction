def until(boolean condition, Closure closure) {
  while (!condition) closure()
}

def counter = 0

until(counter == 10) {            //#1
  counter++
}
//#1 Eagerly calculated expression
