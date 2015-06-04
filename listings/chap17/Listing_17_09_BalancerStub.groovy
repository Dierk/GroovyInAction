import groovy.mock.interceptor.StubFor

def relay(request) {
    new Farm().getMachines().sort { it.load }[0].send(request)
}

def fakeOne = new Expando(load:10, send: { false } )
def fakeTwo = new Expando(load:5,  send: { true }  )

def farmStub = new StubFor(Farm)                        //#A
farmStub.demand.getMachines { [fakeOne, fakeTwo ] }     //#B

farmStub.use {                                          //#|C
    assert relay(null)                                  //#|C
}                                                       //#|C
//#A Create stub
//#B Specify demanded behavior
//#C Call the class under test using stub
