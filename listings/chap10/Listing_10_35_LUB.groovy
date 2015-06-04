import static groovy.test.GroovyAssert.shouldFail

def e = shouldFail '''
import groovy.transform.TypeChecked

interface Polite {
    void greet()
    void thank()
}

class Person implements Polite {
    String name
    void greet() { println "Hello, I'm $name!" }
    void thank() { println 'Thanks!' }
}

class Owl implements Polite {
    void greet() { hoot() }
    void thank() { hoot() }
    void hoot() { println 'Hoot' }
}

@TypeChecked
void main() {
    def list = [new Person(name: 'Bill'), new Owl()]              //#A
    Polite p1 = list[0]                                           //#B
    Polite o1 = list[1]                                           //#B
    Owl o2    = list[0]                                           //#1
    Person p2 = list[1]                                           //#2
// extra sample (comment out and not mentioned in the book):
// a way to overcome above problem if we wanted to in Groovy
//    def tuple = new Tuple2<Person, Owl>(new Person(name: 'Bill'), new Owl())
//    Person p3 = tuple.first
//    Owl o3 = tuple.second
}

main()
//#A Create list with Person and Owl
//#B Assign either element to variable of type Polite
//#1 Try to assign 1st element to Owl
//#2 Try to assign 2nd element to Person
'''
assert e.message.contains('Cannot assign value of type Polite to variable of type Owl')
assert e.message.contains('Cannot assign value of type Polite to variable of type Person')
