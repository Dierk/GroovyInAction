class BiggestPairCalcTest extends GroovyTestCase {
  void testSumBiggestPair() {
    def calc = new BiggestPairCalc()
    testCalc(calc)

//    def fixed = new BiggestPairCalcFixed()
//    testCalc(fixed)
//    assertEquals(11, fixed.sumBiggestPair(5, 2, 6))
//    assertEquals(15, fixed.sumBiggestPair(5, 9, 6))
//    assertEquals(16, fixed.sumBiggestPair(10, 2, 6))
  }

  private void testCalc(calc) {
    assertEquals(9, calc.sumBiggestPair(5, 4, 1))

    assertEquals(15, calc.sumBiggestPair(5, 9, 6))
    assertEquals(16, calc.sumBiggestPair(10, 2, 6))

    //assertEquals(11, calc.sumBiggestPair(5, 2, 6))
  }
}
