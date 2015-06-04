@BaseScript(LoggingScript)
import groovy.transform.BaseScript

abstract class LoggingScript extends Script {
  def log = []
  void println(args) {
    log << args
    System.out.println args
  }
}

println 'hello'
println 3 * 5

assert log.join(' ') == 'hello 15'
