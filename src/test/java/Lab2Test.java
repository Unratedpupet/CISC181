
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Lab2Test {

    @Test
    void roll() {

        System.out.println("Testing roll");
        assertEquals(0, Lab1.roll(2, 1));
    }
}