def twister = 'she sells sea shells at the sea shore of seychelles'

// twister must contain a substring of size 3 
// that starts with s and ends with a
assert twister =~ /s.a/                                        //#1

def finder = (twister =~ /s.a/)                                //#2
assert finder instanceof java.util.regex.Matcher               //#2

// twister must contain only words delimited by single spaces
assert twister ==~ /(\w+ \w+)*/                                //#A

def WORD = /\w+/
matches = (twister ==~ /($WORD $WORD)*/)                       //#B
assert matches instanceof java.lang.Boolean                    //#B

assert !(twister ==~ /s.e/)                                    //#C

def wordsByX = twister.replaceAll(WORD, 'x')
assert wordsByX == 'x x x x x x x x x x'

def words = twister.split(/ /)                                 //#D
assert words.size() == 10
assert words[0] == 'she'
//#1 Regex find operator as usable in if
//#2 Find expression evaluates to a matcher object
//#A Regex match operator
//#B Match expression evaluates to a boolean
//#C Match is full unlike find
//#D Split returns a list of words
