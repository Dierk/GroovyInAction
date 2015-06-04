import util.DbUtil

def sql = DbUtil.create()
DbUtil.populate(sql)

def dump2(sql, tablename) {
  def printColNames = { meta ->
    def width = meta.columnCount * 12
    println " CONTENT OF TABLE ${tablename} ".center(width, '-')
    (1..meta.columnCount).each {
      print meta.getColumnLabel(it).padRight(12)
    }
    println()
    println '-' * width
  }
  def printRow = { row ->
    row.toRowResult().values().each {
      print it.toString().padRight(12)
    }
    println()
  }
  sql.eachRow('SELECT * FROM ' + tablename, printColNames, printRow)
}

def oldOut = System.out
def baos = new ByteArrayOutputStream()
System.setOut(new PrintStream(baos))

dump2(sql, 'Athlete')
assert baos.toString().readLines()*.trim().join('\n') == '''\
----------- CONTENT OF TABLE Athlete -----------
ATHLETEID   FIRSTNAME   LASTNAME    DATEOFBIRTH
------------------------------------------------
0           Paul        Tergat      1969-06-17
1           Khalid      Khannouchi  1971-12-22
2           Ronaldo     da Costa    1970-06-07\
'''

baos.reset()
dump2(sql, 'Record')
System.setOut(oldOut)
assert baos.toString().readLines()*.trim().join('\n') == '''\
----------------- CONTENT OF TABLE Record ------------------
RECORDID    TIME        VENUE       WHENRUN     FKATHLETE
------------------------------------------------------------
0           7495        Berlin      2003-09-28  0
1           7538        London      2002-04-14  1
2           7542        Chicago     1999-10-24  1
3           7565        Berlin      1998-09-20  2\
'''
