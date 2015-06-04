//java.class.version
//jdk5=49.0
//jdk6=50.0
//jdk7=51.0
//jdk8=52.0
def code = '1 + '
code += System.getProperty('java.class.version')
assert code == '1 + 52.0'
assert 53.0 == evaluate(code)