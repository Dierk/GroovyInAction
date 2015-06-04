class DynamicPretender {
    Closure whatToDo = { name -> "accessed $name"}  //#1
    def propertyMissing(String name) {
        whatToDo(name)                              //#2
    }
}
def one = new DynamicPretender()
assert one.hello == 'accessed hello'
one.whatToDo     = { name -> name.size() }          //#3
assert one.hello == 5