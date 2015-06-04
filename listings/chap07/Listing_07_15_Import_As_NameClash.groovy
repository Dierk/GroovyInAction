import thirdparty.MathLib as TwiceHalfMathLib
import thirdparty2.MathLib as IncMathLib

def math1 = new TwiceHalfMathLib()
def math2 = new IncMathLib()

assert 3 == math1.half(math2.increment(5))