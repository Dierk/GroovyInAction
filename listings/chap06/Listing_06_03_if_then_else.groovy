if (true)       assert true
else            assert false

if (1) {
    assert true
} else {
    assert false
}    

if ('nonempty') assert true
else if (['x']) assert false
else            assert false

if (0)          assert false
else if ([])    assert false
else            assert true
