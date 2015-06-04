@Grab('org.hsqldb:hsqldb:2.3.2')
@GrabConfig(systemClassLoader=true)
//////////////////////////////////


import groovy.sql.Sql

def url = 'jdbc:hsqldb:mem:GinA'
def user = 'sa'
def password = ''
def driver = 'org.hsqldb.jdbcDriver'
def sql = Sql.newInstance(url, user, password, driver)

// use 'sql' instance ...
// optional test of a system table within HSQLDB
assert sql.firstRow('SELECT 1 FROM INFORMATION_SCHEMA.SYSTEM_USERS')[0] == 1

sql.close()
