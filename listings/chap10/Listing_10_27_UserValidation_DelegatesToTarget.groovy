import groovy.transform.TypeChecked

def validate(@DelegatesTo.Target User u, @DelegatesTo Closure rule) { //#A
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
//#A Annotate the Closure and the User
