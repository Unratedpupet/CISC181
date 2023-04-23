
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Method;

public class CellPhoneCaseTest {
    @Test
    public void testingInheritance() {
        System.out.println("Testing CellPhoneCase class");
// Testing whether CellPhoneCase is derived from Case class
// instances of CellPhoneCase ARE also instances of Case
        CellPhoneCase myCase = new CellPhoneCase("Me", "gold",
                "123-456-7890");
        assertTrue(myCase instanceof Case);
// Testing that CellPhoneCase class did not override the getOwnerName and getColor methods
        try {
            Method meth = CellPhoneCase.class.getDeclaredMethod("getOwnerName");
            System.out.println("getOwnerName should not be defined in CellPhoneCase class. It is" +
            "inherited from the Case class.");
        } catch (NoSuchMethodException e) {
        }
        try {
            Method meth = CellPhoneCase.class.getDeclaredMethod("getColor");
            System.out.println("getColor should not be defined in CellPhoneCase class. It is " +
            "inherited from the Case class.");
        } catch (NoSuchMethodException e) {
        }
    }
    @Test
    public void testing_constructor() {
        System.out.println("Testing CellPhoneCase constructor");
        CellPhoneCase myCase = new CellPhoneCase("Me", "gold",
                "123-456-7890");
        assertEquals("Me", myCase.getOwnerName());
        assertEquals("gold", myCase.getColor());
        assertEquals("Me", myCase.getCellPhone().getOwnerName());
        assertEquals("123-456-7890", myCase.getCellPhone().getPhoneNumber());
// Initially phone's ring tone should be set to "beep"
        assertEquals("beep", myCase.getCellPhone().getRingTone());
// Initially phone should have do not disturb set to false
        assertFalse(myCase.getCellPhone().isDoNotDisturb());
    }
}