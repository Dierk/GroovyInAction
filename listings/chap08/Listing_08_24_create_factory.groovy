import java.awt.Dimension

Class.metaClass.make = { Object[] args ->
    delegate.metaClass.invokeConstructor(*args)
}

assert new HashMap()        == HashMap.make()
assert new Integer(42)      == Integer.make(42)
assert new Dimension(2, 3)  == Dimension.make(2, 3)