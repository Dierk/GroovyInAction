def a = 1;      assert a instanceof Integer   //|#1
def b = 1.0f;   assert b instanceof Float     //|#1

int c = 1;      assert c instanceof Integer   //|#2
float d = 1;    assert d instanceof Float     //|#2

Integer e = 1;  assert e instanceof Integer   //|#3
String f = '1'; assert f instanceof String    //|#3