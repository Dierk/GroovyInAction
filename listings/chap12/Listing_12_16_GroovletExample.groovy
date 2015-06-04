@Grab('org.eclipse.jetty.aggregate:jetty-server:8.1.16.v20140903')
@Grab('org.eclipse.jetty.aggregate:jetty-servlet:8.1.16.v20140903')
@Grab('javax.servlet:javax.servlet-api:3.0.1')

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.*
import groovy.servlet.*
import static org.eclipse.jetty.servlet.ServletContextHandler.*

def server = new Server(1234)
def context = new ServletContextHandler(server, "/", SESSIONS)
context.resourceBase = "."
context.addServlet(GroovyServlet, "*.groovy")
server.start()
