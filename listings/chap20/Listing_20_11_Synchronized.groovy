class Person {
    List addresses

    @groovy.transform.Synchronized
    void setAddresses(List addresses) {
        this.addresses.clear()
        this.addresses.addAll(addresses)
    }
}

assert new Person()