import org.junit.Test

class CalculatorTest {
    @Test
    void testAdd() {
        def calculator = new Calculator()
        assert 10 == calculator.add(3, 7)
    }
}
