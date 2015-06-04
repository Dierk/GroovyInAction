class BiggestPairCalcFixed {
  int sumBiggestPair(int a, int b, int c) {
    def op1 = a
    def op2 = b
    if (c > [a, b].min()) {
      op1 = c
      op2 = [a, b].max()
    }
    return op1 + op2
  }
}
