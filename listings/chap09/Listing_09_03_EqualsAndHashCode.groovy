import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class Actor {
    String firstName, lastName
}
def magneto = new Actor(firstName:'Ian', lastName: 'McKellen')
def gandalf = new Actor(firstName:'Ian', lastName: 'McKellen')
assert magneto == gandalf
