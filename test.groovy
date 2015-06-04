import groovy.io.FileType

def failed = []
def excludes = [
    '_failing_',                                  // any script that is meant to fail
    'snippet1901_MainFileRunner.groovy',          // requires a src file on classpath
    'Listing_10_46_RobotExtension.groovy',        // TC extension not standalone
    'Listing_10_47_SQLExtension.groovy',          // TC extension not standalone
    'Listing_12_16_GroovletExample.groovy',       // starts a servlet engine
    'Listing_12_17_HelloWorldGroovlet.groovy',    // groovlet; not standalone script
    'Listing_12_19_InspectGroovlet.groovy',       // groovlet; not standalone script
    'Listing_12_20_HiLowGame.groovy',             // groovlet; not standalone script
    'Listing_12_22_TemplateGroovlet.groovy',      // groovlet; not standalone script
    'Listing_13_25_AthleteAppMain.groovy',        // meant to run from commandline
    'Listing_13_27_MongoAthletes.groovy',         // requires mongodb to be installed
    'Listing_15_10_XMLRPC_jira.groovy',           // requires codehaus JIRA credentials
    'extra_NeoGremlinGraph.groovy',               // Grab seems a little fragile and only extra example
]

def ver = System.getProperty('java.version')[0..2].toBigDecimal()
def os = System.getProperty("os.name").toLowerCase()

if (os.contains('windows')) {
    excludes += [
        'Listing_12_13_Processes_UnixCommands.groovy',    // runs 'ls' etc.
        'Listing_12_14_Processes_ZipUnzip.groovy',        // needs gzip/gunzip
    ]
}
//excludes += ['snippet13_googleIpAdr.groovy'] // uncomment if no Internet

new File('.').traverse(type: FileType.FILES,
        nameFilter: ~/Listing_.*groovy|snippet.*groovy|extra_.*groovy/) { file ->
    if (excludes.any { file =~ it }) return
    if (file.name.contains('Windows_only') && !os.contains('windows')) return
    if (ver != 1.8 && file.name.contains('_jdk8_only')) return
    if (ver != 1.7 && file.name.contains('_jdk7_only')) return
    if (ver != 1.6 && file.name.contains('_jdk6_only')) return
    if (ver < 1.8 && file.name.contains('_jdk8_plus')) return
    if (ver < 1.7 && file.name.contains('_jdk7_plus')) return

    println "evaluating $file"
    try {
        new GroovyShell().run(file)
        println "OK"
    }
    catch (Throwable t) {
        failed << file
        println "FAILED " + t.message
    }
}
failed.each { print "\nFAILED: " + it }
