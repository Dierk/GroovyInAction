@Grab('com.gmongo:gmongo:1.3')
import com.gmongo.GMongo
import com.mongodb.util.JSON
import groovy.transform.Field

@Field db = new GMongo().getDB('athletes')
db.athletes.drop()
db.athletes << [first: 'Paul', last: 'Tergat', dob: '1969-06-17', records: [
        [time: 2 * 60 * 60 + 4 * 60 + 55,
         venue: 'Berlin', when: '2003-09-28']
]]

def insertAthlete(first, last, dob) {
    db.athletes << [first: first, last: last, dob: dob]
}

def insertRecord(h, m, s, venue, date, lastname) {
    db.athletes.update(
            [last: lastname],
            [$addToSet: [records: [time: h * 60 * 60 + m * 60 + s,
                                venue: venue, when: date]]]
    )
}

insertAthlete('Khalid', 'Khannouchi', '1971-12-22')
insertAthlete('Ronaldo', 'da Costa', '1970-06-07')

insertRecord(2, 5, 38, 'London', '2002-04-14', 'Khannouchi')
insertRecord(2, 5, 42, 'Chicago', '1999-10-24', 'Khannouchi')
insertRecord(2, 6, 05, 'Berlin', '1998-09-20', 'da Costa')

def radcliffe = """{
    first: 'Paula',
    last: 'Radcliffe',
    dob: '1973-12-17',
    records: [
        {time: ${2 * 60 * 60 + 15 * 60 + 25},
            venue: 'London', when: '2003-04-13'}
    ]
}"""

db.athletes << JSON.parse(radcliffe)

assert db.athletes.count == 4
db.athletes.find().each {
    println "$it._id $it.last ${it.records.size()}"
}
//516b15fc2b10a15fa09331f2 Tergat 1
//516b15fc2b10a15fa09331f3 Khannouchi 2
//516b15fc2b10a15fa09331f4 da Costa 1
//516b15fc2b10a15fa09331f5 Radcliffe 1

def londonAthletes = db.athletes.find('records.venue': 'London')*.first
assert londonAthletes == ['Khalid', 'Paula']

def youngAthletes = db.athletes.aggregate(
        [$project: [first: 1, dob: 1]],
        [$match: [dob: [$gte: '1970-01-01']]],
        [$sort: [dob: -1]]
)

assert youngAthletes.results()*.first == ['Paula', 'Khalid', 'Ronaldo']
