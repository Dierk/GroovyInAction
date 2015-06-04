import static groovy.test.GroovyAssert.shouldFail

def e = shouldFail '''
import groovy.sql.Sql
import groovy.transform.TypeChecked

@TypeChecked(extensions = 'Listing_10_47_SQLExtension.groovy')
findAthletes(Sql sql) {
  sql.eachRow('select * frm Athlete') { row -> println row }       //#A
}
//#A Typo 'frm' not 'from'
'''
println e.message
assert e.message.contains('[Static type checking] - SQL query is not valid')
