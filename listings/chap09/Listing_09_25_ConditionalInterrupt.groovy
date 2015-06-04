import groovy.transform.ConditionalInterrupt

@ConditionalInterrupt({ count <= 5 })
class BlastOff3 {
    def log = []
    def count = 10

    def countdown() {
        while (count != 0) {
            log << count
            count--
        }
        log << 'ignition'
    }
}

def b = new BlastOff3()
try {
    b.countdown()
} catch (InterruptedException ignore) {
    b.log << 'aborted'
}
assert b.log.join(' ') == '10 9 8 7 6 aborted'
