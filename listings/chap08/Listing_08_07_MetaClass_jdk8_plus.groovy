MetaClass mc = String.metaClass
final Object[] NO_ARGS = []
assert   1  == mc.respondsTo("toString", NO_ARGS).size()
assert   5  == mc.properties.size()
assert  90  <  mc.methods.size()
assert 200  <  mc.metaMethods.size()
assert ""   == mc.invokeMethod("","toString", NO_ARGS)
assert null == mc.invokeStaticMethod(String, "println", NO_ARGS)
assert ""   == mc.invokeConstructor(NO_ARGS)
