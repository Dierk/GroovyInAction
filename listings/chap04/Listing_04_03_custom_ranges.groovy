class Weekday implements Comparable {
  static final DAYS = [
      'Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'
  ]
  private int index = 0

  Weekday(String day) {                                //#A
    index = DAYS.indexOf(day)
  }

  Weekday next() {
    return new Weekday(DAYS[(index + 1) % DAYS.size()])
  }

  Weekday previous() {
    return new Weekday(DAYS[index - 1])                //#1
  }

  int compareTo(Object other) {
    return this.index <=> other.index
  }

  String toString() {
    return DAYS[index]
  }
}

def mon = new Weekday('Mon')
def fri = new Weekday('Fri')

def worklog = ''
for (day in mon..fri) {                                //#B
  worklog += day.toString() + ' '
}
assert worklog == 'Mon Tue Wed Thu Fri '
//#A Allow all values
//#1 Range bound methods
//#B Working through the week
