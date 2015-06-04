import util.DbUtil

def sql = DbUtil.create()
DbUtil.populate(sql)

def athletes = sql.dataSet('Athlete')

def result = []
athletes.each { result << it.firstname }                              //#1
assert result == ['Paul', 'Khalid', 'Ronaldo']                        //#A

athletes.add(
    firstname: 'Paula',
    lastname: 'Radcliffe',
    dateOfBirth: '1973-12-17'
)

result = athletes.rows().collect { it.firstname }                     //#2
assert result == ['Paul', 'Khalid', 'Ronaldo', 'Paula']               //#B
//#A Initially we have our three sample athletes
//#B Confirm we now have four athletes
//#1 Treating a SQL table like a list of map-like rows
//#2 Using rows followed by collect
