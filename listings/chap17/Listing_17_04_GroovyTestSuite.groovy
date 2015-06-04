import junit.framework.*
import junit.textui.TestRunner

static Test suite() {
  def suite = new TestSuite()
  def gts = new GroovyTestSuite()
  suite.addTestSuite(gts.compile("Listing_17_02_CounterTest.groovy"))
  suite.addTestSuite(gts.compile("Listing_17_03_HashMapTest.groovy"))
  return suite
}

TestRunner.run(suite())
