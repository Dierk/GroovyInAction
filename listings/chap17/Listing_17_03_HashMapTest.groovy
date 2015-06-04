class Listing_17_03_HashMapTest extends GroovyTestCase {
  static final KEY = new Object()
  static final MAP = [key1: new Object(), key2: new Object()]

  void testHashtableRejectsNull() {
    shouldFail(NullPointerException) {
      new Hashtable()[KEY] = null
    }
  }

  void testBadInitialSize() {
    def msg = shouldFail(IllegalArgumentException) {     //#A
      new HashMap(-1)
    }
    assertEquals "Illegal initial capacity: -1", msg             //#B
  }

  void testHashMapAcceptsNull() {
    def myMap = new HashMap()
    myMap[KEY] = null
    assert myMap.keySet().contains(KEY)
  }

  void testHashMapReturnsOriginalObjects() {
    def myMap = new HashMap()
    MAP.entrySet().each {
      myMap[it] = MAP[it]
      assertSame MAP[it], myMap[it]
    }
    assert MAP.dump().contains('java.lang.Object')       //#C
    assert myMap.size() == MAP.size()
  }
}
//#A Check that the right kind of exception is thrown
//#B Check the message
//#C Use Groovy inspection to examine the map
