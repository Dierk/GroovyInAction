class PropPretender {
    def propertyMissing(String name) {
        "accessed $name"
    }
}
def bounce = new PropPretender()
assert bounce.hello == 'accessed hello'