class Counter {
    public count = 0
}

def counter = new Counter()

counter.count = 1
assert counter.count == 1

def fieldName = 'count'
counter[fieldName] = 2
assert counter['count'] == 2