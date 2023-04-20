import java.util.Scanner;

public class activityWeek3 {

    /**
     * Prints out the square roots from the start number to the
     * finish number.
     *
     * @param start - The starting integer.
     * @param finish - The finish integer
     */
    public static void printSquareRoots(int start, int finish) {

        double squareRoot;

        for (int i = start; i <= finish; i++) {
            squareRoot = Math.sqrt(i);
            System.out.println(squareRoot);
        }

    }


    public static void main(String[] args) {
        /**
         * ask user to enter age, if anything other than an int, ask again.
         * Errors out, does not work well
         */
//
//        Scanner input = new Scanner(System.in);
//        int userAge = 0;
//
//
//        while (!input.hasNextInt()) {
//            System.out.println("How old are you?");
//
//            userAge = input.nextInt();
//
//        }
        printSquareRoots(4,10);




    }
}
