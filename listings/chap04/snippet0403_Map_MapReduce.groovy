def people = [peter: 40, paul: 30, mary: 20]
assert people
    .findAll{ _, age -> age < 35 }
    .collect{ name, _ -> name.toUpperCase() }
    .sort()
    .join(', ') == 'MARY, PAUL'
