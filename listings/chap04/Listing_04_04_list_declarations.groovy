List myList = [1, 2, 3]

assert myList.size() == 3
assert myList[0]     == 1
assert myList instanceof ArrayList

List emptyList = []
assert emptyList.size() == 0

List longList = (0..1000).toList()
assert longList[555] == 555

List explicitList = new ArrayList()
explicitList.addAll(myList)                            //#1
assert explicitList.size() == 3
explicitList[0] = 10
assert explicitList[0] == 10

explicitList = new LinkedList(myList)                  //#1
assert explicitList.size() == 3
explicitList[0] = 10
assert explicitList[0] == 10
//#1 Fill from myList

//////////////////////// extra examples:
assert args instanceof String[]                        //#2
assert args.size() == 0                                //#3

List flat = [0, *myList, 4]                            //#4
assert flat == [0, 1, 2, 3, 4]
//#2 Command-line args
//#3 Array as list
//#4 Spread