def map = [a:[b:[c:1]]]           

assert map.a.b.c == 1

if (map && map.a && map.a.x){                          //#1
    assert map.a.x.c == null
}

try {
    assert map.a.x.c == null
} catch (NullPointerException ignore){                 //#2
}

assert map?.a?.x?.c == null                            //#3
//#1 Protect with if: short-circuit evaluation
//#2 Protect with try/catch
//#3 Safe dereferencing
