@Grab('net.java.quickcheck:quickcheck:0.6')
import static net.java.quickcheck.generator.PrimitiveGenerators.*
import static net.java.quickcheck.generator.CombinedGeneratorsIterables.*

for (words in someNonEmptyLists(strings())) {
  assert words*.size().sum() == words.sum().size()
}
