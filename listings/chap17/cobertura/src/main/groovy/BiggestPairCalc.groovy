class BiggestPairCalc {
  int sumBiggestPair(a, b, c) {
    def op1 = a
    def op2 = b
    if (c > a) {
      op1 = c
    } else if (c > b) {
      op2 = c
    }
    return op1 + op2
  }
}
