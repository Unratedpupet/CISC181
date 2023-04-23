
import java.util.Random;

/**
 * <h1>Lab0</h1>
 * <h2>CISC 181-052L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * <p>
 * The Lab0 program implements an application that helps
 * translate from Python into Java syntax.
 *
 * @author Zach Phillips
 * @since 2023-02-07
 */

public class Lab0 {

    public static double celsiusToFahrenheit(double cdeg) {
        return 32.0 + (cdeg * 1.8);
    }

    public static void main(String[] args) {
        // Expression
        System.out.println(5 + 10);

        // Definition/Variable assignment
        double lbsToKilo = 0.45359237;
        System.out.println(175 * lbsToKilo);

        // Variable re-assignment (mutation)
        int age = 19;
        System.out.println(age);
        age = age + 1;
        System.out.println(age);

        // Selection (conditional)
        int joeAge = 25;
        if (joeAge < 18) {
            System.out.println("minor");
        }
        else if (joeAge < 65) {
            System.out.println("adult");
        }
        else {
            System.out.println("senior");
        }

        // Repetition (definite/fixed iteration loop)
        int total = 0;
        for (int i = 0; i < 10; i++) {
            total += i;
        }
        System.out.println(total);

        // Repetition (indefinite/conditional loop)
        int guess = 1;
        Random rand = new Random();
        while (guess % 7 != 0) {
            guess = rand.nextInt(100); }
        System.out.println(guess);

        System.out.println(celsiusToFahrenheit(25.0));
    }
}
