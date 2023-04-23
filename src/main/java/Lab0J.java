
import java.util.Random;
import java.util.Scanner;


/**
 * <h1>Lab0</h1>
 * <h2>CISC 181-052L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * <p>
 * The Lab0 program implements an application that converts
 * an existing python program into a java application
 *
 * @author Zach Phillips
 * @since 2023-02-07
 */
public class Lab0J {
    public static void main(String[] args) {
        // Initiates both players
        int playerOnesNum = 1;
        boolean playerOnesTurn = true;
        int playerOnesRoll = 10000;

        int playerTwosNum = 2;
        boolean playerTwosTurn = false;
        int playerTwosRoll = 10000;

        // Creates a scanner to allow for input.
        Scanner scnr = new Scanner(System.in);

        // Checks to see if it is player one's turn.
        if (playerOnesTurn && !playerTwosTurn) {
            String s = scnr.nextLine();
            System.out.println("You entered string: " + s);

            // If the user inputs "/roll" the die is cast.
            if (s.equals("/roll")) {
                System.out.println("Player " + playerOnesNum + " Rolling: 0 - " + playerTwosRoll);
                // Uses random.nextInt to roll the die between 0 and the current player 2 roll
                Random rand = new Random();
                playerOnesRoll = rand.nextInt(0, playerTwosRoll);
                System.out.println("Player " + playerOnesNum + " Rolled A " + playerOnesRoll);
                // Changes player turn after rolling.
                playerOnesTurn = false;
                playerTwosTurn = true;

            }
        }
        // Player two's turn
        else {
            String s = scnr.nextLine();
            System.out.println("You entered string: " + s);

            // If the user inputs "/roll" the die is cast.
            if (s.equals("/roll")) {
                System.out.println("Player " + playerTwosNum + " Rolling: 0 - " + playerOnesRoll);
                // Uses random.nextInt to roll the die between 0 and the current player 2 roll
                Random rand = new Random();
                playerTwosRoll = rand.nextInt(0, playerOnesRoll);
                System.out.println("Player " + playerTwosNum + " Rolled A " + playerTwosRoll);
                // Changes player turn after rolling.
                playerOnesTurn = true;
                playerTwosTurn = false;
            }

        }
        // Finds the winner, and prints the answer
        if (playerOnesRoll > playerTwosRoll) {
            System.out.println("Player 2 wins");
        }
        else if ( playerOnesRoll < playerTwosRoll) {
            System.out.println("Player 1 wins");
        }
        else {
            System.out.println("Player 1 and Player 2 Tied");
        }
        scnr.close();
    }
}
