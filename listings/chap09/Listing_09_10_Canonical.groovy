import groovy.transform.Canonical

@Canonical
class Inventor {
    String firstName, lastName
}

def i1 = new Inventor('Thomas', 'Edison')             //#A
def i2 = new Inventor('Thomas')
assert i1 != i2                                       //#B
assert i1.firstName == i2.firstName                   //#B
assert i1.toString() == 'Inventor(Thomas, Edison)'    //#C
//#A Automatic tuple constructor
//#B Objects not equal despite equal firstName property
//#C Automatic toString method
