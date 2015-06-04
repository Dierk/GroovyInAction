import java.util.concurrent.locks.ReentrantReadWriteLock
import static java.lang.reflect.Modifier.*

class ReadWriteLockTestClassLoader extends GroovyTestCase {

  public void testLockFieldDefaultsForReadLock() {
    def tester = new GroovyClassLoader().parseClass('''
      class MyClass {
        @groovy.transform.WithReadLock
        public void readerMethod1() { }
      }
    ''')

    def field = tester.getDeclaredField('$reentrantlock')
    assert isPrivate(field.modifiers)
    assert !isTransient(field.modifiers)
    assert isFinal(field.modifiers)
    assert !isStatic(field.modifiers)
    assert field.type == ReentrantReadWriteLock
  }
}
