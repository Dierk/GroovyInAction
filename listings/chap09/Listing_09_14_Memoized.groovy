import groovy.transform.Memoized

class Calc {
  def log = []

  @Memoized                                            //#1
  int sum(int a, int b) {
    log << "$a+$b"                                     //#2
    a + b
  }
}

new Calc().with {
  assert sum(3, 4) == 7                                //#3
  assert sum(4, 4) == 8
  assert sum(3, 4) == 7                                //#4
  assert log.join(' ') == '3+4 4+4'                    //#5
}
//#1 Enable memoization by annotating a method
//#2 Log all calculations
//#3 Calculation performed the first time
//#4 Result returned from cache
//#5 Logging shows calculations performed once each
