package util

@Grab('org.neo4j:neo4j-kernel:2.1.6')
import org.neo4j.graphdb.*

enum MarathonRelationships implements RelationshipType {
  set, broke
}
