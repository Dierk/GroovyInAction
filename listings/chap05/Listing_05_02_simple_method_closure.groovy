class SizeFilter {
    Integer limit

    boolean sizeUpTo(String value) {
        return value.size() <= limit
    }
}

SizeFilter filter6 = new SizeFilter(limit:6)           //#1
SizeFilter filter5 = new SizeFilter(limit:5)           //#1

Closure sizeUpTo6 = filter6.&sizeUpTo                  //#2

def words = ['long string', 'medium', 'short', 'tiny']

assert 'medium' == words.find (sizeUpTo6)              //#3
assert 'short'  == words.find (filter5.&sizeUpTo)      //#4
//#1 GroovyBean constructor calls
//#2 Method closure assignment
//#3 Calling with closure
//#4 Passing a method closure directly
