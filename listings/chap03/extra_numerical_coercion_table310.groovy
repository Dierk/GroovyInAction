assert 1f*2f instanceof Double
assert (Byte)1+(Byte)2 instanceof Integer
assert 1*2L instanceof Long

assert 1 + 0.5     == 1.5
assert 1/2 instanceof BigDecimal
assert (1/2)       == 0.5
assert (int)(1/2)  == 0
assert 1.intdiv(2) == 0

// no coercion when exceeding range with +
def a = Integer.MAX_VALUE
assert (a+1) instanceof Integer
assert (a+1) == Integer.MIN_VALUE
assert (a+1L) instanceof Long
assert (a+1G) instanceof BigInteger

// but does coerce with the power operator
assert 2**30 instanceof Integer
assert 2**31 instanceof BigInteger
assert 2**3.5 instanceof Double
assert 2G+1G  instanceof BigInteger
assert 2.5G+1G  instanceof BigDecimal

assert 0G == 0.0f
assert 1.5G == 1.5f
assert !(1.1G == 1.1f)
