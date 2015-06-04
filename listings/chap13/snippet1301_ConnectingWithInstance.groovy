import groovy.sql.Sql

def url = 'jdbc:hsqldb:mem:GinA'
def user = 'sa'
def password = ''
def driver = 'org.hsqldb.jdbcDriver'

Sql.withInstance(url, user, password, driver) { sql ->
  // use 'sql' instance ...
  // optional test of a system table within HSQLDB
  assert sql.firstRow('SELECT 1 FROM INFORMATION_SCHEMA.SYSTEM_USERS')[0] == 1
}
