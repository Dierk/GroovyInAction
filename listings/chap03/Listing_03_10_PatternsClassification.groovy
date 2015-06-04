def fourLetters = ~/\w{4}/

assert fourLetters.isCase('work')

assert 'love' in fourLetters

switch('beer'){
    case fourLetters : assert true; break
    default          : assert false
}

beasts = ['bear','wolf','tiger','regex']

assert beasts.grep(fourLetters) == ['bear','wolf']