@Grab('org.hsqldb:hsqldb:2.3.2')
@GrabConfig(systemClassLoader=true)
//////////////////////////////////



import groovy.sql.Sql
import org.hsqldb.jdbc.JDBCDataSource

def dataSource = new JDBCDataSource(
    database: 'jdbc:hsqldb:mem:marathon', user: 'sa', password: '')
def sql = new Sql(dataSource)

// use 'sql' instance ...
// optional test of a system table within HSQLDB
assert sql.firstRow('SELECT 1 FROM INFORMATION_SCHEMA.SYSTEM_USERS')[0] == 1

sql.close()
