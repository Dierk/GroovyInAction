import groovy.transform.TypeChecked

def validate(User u, @DelegatesTo(User) Closure rule) {        //#A
  rule.delegate = u
  rule()
}

@TypeChecked
void validateAll(User u) {
  validate(u) { if (name.isEmpty()) println 'Empty name' }
  validate(u) { if (password.size() < 8) println 'Password too short' }
}

def bob = new User(name: 'Bob', password: 'secr3t')
validateAll(bob)
//#A Annotation on Closure parameter
