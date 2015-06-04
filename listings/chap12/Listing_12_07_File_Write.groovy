def outFile = new File('data/example.txt')

def lines = ['line one','line two','line three']

outFile.write(lines[0..1].join("\n"))                     //#A
outFile.append("\n"+lines[2])                             //#A

assert lines == outFile.readLines()

outFile.withWriter { writer ->                            //#B
  writer.writeLine(lines[0])                              //#B
}                                                         //#B
outFile.withWriterAppend('ISO8859-1') { writer ->         //#B
  writer << lines[1] << "\n"                              //#B
}
outFile << lines[2]                                       //#C
//#A Writing/appending with simple method calls
//#B Writing/appending with closures
//#C Appending with the leftshift operator
