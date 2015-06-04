import util.DbUtil

def sql = DbUtil.create()
DbUtil.populate(sql)
DbUtil.enableLogging()

def athletes = sql.dataSet('Athlete')

athletes.add(
    firstname: 'Paula',
    lastname: 'Radcliffe',
    dateOfBirth: '1973-12-17'
)

def query = athletes.findAll { it.firstname >= 'P' }
query = query.findAll { it.dateOfBirth > '1970-01-01' }
query = query.sort { it.dateOfBirth }
query = query.reverse()
assert query.sql == 'select * from Athlete where firstname >= ? and ' +
    'dateOfBirth > ? order by dateOfBirth DESC'
assert query.parameters == ['P', '1970-01-01']
assert query.rows()*.firstname == ['Paula', 'Ronaldo']
