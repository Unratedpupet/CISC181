import java.util.Scanner;

public class Lab2Practice {

    /**
     * <h1>Lab2Practice</h1>
     * <h2>CISC 181-052L Spring 2023</h2>
     * <h3>University of Delaware</h3>
     * <p>
     * The Lab2Practice program works on utilizing inputs/loops, basic iteration,
     * mutation of local variables, and writing methods.
     *
     * @author Zach Phillips
     * @since 2023-02-21
     */


    /**
     * This method asks for a user input and checks it for a usable action
     * Usable actions are A-Attack, M-Move, R-Recruit, S-Spawn
     *
     * @param input - Scanner object that is initialized in main()
     * @return actionChar - Returns the first character of the input as an UpperCase
     */
    public static char getUserNextActionType(Scanner input) {


        // Initializes response and asks for action
        String response = "";
        System.out.println("Please choose an action");
        response = input.next();
        // Initializes the Character at position 0 of the response
        char actionChar = response.charAt(0);
        actionChar = Character.toUpperCase(actionChar);

        // Checks response char against usable actions
        while ( (actionChar != 'A') && (actionChar != 'M') && (actionChar != 'R') && (actionChar != 'S')) {
            System.out.println("Please choose an action");
            response = input.next();
            actionChar = response.charAt(0);
            actionChar = Character.toUpperCase(actionChar);
            }


        return actionChar;
    }

    /**
     * This method asks the user to input an integer that is within the range specified by the
     * method call.
     *
     * @param min - Minimum int for the range of valid ints.
     * @param max - Maximum int for the range of valid ints.
     * @param input - Scanner object
     * @return - Returns the int value if it is in range.
     */
    public static int getValidInt(int min, int max, Scanner input) {
        // Initializes the response variable to be out of range.

        int response = min - 1;

        while ( !(response >= min) || !(response <= max) ) {
            System.out.println("Please enter a valid int: ");
            // Makes sure the input is an int.
            if ( input.hasNextInt() ) {
                response = input.nextInt();
                // Makes sure the response is within range.
                if ( response >= min && response <= max) {
                    return response;
                }

            }
            // If not an int, has another input request.
            else {

                input.next();
            }

            response = min -1;

        }

        return response;

    }


    /**
     * This function uses addition or subtraction to multiply
     *
     * @param x - Integer 1
     * @param y - Integer 2
     * @return - Returns the product of x and y
     */
    public static int multiplication(int x, int y) {

        int product = 0;
        // Returns 0 if either factor is 0.
        if ( x == 0 || y == 0) {
            return 0;
        }
        // Checks to see if both factors are positive.
        if (y > 0 && x > 0) {
            for (int i = 0; i < x; i++) {
                product = product + y;
            }
        }
        // Checks to see if x is negative, then adjusts for loop.
        else if (x < 0 ) {
            for (int i = 0; i > x; i--) {
                product = product - y;
            }
        }
        // Checks to see if y is negative, then adjusts for loop.
        else if (y < 0) {
            for (int i = 0; i > y; i--) {
                product = product - x;
            }
        }

        return product;
    }


    public static void main(String[] args) {
        String action;

        Scanner input = new Scanner(System.in);


        getUserNextActionType(input);
        getValidInt(-10, 10, input);

    }

}
