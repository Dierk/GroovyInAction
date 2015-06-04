import util.DbUtil
import java.text.SimpleDateFormat

def sql = DbUtil.create()
DbUtil.populate(sql)

println ' Athlete Info '.center(25, '-')
def fmt = new SimpleDateFormat('dd. MMM yyyy (E)', Locale.US)
sql.eachRow('SELECT * FROM Athlete') { athlete ->
  println athlete.firstname + ' ' + athlete.lastname
  println 'born on ' + fmt.format(athlete.dateOfBirth)
  println '-' * 25
}

sql.close()
