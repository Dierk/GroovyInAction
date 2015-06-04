def (a,b,c) = 'a b c' =~ /\S/ 

assert a == 'a' 
assert b == 'b' 
assert c == 'c'