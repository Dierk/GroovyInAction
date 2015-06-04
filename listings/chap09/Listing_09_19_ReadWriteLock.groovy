import groovy.transform.*

class PhoneBook3 {
    private final phoneNumbers = dummyNums()         //#A

    private dummyNums() {
        (1..8).collectEntries {
            ['Number' + it, '765432' + it]
        }
    }

    @WithReadLock
    def getNumber(key) {
        println "reading started for $key"
        phoneNumbers[key]
        sleep 80
        println "reading done for $key"
    }

    @WithWriteLock
    def addNumber(key, value) {
        println "writing started for $key"
        phoneNumbers[key] = value
        sleep 100
        println "writing done for $key"
    }
}

def p3 = new PhoneBook3()

(3..4).each{ count ->
    Thread.start {                                    //#B
        sleep 100 * count
        p3.addNumber('Number' + count, '9876543')
    }
}
(2..6).collect{ count ->
    Thread.start {                                    //#C
        sleep 100 * count
        p3.getNumber('Number' + count)
    }
}*.join()
//#A Fill phonebook with dummy numbers
//#B Start some writer threads
//#C Start some interleaved reader threads
/*
reading started for Number2
reading started for Number3
reading done for Number2
reading done for Number3
writing started for Number3
writing done for Number3
reading started for Number4
reading done for Number4
writing started for Number4
writing done for Number4
reading started for Number5
reading started for Number6
reading done for Number6
reading done for Number5
 */