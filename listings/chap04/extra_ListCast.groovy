Set names = ['Dierk', 'Paul'] as Set
assert names instanceof Set

assert names.toListString() ==~ /\[\w+, \w+\]/
assert names.asList() instanceof List

java.awt.Point p = [10, 20]
assert p.x == 10