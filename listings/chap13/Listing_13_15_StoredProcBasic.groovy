import util.DbUtil

def sql = DbUtil.create()
DbUtil.populate(sql)

sql.execute '''
  CREATE FUNCTION SELECT_ATHLETE_RECORD ()
  RETURNS TABLE (lastname VARCHAR(64), venue VARCHAR(64), whenRun DATE)
  READS SQL DATA
  RETURN TABLE (
    SELECT Athlete.lastname, Record.venue, Record.whenRun
    FROM Athlete, Record
    WHERE Athlete.athleteId = Record.fkAthlete
    ORDER BY whenRun
  )
'''
def result = []
sql.eachRow('CALL SELECT_ATHLETE_RECORD()') {
  result << "$it.lastname $it.venue $it.whenRun"
}
assert result == [
    'da Costa Berlin 1998-09-20',
    'Khannouchi Chicago 1999-10-24',
    'Khannouchi London 2002-04-14',
    'Tergat Berlin 2003-09-28'
]
