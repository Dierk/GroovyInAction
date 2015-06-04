package regina

class CompiledAtASTTransformationTest extends GroovyTestCase {
  // matches format: EEE MMM dd HH:mm:ss zzz yyyy
  static DATE_FMT = /\w{3} \w{3} \d\d \d\d:\d\d:\d\d \S{3,9} \d{4}/

  @Override
  protected void setUp() throws Exception {
    super.setUp()
  }

  void testShouldApplyToThisTest() {
    assert compiledTime.toString() =~ DATE_FMT
  }

  void testShouldApplyToScriptAndScriptClasses() {
    assertScript '''
      import static regina.CompiledAtASTTransformationTest.*
      assert compiledTime.toString() =~ DATE_FMT
      class MyClass { }
      assert MyClass.compiledTime.toString() =~ DATE_FMT
    '''
  }
}
