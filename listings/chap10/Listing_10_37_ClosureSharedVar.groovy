import groovy.transform.TypeChecked

@TypeChecked
def captureOfALocalVariable() {
  def msg = 'Hello'                               //#A
  def cl = { msg = 'Hi!' }                        //#B
  assert msg == 'Hello'
  cl()                                            //#1
  assert msg == 'Hi!'
}

captureOfALocalVariable()
//#A Variable msg is closure shared variable
//#B Closure can write to msg
//#1 Closure is called
