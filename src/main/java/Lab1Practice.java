/**
 * <h1>Lab1</h1>
 * <h2>CISC 181-020L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * <p>
 * The Lab1 program implements an application that cover
 * the following topics: writing methods, boolean logic,
 * mutation of local variables, basic iteration, and
 * setting up JUnit testing.
 *
 * @author Zachary Phillips
 * @since 2023-02-14
 */


public class Lab1Practice {

    /**
     * Takes in the three sides of a scalene triangle
     * and finds the area of that triange.
     *
     *
     * @param a - Side a of the triange.
     * @param b - Side b of the triange.
     * @param c - Side c of the triange.
     * @return - The area of the scalene triangle in double format.
     */
    public static double areaScalene(double a, double b, double c) {

        double semiPerimeter;
        double area;
        // Gets the semi-perimeter
        semiPerimeter = (a + b + c) / 2;

        // Calculates the area
        area = Math.sqrt((semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter -c)));

        return area;
    }

    /**
     *
     * Uses the given chart to determine if the course load is acceptable based on
     * the Number of Credits and Number of Core Courses.
     *
     * @param numOfCredits - The number of credits the student is trying to take.
     * @param numOfCoreCourses - The number of core courses required.
     * @return - Returns a boolean of whether or not the course load is acceptable.
     */
    public static boolean okCourses(int numOfCredits, int numOfCoreCourses) {
        // Checks to see if the number of credits is in the allowable range.
        if ((numOfCredits <= 11) || (numOfCredits >= 20) ) {
            return false;
        }

        // Checks to make sure numOfCredits is in range
        // Then checks to make sure the numOfCoreCourses is in range of the listed table.
        if ( (numOfCredits >= 12) && (numOfCredits <= 14) ) {
            if (numOfCoreCourses >= 2) {
                return true;
            }
        }
        else if ( (numOfCredits >= 15) && (numOfCredits <= 19) ) {
            if (numOfCoreCourses >= 1) {
                return true;
            }
        }

        // Defaulting to false.
        return false;
    }


    public static void main(String[] args) {

        double testCase;

        testCase = areaScalene(2.2, 1.6, 3.4);
        System.out.println("a = 2.2");
        System.out.println("b = 1.6");
        System.out.println("c = 3.4");
        System.out.println(testCase);

    }
}
