def squareMapValues = { map ->
    if (map == null) { return null }
    if (!map) { return [] }
    return map.values().collect { it * it }
}
assert [1, 4, 9] == squareMapValues([a: 1, b: 2, c: 3])
