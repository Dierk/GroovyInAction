import java.util.logging.Level

class Listing_17_11_LoggingCounterTest extends GroovyLogTestCase {
  static final MIXED_NUMBERS = [99, 2, 1, 0, -1, -2, -99]        //#A
  private count

  void setUp() {
    count = new LoggingCounter()
  }

  void testCounterAndLog() {
    def log = stringLog(Level.FINER, 'LoggingCounter') {         //#B
      def bigger = count.biggerThan(MIXED_NUMBERS, -1)           //#C
      assertEquals(4, bigger)                                    //#D
    }
    checkLogCount(1, "was equal", log)
    checkLogCount(4, "was bigger", log)
    checkLogCount(2, "was smaller", log)
    checkLogCount(4, /[^d][^o][^n][^'][^t] count this one/, log)
    checkLogCount(3, "don't count this one", log)
  }

  private checkLogCount(expectedCount, regex, log) {             //#E
    def matcher = (log =~ regex)
    assertTrue log, expectedCount == matcher.count
  }
}
//#A Test data
//#B Set up stringLog
//#C Invoke SUT
//#D Traditional JUnit style assert
//#E Helper method asserting patterns within the log

