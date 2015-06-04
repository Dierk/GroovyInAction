String greeting = 'Hello Groovy!'

assert greeting.startsWith('Hello')

assert greeting.getAt(0) == 'H'
assert greeting[0]       == 'H'

assert greeting.indexOf('Groovy') >= 0
assert greeting.contains('Groovy')

assert greeting[6..11]  == 'Groovy'

assert 'Hi' + greeting - 'Hello' == 'Hi Groovy!' 

assert greeting.count('o') == 3

assert 'x'.padLeft(3)      == '  x'
assert 'x'.padRight(3,'_') == 'x__'
assert 'x'.center(3)       == ' x '
assert 'x' * 3             == 'xxx'