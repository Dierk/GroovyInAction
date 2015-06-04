import java.lang.reflect.Modifier

class ReadWriteLockTestGroovyShell extends GroovyTestCase {

  public void testLockFieldDefaultsForReadLock() {
    def tester = new GroovyShell().evaluate('''
      import groovy.transform.WithReadLock
      class MyClass {
        @WithReadLock
        public void readerMethod1() { }
      }
      new MyClass()
    ''')

    def field = tester.getClass().getDeclaredField('$reentrantlock')
    assert Modifier.isPrivate(field.modifiers)
    // and more assertions...
  }
}
