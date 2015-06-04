class ClassWithTypedAndUntypedMethodParams {
  static void main(args) {
    assert 'untyped' == method(1)
    assert 'typed' == method('whatever')
    assert 'two args' == method(1, 2)
  }

  static method(arg) {
    return 'untyped'
  }

  static method(String arg) {
    return 'typed'
  }

  static method(arg1, Number arg2) {
    return 'two args'
  }
}