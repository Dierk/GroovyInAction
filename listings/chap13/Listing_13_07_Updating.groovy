import util.DbUtil

def sql = DbUtil.create()

sql.execute '''
  INSERT INTO Athlete (lastname) VALUES ('da Costa')
'''

sql.execute '''
  UPDATE Athlete SET firstname='Ronaldo' where lastname='da Costa'
'''

def updateCount = sql.executeUpdate '''
  UPDATE Athlete SET dateOfBirth='1970-06-07' where lastname='da Costa'
'''
assert updateCount == 1                                               //#A

def row = sql.firstRow '''
  SELECT * FROM Athlete where lastname = 'da Costa'
'''
assert "${row.firstname} ${row.lastname} ${row.dateofbirth}" ==
    'Ronaldo da Costa 1970-06-07'

sql.close()
//#A Check one row was updated
