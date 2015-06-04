package util

@Grab('org.neo4j:neo4j-kernel:2.1.6')
@Grab('org.neo4j:neo4j-lucene-index:2.1.6;transitive=false')
@Grab('org.apache.lucene:lucene-core:3.6.2')
import org.neo4j.graphdb.*
import org.neo4j.graphdb.factory.GraphDatabaseFactory

class Neo4jUtil {
  static create() {                          //#A
    def factory = new GraphDatabaseFactory()
    def db = factory.newEmbeddedDatabase("marathon")
    addShutdownHook { db.shutdown() }

    GraphDatabaseService.metaClass {
      createNode { Map properties ->
        def n = delegate.createNode()
        properties.each { k, v -> n[k] = v }
        n
      }
    }
    Node.metaClass {
      propertyMissing { String name, val ->
        delegate.setProperty(name, val) }
      propertyMissing { String name ->
        delegate.getProperty(name) }
      methodMissing { String name, args ->
        delegate.createRelationshipTo(args[0],
            MarathonRelationships."$name")
      }
    }
    Relationship.metaClass {
      propertyMissing { String name, val ->
        delegate.setProperty(name, val) }
      propertyMissing { String name ->
        delegate.getProperty(name) }
    }
    db
  }

  static insertAthlete(db, first, last, dob) {              //#B
    db.createNode(first: first, last: last, dob: dob)
  }

  static insertRecord(db, h, m, s, venue, when, athlete) {  //#C
    def secs = h * 60 * 60 + m * 60 + s
    def record = db.createNode(time: secs, venue: venue, when: when)
    athlete.set(record)
    record
  }
}
//#A Create database and turn on metaClass syntactic sugar
//#B Utility method to create athlete
//#C Utility method to create record
