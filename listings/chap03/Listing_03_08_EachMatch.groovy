def myFairStringy = 'The rain in Spain stays mainly in the plain!'

// words that end with 'ain': \b\w*ain\b
def wordEnding = /\w*ain/
def rhyme = /\b$wordEnding\b/
def found = ''
myFairStringy.eachMatch(rhyme) { match ->                      //#1
    found += match + ' '
}
assert found == 'rain Spain plain '

found = ''
(myFairStringy =~ rhyme).each { match ->                       //#2
    found += match + ' '
}
assert found == 'rain Spain plain '

def cloze = myFairStringy.replaceAll(rhyme){ it-'ain'+'___' }  //#3
assert cloze == 'The r___ in Sp___ stays mainly in the pl___!'
//#1 String.eachMatch(regex){}
//#2 Matcher.each {}
//#3 String.replaceAll(regex){}