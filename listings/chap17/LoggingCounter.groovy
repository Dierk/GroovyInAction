import java.util.logging.*

class LoggingCounter {
    static final LOG = Logger.getLogger('LoggingCounter')

    def biggerThan(items, target) {
        int count = 0
        items.each {
            if (it > target) {
                count++
                LOG.finer "item was bigger - count this one"
            } else if (it == target) {
                LOG.finer "item was equal - don't count this one"
            } else {
                LOG.finer "item was smaller - don't count this one"
            }
        }
        return count
    }
}
