def tzones = [
    dierk: +1, guillaume: +1, jon: 0,
    paul:  +9, tara: -7
]
assert tzones.groupBy { key, val -> val.intdiv 5 } == [
    0: [dierk:1, guillaume:1, jon:0],
    1: [paul: 9],
 (-1): [tara:-7]
]   