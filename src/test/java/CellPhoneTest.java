import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CellPhoneTest {
    @Test
    public void noParamConstructor() throws Exception {
        CellPhone c = new CellPhone();
        assertEquals("John Doe", c.getOwnerName());
        assertEquals("1234567890", c.getPhoneNumber());
        assertEquals("beep", c.getRingTone());
        assertFalse(c.isDoNotDisturb());
    }
    @Test
    public void twoParamConstructor() throws Exception {
        CellPhone c = new CellPhone("Bob", "8675309");
        assertEquals("beep", c.getRingTone());
        assertFalse(c.isDoNotDisturb());
    }
    @Test
    public void getOwnerName() throws Exception {
        CellPhone c1 = new CellPhone("Bob", "8675309");
        CellPhone c2 = new CellPhone("Mary", "1234567890");
        assertEquals("Bob", c1.getOwnerName());
        assertEquals("Mary", c2.getOwnerName());
    }
    @Test
    public void getPhoneNumber() throws Exception {
        CellPhone c1= new CellPhone("Bob", "8675309");
        CellPhone c2 = new CellPhone("Mary", "1234567890");
        assertEquals("8675309", c1.getPhoneNumber());
        assertEquals("1234567890", c2.getPhoneNumber());
    }
    @Test
    public void getRingTone() throws Exception {
        CellPhone c = new CellPhone("Bob", "8675309");
        assertEquals("beep", c.getRingTone());
    }
    @Test
    public void isDoNotDisturb() throws Exception {
        CellPhone c = new CellPhone("Bob", "8675309");
        assertFalse(c.isDoNotDisturb());
    }
    @Test
    public void setRingTone() throws Exception {
        CellPhone c = new CellPhone("Bob", "8675309");
        c.setRingTone("jingle");
        assertEquals("jingle", c.getRingTone());
        c.setRingTone("beep");
        assertEquals("beep", c.getRingTone());
    }
    @Test
    public void setDoNotDisturb() throws Exception {
        CellPhone c = new CellPhone("Bob", "8675309");
        assertFalse(c.isDoNotDisturb());
        c.setDoNotDisturb(true);
        assertTrue(c.isDoNotDisturb());
        c.setDoNotDisturb(false);
        assertFalse(c.isDoNotDisturb());
    }
    @Test
    public void incomingCall() throws Exception {
        System.out.println("Testing incoming call");
// Create a stream to hold the output -Save the old System.out!
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
// Print output: goes to special stream
        CellPhone cell = new CellPhone("Wen","444-66-3333");
        cell.incomingCall();
        assertEquals("beep", baos.toString());
        cell.setDoNotDisturb(true);
        cell.incomingCall();
        assertEquals("beepshhh",baos.toString());
// output back to console
        System.out.flush();
        System.setOut(old);
    }
    @Test
    public void test_cell_toString() throws Exception {
        System.out.println("Testing to_String");
        CellPhone cell = new CellPhone("Wen","444-66-3333");
        assertTrue(cell.toString().equals("Phone Owner : Wen , Number : 444-66-3333"));
    }
}
