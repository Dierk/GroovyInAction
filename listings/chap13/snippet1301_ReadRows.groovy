import util.DbUtil

def sql = DbUtil.create()
DbUtil.populate(sql)

List athletes = sql.rows('SELECT firstname, lastname FROM Athlete')
println "There are ${athletes.size()} Athletes:"
println athletes.collect{"${it[0]} ${it.lastname}"}.join(", ")

sql.close()
