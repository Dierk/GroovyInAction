[15, 0x1234ffff, 0b00110011, 100_000_000].each {
  assert it instanceof Integer
}
[100L, 200l].each{ assert it instanceof Long }
[1.23f, 4.56F].each{ assert it instanceof Float }
[1.23d, 4.56D].each{ assert it instanceof Double }
[123g, 456G, 1G].each{ assert it instanceof BigInteger }
[1.23, 4.56, 1.4E4, 2.8e4, 1.23g, 1.23G, 1.0, 1.0G, 0E1].each{
  assert it instanceof BigDecimal
}
