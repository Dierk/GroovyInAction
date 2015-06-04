ArrayList.metaClass.methodMissing = { String name, Object args ->
    assert name.startsWith("findBy")
    assert args.size() == 1
    Object.metaClass."$name" = { value ->       //#1
        delegate.find { it[name.toLowerCase()-'findby'] == value }
    }
    delegate."$name"(args[0])                   //#2
}

def data = [
    [name:'moon',    au: 0.0025],
    [name:'sun',     au: 1     ],
    [name:'neptune', au:30     ],
]

assert data.findByName('moon')     //#3
assert data.findByName('sun')      //#4
assert data.findByAu(1)