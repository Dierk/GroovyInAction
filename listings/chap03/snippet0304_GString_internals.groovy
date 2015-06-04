def me      = 'Tarzan'
def you     = 'Jane'
def line    = "me $me - you $you"
assert line == 'me Tarzan - you Jane'
assert line instanceof GString
assert line.strings[0] == 'me '
assert line.strings[1] == ' - you '
assert line.values[0]  == 'Tarzan'
assert line.values[1]  == 'Jane'