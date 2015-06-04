class InspectMe {
    int outer(){
        return inner()        
    }
    private int inner(){
        return 1
    }
}

def tracer = new TracingInterceptor(writer: new StringWriter()) //#1
def proxyMetaClass = ProxyMetaClass.getInstance(InspectMe)
proxyMetaClass.interceptor = tracer

InspectMe inspectMe = new InspectMe()
inspectMe.metaClass = proxyMetaClass  //#2

assert 1 == inspectMe.outer()         //#3

assert "\n" + tracer.writer.toString() == """
before InspectMe.outer()
  before InspectMe.inner()
  after  InspectMe.inner()
after  InspectMe.outer()
"""