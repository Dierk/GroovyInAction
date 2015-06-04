import util.DbUtil

def sql = DbUtil.create()
DbUtil.populate(sql)

def expected = ['Paul Tergat', 'Khalid Khannouchi', 'Ronaldo da Costa']

def rowNum = 0
sql.query('SELECT firstname, lastname FROM Athlete') { resultSet ->   //#1
  while (resultSet.next()) {                                          //#2
    def first = resultSet.getString(1)                                //#3
    def last = resultSet.getString('lastname')                        //#3
    assert expected[rowNum++] == "$first $last"
  }
}

rowNum = 0
sql.eachRow('SELECT firstname, lastname FROM Athlete') { row ->       //#4
  def first = row[0]                                                  //#5
  def last = row.lastname                                             //#5
  assert expected[rowNum++] == "$first $last"
}

def first = sql.firstRow('SELECT lastname, dateOfBirth FROM Athlete') //#6
assert first.values().sort().join(',') == 'Tergat,1969-06-17'         //#5

List athletes = sql.rows('SELECT firstname, lastname FROM Athlete')   //#7
assert athletes.size() == 3
assert athletes.collect { "$it.FIRSTNAME ${it[-1]}" } == expected     //#5

assert sql.firstRow('SELECT COUNT(*) AS num FROM Athlete').num == 3   //#8
//#1 Read using query
//#2 External iteration on the ResultSet
//#3 Access properties via JDBC API calls
//#4 Read using rows
//#5 Access properties via map or list styles
//#6 Read using firstRow
//#7 Read using rows
//#8 More efficient size calculation
