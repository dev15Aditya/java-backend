import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    void twoPlusTwoFour() {
        var calc = new Calculator();
        assertEquals(4, calc.sum(2, 2));
    }
}
