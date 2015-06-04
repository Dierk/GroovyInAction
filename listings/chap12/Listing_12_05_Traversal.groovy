import static groovy.io.FileType.ANY
import static groovy.io.FileVisitResult.SKIP_SUBTREE

def totalSize = 0
def count = 0
def sortByTypeThenName = { a, b ->
  a.isFile() != b.isFile() ?
      a.isFile() <=> b.isFile() :
      a.name <=> b.name
}
def log = []

inputDir = new File('../chap09/')

inputDir.traverse(
    type         : ANY,
    nameFilter   : ~/.*groovy.*/,
    excludeNameFilter : ~/.*Test.*/,
    preDir       : {
      if (it.name =~ '.?gradle|build') return SKIP_SUBTREE
      count = 0
      totalSize = 0
    },
    postDir      : {
      if (count) {
        log << "Found $count files in $it.name : $totalSize bytes"
        count = 0
        totalSize = 0
      }
    },
    postRoot     : true,
    sort         : sortByTypeThenName
) {it -> totalSize += it.size(); count++ }
println log.join('\n')
assert log.size() == 3
assert log*.replaceAll(/\d+/, '*').join('\n') == '''
Found * files in regina : * bytes
Found * files in services : * bytes
Found * files in chap* : * bytes
'''.trim()
