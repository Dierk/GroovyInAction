def validate(User u, Closure rule) {
  rule.delegate = u                                                 //#1
  rule()                                                            //#2
}

void validateAll(User u) {
  validate(u) { if (name.isEmpty()) println 'Empty name' }             //#3
  validate(u) { if (password.size() < 8) println 'Password too short' }//#3
}

def bob = new User(name: 'Bob', password: 'secr3t')
validateAll(bob)
//#1 Set user as delegate
//#2 Call validation rule
//#3 Simplified rule syntax
