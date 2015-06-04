@Grab('org.codehaus.groovy:groovy-xmlrpc:0.8')
import groovy.net.xmlrpc.XMLRPCServerProxy as Proxy
import groovy.net.xmlrpc.XMLRPCServer as Server

def server = new Server()
server.echo = { return it }

def socket = new ServerSocket(8080)
server.startServer(socket)

remote = new Proxy("http://localhost:8080/")             //|#A
assert 'Hello world!' == remote.echo('Hello world!')     //|#A

server.stopServer()
//#A Client code
