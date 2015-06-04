// works for systems with gzip and gunzip on the path
def outputBuffer = new StringBuffer()
def errorBuffer  = new StringBuffer()

zipProcess   = 'gzip -c'.execute()
unzipProcess = 'gunzip -c'.execute()

unzipProcess.consumeProcessOutput(outputBuffer, errorBuffer)
zipProcess.consumeProcessErrorStream(errorBuffer)

zipProcess | unzipProcess
zipProcess.withWriter { writer ->
  writer << 'Hello World'
}
unzipProcess.waitForOrKill(1000)

println 'Output: ' + outputBuffer
println 'Error : ' + errorBuffer
