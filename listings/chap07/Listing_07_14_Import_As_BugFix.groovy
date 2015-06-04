import thirdparty.MathLib as OrigMathLib

class MathLib extends OrigMathLib {
    Integer twice(Integer value) {
        return value * 2
    }
}

// nothing changes below here                          //#A
def mathlib = new MathLib()

assert 10 == mathlib.twice(5)                          //#B
assert 2 == mathlib.half(5)                            //#C
//#A Usage code for library remains unchanged
//#B Invoke fixed method
//#C Invoke original method
