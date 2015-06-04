import groovy.transform.CompileStatic

class MyFramework {
  static int sizeOf(String s) { s.size() }                     //#1

  @CompileStatic
  static int staticSizeOf(String s) { s.size() }               //#2
}

String s = 'a happy new year!'
s.metaClass.size = { -> 5 }                                    //#3
assert s.size() == 5                                           //#4
assert MyFramework.sizeOf(s) == 5                              //#5
assert MyFramework.staticSizeOf(s) == 17                       //#6
//#1 sizeOf method uses dynamic dispatch
//#2 staticSizeOf method uses static dispatch
//#3 change metaclass so that size always returns 5
//#4 check that size returns 5
//#5 check that calling size from the framework returns 5
//#6 check that from statically compiled method returns the original size
