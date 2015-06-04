def last
last = { it.size() == 1 ? it.head() : last.trampoline(it.tail()) }

last = last.trampoline()

assert last(0..10_000) == 10_000