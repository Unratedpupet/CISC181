
import java.util.Scanner;

public class activity1 {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        String password = "asd"; 
        String enteredPassword = "";
        
        do {
            enteredPassword = scnr.nextLine();
        }
        while(!enteredPassword.equals(password));
        /*


        String message = "";

        // Can check the condition by itself without the boolean.
        while (!isPassword) {
            System.out.print("Enter password: ");
            enteredPassword = scnr.nextLine();

            if (enteredPassword.equals(password)) {
                isPassword = true;
            }
        }
        */


        /**
        while ( !message.equals("yes") && !message.equals("no")) {
            System.out.println("Are you taking CISC 181?");
            message = scnr.nextLine();
        }
        */

        scnr.close();
    }

}
