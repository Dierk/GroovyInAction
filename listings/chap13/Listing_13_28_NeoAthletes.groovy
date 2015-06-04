@Grab('org.neo4j:neo4j-kernel:2.1.6')
@Grab('org.neo4j:neo4j-lucene-index:2.1.6;transitive=false')
@Grab('org.apache.lucene:lucene-core:3.6.2')
import org.neo4j.graphdb.*
import org.neo4j.graphdb.traversal.*
import static util.Neo4jUtil.*
import static util.MarathonRelationships.*

def db = create()
def tx = null
def athlete1, athlete2, athlete3, athlete4
def record1, record2a, record2b, record3, record4a, record4b
try {
  tx = db.beginTx()

  athlete1 = db.createNode()                                        //#A
  athlete1.first = 'Paul'                                           //#A
  athlete1.last = 'Tergat'                                          //#A
  athlete1.dob = '1969-06-17'                                       //#A

  record1 = db.createNode()                                         //#B
  record1.time = 2 * 60 * 60 + 4 * 60 + 55                          //#B
  record1.venue = 'Berlin'                                          //#B
  record1.when = '2003-09-28'                                       //#B

  athlete1.set(record1)

  assert 'Paul Tergat won the Berlin marathon on 2003-09-28' ==
      "$athlete1.first $athlete1.last won the " +
      "$record1.venue marathon on $record1.when"

  athlete2 = insertAthlete(                                         //#C
      db, 'Khalid', 'Khannouchi', '1971-12-22')                     //#C
  record2a = insertRecord(                                          //#C
      db, 2, 5, 38, 'London', '2002-04-14', athlete2)               //#C
  record2b = insertRecord(                                          //#C
      db, 2, 5, 42, 'Chicago', '1999-10-24', athlete2)              //#C

  athlete3 = insertAthlete(db, 'Ronaldo', 'da Costa', '1970-06-07')
  record3 = insertRecord(db, 2, 6, 5, 'Berlin', '1998-09-20', athlete3)

  athlete4 = insertAthlete(db, 'Paula', 'Radcliffe', '1973-12-17')
  record4a = insertRecord(
      db, 2, 17, 18, 'Chicago', '2002-10-13', athlete4)
  record4b = insertRecord(
      db, 2, 15, 25, 'London', '2003-04-13', athlete4)

  def allAthletes = [athlete1, athlete2, athlete3, athlete4]        //#D
  def londonRecords = allAthletes.findAll { athlete ->              //#D
    athlete.getRelationships(set).any {       //#D
      record -> record.getOtherNode(athlete).venue == 'London'      //#D
    }                                                               //#D
  }                                                                 //#D
  assert londonRecords*.last == ['Khannouchi', 'Radcliffe']

  record2b.broke(record3)                                           //#E
  record2a.broke(record2b)                                          //#E
  record1.broke(record2a)                                           //#E
  record4b.broke(record4a)                                          //#E

  def result = []                                                   //#F
  for (Path p in db.traversalDescription().breadthFirst().          //#F
      relationships(broke).                                         //#F
      evaluator(Evaluators.fromDepth(1)).                           //#F
      uniqueness(Uniqueness.NONE).                                  //#F
      traverse(record3)) {                                          //#F
    def newRecord = p.endNode()                                     //#F
    result << "$newRecord.venue $newRecord.when"                    //#F
  }                                                                 //#F
  def expected = ['Chicago 1999-10-24',
                  'London 2002-04-14',
                  'Berlin 2003-09-28']
  assert expected == result

  tx.success()
} finally {
  tx?.close()
  // for the benefit of alltests, don't wait for shutdown hook
  db?.shutdown()
}
//#A Create athlete1 by hand
//#B Create record1 by hand
//#C Create using utility methods
//#D Find athletes holding a record set in London
//#E Additional graph edges of interest
//#F Find world records superseding record3