@Grab('org.codehaus.groovy:groovy-testng:2.4.0')
@Grab('com.google.code.guice:guice:1.0')
@GrabConfig(systemClassLoader = true)
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import static Converter.celsius

class extra_ParameterizedTestNG {

  Object[][] scenarios = [
      [  0,  32, 'Freezing'],
      [ 20,  68, 'Garden party conditions'],
      [ 35,  95, 'Beach conditions'],
      [100, 212, 'Boiling']
  ]

  @DataProvider(name = 'scenarios')
  Object[][] scenarios() { scenarios }

  @Test(dataProvider = 'scenarios')
  void convert(c, f, scenario) {
    def actual = celsius(f)
    def msg = "$scenario: $fºF should convert into $cºC"
    assert c == actual, msg
  }
}
