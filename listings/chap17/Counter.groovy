class Counter {
    int biggerThan(items, threshold) {
        items.grep{ it > threshold }.size()
    }
}
