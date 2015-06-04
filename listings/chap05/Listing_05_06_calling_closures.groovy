def benchmark(int repeat, Closure worker) {            //#1
    def start = System.nanoTime()                      //#2

    repeat.times { worker(it) }                        //#3

    def stop = System.nanoTime()                       //#4
    return stop - start                                //#4
}
def slow = benchmark(10000) { (int) it / 2 }           //#5
def fast = benchmark(10000) { it.intdiv(2) }           //#5
assert fast * 2 < slow                                 //#5
//#1 Put closures last
//#2 Some pre-work
//#3 Call closure the given number of times
//#4 Some post-work
//#5 Pass different closures for analysis