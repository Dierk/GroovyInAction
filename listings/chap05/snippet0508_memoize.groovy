def fib 
fib = { it < 2 ? 1 : fib(it-1) + fib(it-2) }
fib = fib.memoize()

assert fib(40) == 165_580_141


// nano time
// without memoize 22_903_497_000
// with memoize         1_074_000