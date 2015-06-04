import org.junit.Test
import static org.junit.Assert.assertEquals
class SimpleJUnit4Test {
  @Test
  void shouldAdd() {
    assertEquals("Groovy should add correctly", 2, 1 + 1)
  }
}
