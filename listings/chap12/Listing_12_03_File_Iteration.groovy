file = new File('Listing_12_03_File_Iteration.groovy')
file.each { println it }
assert file.any { it =~ /File/ }
assert 3 == file.findAll { it =~ /File/ }.size()

assert 5 == file.grep { it }.size()
