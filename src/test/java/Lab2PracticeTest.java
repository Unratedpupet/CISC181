import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lab2PracticeTest {

    @Test
    void multiplication() {
        System.out.println("Testing Multiplication");
        assertEquals(10,Lab2Practice.multiplication(2,5));
        assertEquals(8, Lab2Practice.multiplication(-2,-4));
        assertEquals(-15, Lab2Practice.multiplication(-3,5));
        assertEquals(-12, Lab2Practice.multiplication(2,-6));
        assertEquals(0, Lab2Practice.multiplication(2,0));
        assertEquals(0, Lab2Practice.multiplication(0,5));
        System.out.println("Testing Multiplication successful");
    }
}