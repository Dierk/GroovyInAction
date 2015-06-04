def odd = { it % 2 == 1}

assert [1,2,3].grep(odd) == [1, 3]

switch(10) {
    case odd : assert false
}

if (2 in odd) assert false
