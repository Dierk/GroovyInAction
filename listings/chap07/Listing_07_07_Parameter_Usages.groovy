class Summer {
    def sumWithDefaults(a, b, c=0){                       //#1
        return a + b + c
    }
    def sumWithList(List args){                           //#2
        return args.inject(0){sum,i -> sum += i}
    }
    def sumWithOptionals(a, b, Object[] optionals){       //#3
        return a + b + sumWithList(optionals.toList())
    }
    def sumNamed(Map args){                               //#4
        ['a','b','c'].each{args.get(it,0)}
        return args.a + args.b + args.c
    }
}

def summer = new Summer()

assert 2 == summer.sumWithDefaults(1,1)
assert 3 == summer.sumWithDefaults(1,1,1)

assert 2 == summer.sumWithList([1,1])
assert 3 == summer.sumWithList([1,1,1])

assert 2 == summer.sumWithOptionals(1,1)
assert 3 == summer.sumWithOptionals(1,1,1)

assert 2 == summer.sumNamed(a:1, b:1)
assert 3 == summer.sumNamed(a:1, b:1, c:1)
assert 1 == summer.sumNamed(c:1)
//#1 Explicit arguments and a default value
//#2 Define arguments as a list
//#3 Optional arguments as an array
//#4 Define arguments as a map
