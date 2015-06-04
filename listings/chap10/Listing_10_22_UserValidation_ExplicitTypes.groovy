import groovy.transform.TypeChecked

void validate(User u, Closure<Boolean> rule) {
  if (!rule.call(u)) {
    println "User $u.name $u.password rejected"
  }
}

@TypeChecked
void validateAll(User user) {                           //#A
  validate(user) { User u -> !u.name.isEmpty() }        //#A
  validate(user) { User u -> u.password.size() > 7 }    //#A
}

def bob = new User(name: 'Bob', password: 'secr3t')
validateAll(bob)
//#A User type in method and closure declarations
