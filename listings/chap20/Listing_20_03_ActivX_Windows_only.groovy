//@Grab('org.codehaus.groovy.modules.scriptom:scriptom:1.6.0')
//@GrabExclude("org.codehaus.groovy:groovy")
import org.codehaus.groovy.scriptom.ActiveXObject

def PARENT = 0
def OPTS   = 0
def sh     = new ActiveXObject('Shell.Application')
def folder = sh.BrowseForFolder(PARENT, 'Choose a folder', OPTS)
println "Chosen folder: ${folder.Items().Item().Path.value}"
