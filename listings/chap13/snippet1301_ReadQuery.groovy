import util.DbUtil

def sql = DbUtil.create()
DbUtil.populate(sql)

sql.query('SELECT firstname, lastname FROM Athlete') { resultSet ->
  if (resultSet.next()) {
    print resultSet.getString(1)
    print ' '
    println resultSet.getString('lastname')
  }
}

sql.close()
