class ClassWithProperties {
    def       someProperty
    public    someField
    private   somePrivateField
}

def obj = new ClassWithProperties()

def store = []
obj.properties.each { property ->
    store += property.key
    store += property.value
}
assert store.contains('someProperty')
assert store.contains('someField')
assert store.contains('somePrivateField')
assert store.contains('class')

assert obj.properties.size() == 4

// new: all the above are fields
// regardless of visibility modifier
