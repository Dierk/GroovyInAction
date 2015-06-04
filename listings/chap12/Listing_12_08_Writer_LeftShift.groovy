TimeZone.default = TimeZone.getTimeZone("CET")
reader = new StringReader('abc')
writer = new StringWriter()

writer << "\nsome String"   << "\n"
writer << [a:1, b:2]        << "\n"
writer << [3,4]             << "\n"
writer << new Date(0)       << "\n"
writer << reader            << "\n"

assert writer.toString() == '''
some String
[a:1, b:2]
[3, 4]
Thu Jan 01 01:00:00 CET 1970
abc
'''
