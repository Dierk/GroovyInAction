import groovy.transform.TypeChecked

interface Predicate<On> { boolean apply(On e) }          //#1

void validate(User u, Predicate<User> rule) {            //#2
  if (!rule.apply(u)) {
    println "User $u.name $u.password rejected"
  }
}

@TypeChecked
void validateAll(User user) {
  validate(user) { !it.name.isEmpty() }            //#3
  validate(user) { it.password.size() > 7 }        //#3
}

def bob = new User(name: 'Bob', password: 'secr3t')
validateAll(bob)
//#1 SAM type definition
//#2 SAM type argument
//#3 Implicit type inferred
