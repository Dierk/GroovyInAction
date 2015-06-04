def thread = Thread.start { println "I'm in a new thread" }
thread.join()