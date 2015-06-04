import util.DbUtil

def sql = DbUtil.create()
DbUtil.populate(sql)

sql.eachRow('SELECT firstname, lastname FROM Athlete') { row ->
  println row[0] + ' ' + row[1]
}

sql.close()
