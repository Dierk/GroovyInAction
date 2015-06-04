import groovy.transform.TypeChecked
import groovy.transform.stc.*

void validate(User u,
              @ClosureParams(FirstParam) Closure<Boolean> rule) {   //#1
  if (!rule.call(u)) {
    println "User $u.name $u.password rejected"
  }
}

@TypeChecked
void validateAll(User user) {
  validate(user) { !it.name.isEmpty() }
  validate(user) { it.password.size() > 7 }
}

def bob = new User(name: 'Bob', password: 'secr3t')
validateAll(bob)
