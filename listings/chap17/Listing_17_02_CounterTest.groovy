class Listing_17_02_CounterTest extends GroovyTestCase {
  static final Integer[] NEG_NUMBERS   = [-2, -3, -4]             //#A
  static final Integer[] POS_NUMBERS   = [4,   5,  6]             //#A
  static final Integer[] MIXED_NUMBERS = [4,  -6,  0]             //#A
  private Counter counter

  void setUp() {
    counter = new Counter()
  }

  void testCounterWorks() {
    assertEquals(2, counter.biggerThan([5, 10, 15], 7))
  }

  void testCountHowManyFromSampleNumbers() {
    check(0, NEG_NUMBERS, -1)                         //#B
    check(0, NEG_NUMBERS, -2)                         //#B
    check(2, NEG_NUMBERS, -4)                         //#B
    check(3, NEG_NUMBERS, -5)                         //#B
    check(0, POS_NUMBERS,  7)                         //#B
    check(0, POS_NUMBERS,  6)                         //#B
    check(2, POS_NUMBERS,  4)                         //#B
    check(3, POS_NUMBERS,  3)                         //#B
    check(0, MIXED_NUMBERS,  5)                       //#B
    check(1, MIXED_NUMBERS,  2)                       //#B
    check(1, MIXED_NUMBERS,  1)                       //#B
    check(1, MIXED_NUMBERS,  0)                       //#B
    check(2, MIXED_NUMBERS, -1)                       //#B
    check(3, MIXED_NUMBERS, -7)                       //#B
  }

  void testInputDataUnchanged() {                       //#C
    def numbers = NEG_NUMBERS.clone()
    def origLength = numbers.size()
    counter.biggerThan(numbers, 0 /* don't care */)
    assertLength origLength, numbers
    assertArrayEquals NEG_NUMBERS, numbers
  }

  void testCountHowManyFromSampleStrings() {            //#D
    check(2, ['Dog', 'Cat', 'Antelope'], 'Bird')
  }

  void testInputDataAssumptions() {                    //#E
    assertTrue NEG_NUMBERS.every { it < 0 }
    assertTrue POS_NUMBERS.every { it > 0 }
    assertContains 0, MIXED_NUMBERS
    int negCount = 0
    int posCount = 0
    MIXED_NUMBERS.each {
      if (it < 0) negCount++ else if (it > 0) posCount++
    }
    assert negCount && posCount
  }

  private check(expectedCount, items, threshold) {
    assertEquals(expectedCount,
        counter.biggerThan(items, threshold)
    )
  }
}
//#A Constants repeated in the test
//#B Use a helper method to make code simpler
//#C Tests proving we don’t change the array
//#D Calculator doesn’t only work with numbers
//#E Test constants sanity check

