//@Grab('org.codehaus.groovy:groovy-xml:2.2.0')
//@Grab('org.codehaus.groovy:groovy-json:2.2.0')
@Grab('org.codehaus.groovy.modules.http-builder:http-builder:0.7.2')
import groovyx.net.http.RESTClient

def base = 'https://issues.apache.org/jira/rest/api/latest/'
def jira = new RESTClient(base)
jira.get(path: 'issue/GROOVY-5999') { resp, json ->
  assert resp.status == 200
  json.fields.with {
    assert summary == "Make @Delegate work with @DelegatesTo"
    assert fixVersions.name == ['2.1.1']
    assert resolutiondate.startsWith('2013-02-14')
  }
}
