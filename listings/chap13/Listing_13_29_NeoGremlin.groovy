@Grab('org.neo4j:neo4j-kernel:2.1.6')
@Grab('org.neo4j:neo4j-management:2.1.6')
@Grab('org.neo4j:neo4j-cypher:2.1.6;transitive=false')
@Grab('org.neo4j:neo4j-cypher-commons:2.1.6;transitive=false')
@Grab('org.neo4j:neo4j-cypher-compiler-1.9:2.0.4;transitive=false')
@Grab('org.neo4j:neo4j-cypher-compiler-2.0:2.0.4;transitive=false')
@Grab('org.neo4j:neo4j-cypher-compiler-2.1:2.1.6;transitive=false')
@Grab('org.neo4j:neo4j-lucene-index:2.1.6;transitive=false')
@Grab('org.apache.lucene:lucene-core:3.6.2')
@Grab('com.tinkerpop.gremlin:gremlin-groovy:2.6.0;transitive=false')
@Grab('com.tinkerpop.gremlin:gremlin-java:2.6.0;transitive=false')
@Grab('com.tinkerpop.blueprints:\
blueprints-neo4j2-graph:2.6.0;transitive=false')
@Grab('commons-configuration:commons-configuration:1.6')
@Grab('com.tinkerpop.blueprints:blueprints-core:2.6.0;transitive=false')
@Grab('com.tinkerpop:pipes:2.6.0;transitive=false')
@Grab('org.parboiled:parboiled-scala_2.10:1.1.6;transitive=false')
@Grab('org.parboiled:parboiled-core:1.1.6')
@Grab('org.scala-lang:scala-library:2.10.4')
@Grab('com.googlecode.concurrentlinkedhashmap:\
concurrentlinkedhashmap-lru:1.4.1')
@GrabExclude('junit:junit')
@GrabExclude('org.hamcrest:hamcrest-all')
@GrabExclude('org.mockito:mockito-core')

import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.impls.neo4j2.Neo4j2Graph
import com.tinkerpop.gremlin.groovy.Gremlin
import static util.Neo4jUtil.*

def db = create()
def tx = null
def athlete1, athlete2, athlete3, athlete4
def record1, record2a, record2b, record3, record4a, record4b

Gremlin.load()

try {
    tx = db.beginTx()

    // create athlete1 .. athlete4
    athlete1 = insertAthlete(db, 'Paul', 'Tergat', '1969-06-17')
    record1 = insertRecord(
        db, 2, 4, 55, 'Berlin', '2003-09-28', athlete1)

    athlete2 = insertAthlete(db, 'Khalid', 'Khannouchi', '1971-12-22')
    record2a = insertRecord(
        db, 2, 5, 38, 'London', '2002-04-14', athlete2)
    record2b = insertRecord(
        db, 2, 5, 42, 'Chicago', '1999-10-24', athlete2)

    athlete3 = insertAthlete(db, 'Ronaldo', 'da Costa', '1970-06-07')
    record3 = insertRecord(
        db, 2, 6, 5, 'Berlin', '1998-09-20', athlete3)

    athlete4 = insertAthlete(db, 'Paula', 'Radcliffe', '1973-12-17')
    record4a = insertRecord(
        db, 2, 17, 18, 'Chicago', '2002-10-13', athlete4)
    record4b = insertRecord(
        db, 2, 15, 25, 'London', '2003-04-13', athlete4)

    record2b.broke(record3)
    record2a.broke(record2b)
    record1.broke(record2a)
    record4b.broke(record4a)

    Graph g = new Neo4j2Graph(db)

    def pretty = { it.collect { "$it.venue $it.when" }.join(', ') }
    def results = []
    g.V('venue', 'London').fill(results)
    println 'London world records: ' + pretty(results)

    results = []
    g.V('venue', 'London').in('broke').fill(results)
    println 'World records after London: ' + pretty(results)

    results = []
    def emitAll = { true }
    def forever = { true }
    def berlin98 = { it.venue == 'Berlin' &&
            it.when.startsWith('1998') }
    g.V.filter(berlin98).in('broke').
            loop(1, forever, emitAll).fill(results)
    println 'World records after Berlin 1998: ' + pretty(results)
    tx.success()
} finally {
    tx?.close()

}
