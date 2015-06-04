class NoisySet2 {
    @Delegate
    Set delegate = new HashSet()

    @Override
    boolean add(item) {
        println "adding $item"
        delegate.add(item)
    }

    @Override
    boolean addAll(Collection items) {
        items.each { println "adding $it" }
        delegate.addAll(items)
    }
}

Set ns = new NoisySet2()
ns.add(1)
ns.addAll([2, 3])
assert ns.size() == 3
