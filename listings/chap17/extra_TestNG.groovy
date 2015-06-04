@Grab('org.codehaus.groovy:groovy-testng:2.4.0')
@Grab('com.google.code.guice:guice:1.0')
@GrabConfig(systemClassLoader=true)
import org.testng.annotations.Test

class extra_TestNG {
  @Test
  void shouldAdd() {
    assert 2 == 1 + 1
  }
}
