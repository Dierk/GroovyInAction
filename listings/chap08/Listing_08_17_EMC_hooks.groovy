String.metaClass {
    rightShiftUnsigned = { prefix ->
        delegate.replaceAll(~/\w+/) { prefix + it }
    }
    methodMissing = { String name, args->
        delegate.replaceAll name, args[0]
    }
}

def people = "Dierk,Guillaume,Paul,Hamlet,Jon"
people  >>>= "\n    "
people     =  people.Dierk('Mittie').Guillaume('Mr.G')

assert people == '''
    Mittie,
    Mr.G,
    Paul,
    Hamlet,
    Jon'''