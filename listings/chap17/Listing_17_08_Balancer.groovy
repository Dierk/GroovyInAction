import static org.junit.Assert.assertSame

def relay(request, farm) {                             //#|A
    farm.machines.sort { it.load }[0].send(request)    //#|A
}                                                      //#|A

class FakeMachine {                                    //#B
    def load
    def send(request) { return this }
}

final LOW_LOAD = 5, HIGH_LOAD = 10
def farm = [machines: [                                //#|C
    new FakeMachine(load:HIGH_LOAD),                   //#|C
    new FakeMachine(load:LOW_LOAD)]]                   //#|C

assertSame(LOW_LOAD, relay(null, farm).load)
//#A Subject under test
//#B Replacement class
//#C Map replaces farm
