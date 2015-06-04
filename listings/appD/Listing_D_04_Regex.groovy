def twister = 'she sells sea shells by the sea shore'

// contains word 'shore'
assert twister =~ 'shore'

// contains 'sea' twice (two ways)
assert (twister =~ 'sea').count == 2
assert twister.split(/ /).grep(~/sea/).size() == 2

// words that start with 'sh', \b = word boundary
def shwords = (twister =~ /sh[a-z]*\b/).collect{it}.join(' ')
assert shwords == 'she shells shore'

// sh-words by parallel assignment
def (a, b, c) = twister =~ /sh[a-z]*\b/
assert a == 'she'
assert b == 'shells'
assert c == 'shore'

// four words have three letter, \S = non-Space letter
assert (twister =~ /\b\S{3}\b/).count == 4

// three words start with 's' and have 4, 5, or 6 letters
assert (twister =~ /\bs\S{4}\S?\b/).count == 3

// replace words with 'X', \w = word character
assert twister.replaceAll(/\w+/,'X') == 'X X X X X X X X'

// starts with 'she' and ends with 'shore'
def pattern = ~/she.*shore/
assert pattern.matcher(twister).matches()

// replace 'sea' with 'ocean' but only if preceded by word 'the'
def ocean = twister.replaceAll('(?<=the )sea','ocean')
assert ocean == 'she sells sea shells by the ocean shore'

// swap 1st and 2nd pairs of words
def pairs = twister =~ /(\S+) (\S+) ?/
assert pairs.hasGroup()
twister = [1, 0, 2, 3].collect{ pairs[it][0] }.join()
assert twister == 'sea shells she sells by the sea shore'
