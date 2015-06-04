import groovy.transform.Synchronized
import groovy.util.logging.Log

@Log
class PhoneBook2 {
    private final phoneNumbers = [:]
    private final lock = new Object[0]                //#A

    @Synchronized('lock')                             //#B
    def getNumber(key) {
            phoneNumbers[key]
    }

    def addNumber(key, value) {
        log.info("Adding phone number $value")
        synchronized (lock) {                         //#C
            phoneNumbers[key] = value
        }
    }
}

def p2 = new PhoneBook2()
(0..99).collect { num ->
    Thread.start {
        p2.addNumber('Number' + num, '98765' + num)
    }
}*.join()
assert p2.getNumber('Number43') == '9876543'
//#A Manually create lock
//#B Specify the lock name
//#C Manual synchronized block
