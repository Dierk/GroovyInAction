class ClassWithTypedAndUntypedMethods {

  static void main(args) {                             //#1
    def some = new ClassWithTypedAndUntypedMethods()
    some.publicVoidMethod()
    assert 'hi' == some.publicUntypedMethod()
    assert 'ho' == some.publicTypedMethod()
    combinedMethod()                                   //#A
  }

  void publicVoidMethod() { }

  def publicUntypedMethod() {
    return 'hi'
  }

  String publicTypedMethod() {
    return 'ho'
  }

  private static final void combinedMethod() { }
}
//#1 Implicit public
//#A Call static method of current class
