import groovy.util.logging.Log

@Log
class Database {
    def search() {
        log.fine(runLongDatabaseQuery())
    }

    def runLongDatabaseQuery() {
        println 'Calling database'
        /* ... */
        return 'query result'
    }
}

new Database().search()
