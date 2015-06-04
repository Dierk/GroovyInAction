import groovy.transform.TimedInterrupt
import java.util.concurrent.TimeoutException
import static java.util.concurrent.TimeUnit.MILLISECONDS

@TimedInterrupt(value = 480L, unit = MILLISECONDS)     //#A
class BlastOff1 {
    def log = []

    def countdown(n) {
        sleep 100
        log << n
        if (n == 0) log << 'ignition'
        else countdown(n - 1)
    }
}

def b = new BlastOff1()
Thread.start {
    try {
        b.countdown(10)
    } catch (TimeoutException ignore) {
        b.log << 'aborted'
    }
}.join()
assert b.log.join(' ') == '10 9 8 7 6 aborted'
//#A Just a little less than 500 milliseconds
