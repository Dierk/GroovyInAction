Number.metaClass {
    getMm = { delegate          }
    getCm = { delegate *  10.mm }
    getM  = { delegate * 100.cm }
}

assert 1.m + 20.cm - 8.mm == 1.192.m