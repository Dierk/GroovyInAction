import static groovy.json.JsonOutput.*

def json = toJson([date: '2015-01-01', time: '6 am'])
assert json == '{"date":"2015-01-01","time":"6 am"}'

class Athlete { String first, last }

def mj = new Athlete(first: 'Michael', last: 'Jordan')
assert toJson(mj) == '{"first":"Michael","last":"Jordan"}'

def pt = new Athlete(first: 'Paul', last: 'Tergat')
def athletes = [basketball: mj, marathon: pt]

json = toJson(athletes)
assert prettyPrint(json) == '''
{
    "basketball": {
        "first": "Michael",
        "last": "Jordan"
    },
    "marathon": {
        "first": "Paul",
        "last": "Tergat"
    }
}
'''.trim()
