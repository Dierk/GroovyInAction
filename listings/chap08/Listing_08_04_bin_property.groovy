def propertyMissing(String name) {
    int result = 0
    name.each {
        result <<= 1
        if (it == 'I') result++
    }
    return result
}

assert IIOI +
        IOI ==
      IOOIO
