import groovy.mock.interceptor.MockFor

class SortableFarm extends Farm {
    void sort() {
        /* here the Farm would sort its machines by load */
    }
}

def relay(request) {
    def farm = new SortableFarm()
    farm.sort()
    farm.getMachines()[0].send(request)
}

def farmMock = new MockFor(SortableFarm)                    //#A

farmMock.demand.sort(){}                                    //#|B
farmMock.demand.getMachines { [new Expando(send: {} )] }    //#|B

farmMock.use {
    relay(null)
}
//#A Create mock
//#B Specify demanded behavior
