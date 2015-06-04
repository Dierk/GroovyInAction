import static groovy.test.GroovyAssert.shouldFail

def e = shouldFail '''
class User { String name, password }

import groovy.transform.TypeChecked

void validate(User u, Closure<Boolean> rule) {
  if (!rule.call(u)) {
    println "User $u.name $u.password rejected"
  }
}

@TypeChecked
void validateAll(user) {                           //#1
  validate(user) { !it.name.isEmpty() }            //#2
  validate(user) { it.password.size() > 7 }        //#3
}

def bob = new User(name: 'Bob', password: 'secr3t')
validateAll(bob)
'''
// println out just the error messages
println e.message.readLines().findAll{ it.contains('[Static type checking]') }*.replaceAll(/.*(\[Static type checking\])(.*)/, '$1$2').join('\n')
assert e.message.contains('No such property: name for class: java.lang.Object')
assert e.message.contains('No such property: password for class: java.lang.Object')
assert e.message =~ /Cannot find matching method.*validate\(java.lang.Object, groovy.lang.Closure\)/
//#1 Type of user is Object
//#2 No property name for Object
//#3 No property password for Object
