def matcher = 'a:1 b:2 c:3' =~ /(\S+):(\S+)/
matcher.each { full, key, value  ->
    assert full.size()  == 3
    assert key.size()   == 1  // a,b,c
    assert value.size() == 1  // 1,2,3
}