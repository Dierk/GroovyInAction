class Detective {
  String firstName
  String lastName
}

def sherlock = new Detective(firstname: 'Sherlock', lastname: 'Holmes')


assert sherlock.lastName == 'Holmes'
