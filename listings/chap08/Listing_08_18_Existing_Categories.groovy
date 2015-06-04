import groovy.time.TimeCategory

def janFirst1970 = new Date(0)
use TimeCategory, {
    Date   xmas = janFirst1970 + 1.year - 7.days
    assert xmas.month == Calendar.DECEMBER
    assert xmas.date  == 25
}

use Collections, {
    def list     = [0, 1, 2, 3]
    list.rotate 1
    assert list == [3, 0, 1, 2]
}