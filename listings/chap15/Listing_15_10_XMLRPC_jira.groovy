@Grab('org.codehaus.groovy:groovy-xmlrpc:0.8')
import groovy.net.xmlrpc.XMLRPCServerProxy as Proxy

class JiraProxy extends Proxy {
  JiraProxy(url) { super(url) }

  Object invokeMethod(String methodname, args) {
    super.invokeMethod('jira1.' + methodname, args)
  }
}

def jira = new JiraProxy('https://issues.apache.org/jira/rpc/xmlrpc')

// insert your ASF username and password below
jira.login('username', '****') { loginToken ->
  def projects = getProjectsNoSchemes(loginToken)
  println "${projects.size()} projects found in the Apache jira"
  def groovy = projects.find { it.name == 'Groovy' }
  if (groovy) {
    println "Found the $groovy.name project with key $groovy.key"
    println "Description: $groovy.description"
    println "Led by $groovy.lead and hosted at $groovy.projectUrl"
  }
}

/*
519 projects found in the Apache jira
Found the groovy project with key GROOVY
Description: Groovy programming language: a modern dynamic language for the JVM
Led by guillaume and hosted at https://groovy.incubator.apache.org/
*/