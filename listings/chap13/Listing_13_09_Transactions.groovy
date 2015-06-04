import static util.DbUtil.*

def sql = create()
populate(sql)

sql.withTransaction {
    insertAthlete(sql, 'Haile', 'Gebrselassie', '1973-04-18')
    insertAthlete(sql, 'Patrick', 'Makau', '1985-03-02')
}

assert sql.firstRow('SELECT COUNT(*) as num FROM Athlete').num == 5

// modify above to show transaction rollback
/*
try {
  sql.withTransaction {
    insertAthlete(sql, 'Haile', 'Gebrselassie', '1973-04-18')
    insertAthlete(sql, 'Patrick', 'Makau' * 100, '1985-03-02')
  }
} catch(ignore) { println ignore.message }
assert sql.firstRow('SELECT COUNT(*) as num FROM Athlete').num == 3

 */