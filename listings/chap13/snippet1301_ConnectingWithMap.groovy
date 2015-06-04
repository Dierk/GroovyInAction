import groovy.sql.Sql

import static java.sql.ResultSet.CONCUR_READ_ONLY

// ...
def sql = Sql.newInstance(
    url: 'jdbc:hsqldb:mem:GinA',
    user: 'sa',
    password: '',
    driver: 'org.hsqldb.jdbcDriver',
    cacheStatements: true,
    resultSetConcurrency: CONCUR_READ_ONLY)

// use 'sql' instance ...

sql.close()
