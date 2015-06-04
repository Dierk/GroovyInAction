@Grab('junitperf:junitperf:1.9.1')
@GrabResolver('https://repository.jboss.org/')
import com.clarkware.junitperf.*
import junit.framework.*
import junit.textui.TestRunner
import static Converter.celsius

class Listing_17_12_JUnitPerf extends TestCase {
  Listing_17_12_JUnitPerf(String testName) {
    super(testName)                                                 //#A
  }

  void testConverter() {                                            //#B
    assert 0 == celsius(32)                                         //#C
    assert 100 == celsius(212)                                      //#C
  }

  static main(args) {
    TestRunner.run(suite())
  }

  static Test suite() {
    def testCase = new Listing_17_12_JUnitPerf("testConverter")     //#D

    def numUsers = 20                                               //#E
    def stagger = new ConstantTimer(100)                            //#E
    def loadTest = new LoadTest(testCase, numUsers, stagger)        //#F

    def timeLimit = 2100                                            //#G
    return new TimedTest(loadTest, timeLimit)                       //#H
  }
}
//#A Call super
//#B Traditional nontimed JUnit test
//#C Class under test
//#D Define test case
//#E 20 users for load staggered at 100 ms
//#F Decorate testcase to simulate load
//#G Must return within 2100 ms
//#H Return decorated time-constrained test
