import groovy.transform.Canonical
import util.DbUtil

def sql = DbUtil.create()
DbUtil.populate(sql)

def insertPrefix = '''
INSERT INTO Athlete (firstname, lastname, dateOfBirth) VALUES
'''

sql.execute insertPrefix + '(:first,:last,:dob)', first: 'Ingrid',
        last: 'Kristiansen', dob: '1956-03-21'

def loroupe = [first: 'Tegla', last: 'Loroupe', dob: '1973-05-09']
sql.execute insertPrefix + '(:first,:last,:dob)', loroupe

@Canonical class Athlete { String first, last, dob }

def ndereba = new Athlete('Catherine', 'Ndereba', '1972-07-21')
sql.execute insertPrefix + '(?.first,?.last,?.dob)', ndereba

def takahashi = new Athlete('Naoko', 'Takahashi')
def takahashiExtra = [dob: '1972-05-06']
def namedOrdinalSuffix = '(?1.first,?1.last,?2.dob)'
sql.execute insertPrefix + namedOrdinalSuffix, takahashi, takahashiExtra

assert sql.firstRow('SELECT COUNT(*) as num FROM Athlete').num == 7
