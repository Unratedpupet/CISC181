
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * <h1>Lab1PracticeTest</h1>
 * <h2>CISC 181-052L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * <p>
 * The Lab1PracticeTest program implements an application that cover
 * the following topics: writing methods, boolean logic,
 * mutation of local variables, basic iteration, and
 * setting up JUnit testing.
 *
 * @author Zach Phillips
 * @since 2023-02-14
 */
public class Lab1PracticeTest {
    @Test
    void testAreaScalene() {
        System.out.println("Testing area scalene");
        assertEquals(3.96, Lab1Practice.areaScalene(5.5,3.4,8.7), 0.0001);
        assertEquals(4.118, Lab1Practice.areaScalene(3.2,2.6,4.4), 0.0001);
        assertEquals(1.4198591479439084, Lab1Practice.areaScalene(2.2,1.6,3.4), 0.0001);
    }

    @Test
    void testOkCourses() {
        System.out.println("Testing okCourses");
        assertFalse(Lab1Practice.okCourses(11,4));
        assertFalse(Lab1Practice.okCourses(14,1));
        assertTrue(Lab1Practice.okCourses(12,3));
        assertTrue(Lab1Practice.okCourses(16,1));
        assertFalse(Lab1Practice.okCourses(14,1));

    }

}

