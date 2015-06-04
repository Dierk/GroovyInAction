import groovy.transform.Immutable
import static groovy.test.GroovyAssert.shouldFail

@Immutable
class Genius {
    String firstName, lastName
}

def g1 = new Genius(firstName: 'Albert', lastName: "Einstein")  //#1
assert g1.toString() == 'Genius(Albert, Einstein)'              //#2

def g2 = new Genius('Leonardo', "da Vinci")                     //#3
assert g2.firstName == 'Leonardo'                               //#4
assert g1 != g2                                                 //#5

shouldFail(ReadOnlyPropertyException) {
    g2.lastName = 'DiCaprio'
}
//#1 Map-based constructor
//#2 toString method
//#3 Tuple constructor
//#4 property getter
//#5 appropriate equals and hashCode
