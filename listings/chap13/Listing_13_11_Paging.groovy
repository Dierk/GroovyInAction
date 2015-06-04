import util.DbUtil

def sql = DbUtil.create()
DbUtil.populate(sql)

def qry = 'SELECT * FROM Athlete'
assert sql.rows(qry, 1, 2)*.lastname == ['Tergat', 'Khannouchi']
assert sql.rows(qry, 3, 2)*.lastname == ['da Costa']
