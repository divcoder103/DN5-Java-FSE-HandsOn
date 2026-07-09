import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calc;

    @BeforeEach
    void setup() {
        calc = new Calculator();
    }

    @Test
    void testAdd() {

        int actual = calc.add(2, 3);

        int expected = 5;

        assertEquals(expected, actual);
    }

    @Test
    void testSubtract() {

        int actual = calc.subtract(2, 3);

        int expected = -1;

        assertEquals(expected, actual);
    }

    @Test
    void testMultiply() {

        int actual = calc.multiply(4, 8);

        int expected = 32;

        assertEquals(expected, actual);
    }

    @Test
    void testDivide() {

        int actual = calc.divide(20, 5);

        int expected = 4;

        assertEquals(expected, actual);
    }

    @Test
    void testIsEven() {

        assertTrue(calc.isEven(8));
    }

    @Test
    void testIsPositive() {

        assertTrue(calc.isPositive(4));
    }

    @Test
    void testGetName() {

        String result = calc.getName();

        assertEquals("Calculator", result);
    }

    @Test
    void testGetNullValue() {

        String result = calc.getNullValue();

        assertNull(result);
    }
    @BeforeAll
    static void start(){
        System.out.println("Starting Test....");
    }
    @AfterEach
    void cleanup(){
        System.out.println("Cleaning Calculator...");
    }
    @AfterAll
    static void end(){
        System.out.println("All the Test Completed");
    }
    @Test
    void testNegative(){
        int number = -5;
        assertFalse(number >= 0 , "The Number should be Negative");
    }
}