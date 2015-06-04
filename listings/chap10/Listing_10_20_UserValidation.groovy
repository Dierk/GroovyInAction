void validate(User u, Closure<Boolean> rule) {
  if (!rule.call(u)) {                                              //#1
    println "User $u.name $u.password rejected"
  }
}

void validateAll(user) {
  validate(user) { !it.name.isEmpty() }                             //#2
  validate(user) { it.password.size() > 7 }                         //#3
}

def bob = new User(name: 'Bob', password: 'secr3t')
validateAll(bob)
//#1 Apply rule
//#2 Example passing rule
//#3 Example failing rule
