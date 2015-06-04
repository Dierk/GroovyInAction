def n = System.lineSeparator()                    //#1

reader = new StringReader('abc')
writer = new StringWriter()

reader.transformChar(writer) { it.next() }        //#A
assert 'bcd' == writer.toString()

reader = new File('data/example.txt').newReader()
writer = new StringWriter()

reader.transformLine(writer) { it - 'line' }      //#B
assert " one${n} two${n} three${n}" == writer.toString()

input  = new File('data/example.txt')
writer = new StringWriter()

input.filterLine(writer) { it =~ /one/ }          //#C
assert "line one${n}" == writer.toString()

writer = new StringWriter()
writer << input.filterLine { it.size() > 8 }      //#2
assert "line three${n}"  == writer.toString()
//#1 System dependent line separator
//#2 Read only long lines
//#A Transform ‘abc’ to ‘bcd’
//#B Chop ‘line’ from each line of the example file
//#C Read only lines containing “one”
