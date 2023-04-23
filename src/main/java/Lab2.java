
import java.util.Random;
import java.util.Scanner;


/**
 * <h1>Lab2</h1>
 * <h2>CISC 181-052L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * <p>
 * The Lab2 program works on utilizing inputs/loops, basic iteration,
 * mutation of local variables, and writing methods.
 *
 * @author Zach Phillips
 * @since 2023-02-21
 */
public class Lab2 {

    /**
     * This method uses Random to perform a random roll, and returns
     * that roll as an int.
     *
     * @param playerNum - The player number currently rolling.
     * @param playerRollAmount - The upper bound of the roll amount.
     * @return - Returns the roll amount as an int.
     */
    public static int roll(int playerNum, int playerRollAmount) {
        System.out.println("Player number " + playerNum + " is rolling!");
        Random rand = new Random();
        return rand.nextInt(playerRollAmount);
    }


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

            while ( playerOnesRoll > 0 && playerTwosRoll > 0) {
                // Checks to see if it is player one's turn.
                if (playerOnesTurn) {
                    System.out.println("Player one: Please enter a command.");
                    String input = scnr.nextLine();
                    System.out.println("You entered string: " + input);

                    // If the user inputs "/roll" the die is cast.
                    while (!input.equals("/roll")) {
                        System.out.println("Please enter a valid command");
                        input = scnr.nextLine();
                    }


                    System.out.println("Player " + playerOnesNum + " Rolling: 0 - " + playerTwosRoll);
                    // Uses roll method to roll the die between 0 and the current player 2 roll
                    playerOnesRoll = roll(playerOnesNum, playerTwosRoll);
                    System.out.println("Player " + playerOnesNum + " Rolled A " + playerOnesRoll);
                    // Changes player turn after rolling.
                    playerOnesTurn = false;
                    playerTwosTurn = true;


                }
                // Player two's turn
                else if (playerTwosTurn){
                    String input = scnr.nextLine();
                    System.out.println("You entered string: " + input);

                    // If the user inputs "/roll" the die is cast.
                    if (input.equals("/roll")) {
                        System.out.println("Player " + playerTwosNum + " Rolling: 0 - " + playerOnesRoll);
                        // Uses the roll method to roll the die between 0 and the current player 2 roll
                        playerTwosRoll = roll(playerTwosNum, playerOnesRoll);
                        System.out.println("Player " + playerTwosNum + " Rolled A " + playerTwosRoll);
                        // Changes player turn after rolling.
                        playerOnesTurn = true;
                        playerTwosTurn = false;
                    }

                }
            }
        // Finds the winner, and prints the answer
        if (playerOnesRoll < playerTwosRoll) {
            System.out.println("Player 2 wins");
        }
        else if ( playerOnesRoll > playerTwosRoll) {
            System.out.println("Player 1 wins");
        }
        else {
            System.out.println("Player 1 and Player 2 Tied");
        }
        scnr.close();
    }
}
