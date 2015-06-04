for (number in 1..20) {
    def ant = new AntBuilder()
    def dir = 'listings/chap' + number.toString().padLeft(2, '0')

    def runner = "../../test"
    if (number == 11) {
        def home = System.getenv("JAVA_HOME")
        jfxcp = "$home/jre/lib/jfxrt.jar"
        runner = "-classpath $jfxcp " + runner
    } else if (number == 10) {
      // add type extension source files to classpath
      runner = "-classpath . " + runner
    }

    println "testing dir $dir"
    def os = System.getProperty("os.name").toLowerCase()
    def groovy = os.contains('windows') ? System.getenv("GROOVY_HOME") + '\\bin\\groovy.bat' : 'groovy'
    ant.exec(
            dir: dir,
            outputproperty: "cmdOut",
            executable: groovy) {
        arg(line: runner)
    }
    def out = ant.project.properties.cmdOut
    println out
    if (out.contains('FAILED')) {
        out.split("\n").grep(~/.*FAILED:.*/).each { println it }
        System.exit(1)
    }
}