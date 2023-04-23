import java.util.Random;

public class Practiceset2 {
  public static void main(String[] args) {
    // Your code goes here
    int[][] intArray = new int[3][];
    int sum = 0;
    int count = 0;

    intArray[0] = new int[5];
    intArray[1] = new int[3];
    intArray[2] = new int[4];


    Random rand = new Random();

    for (int i = 0; i < intArray.length; i++) {
      for (int j = 0; j < intArray[i].length; j++) {
        intArray[i][j] = rand.nextInt(30 + 10) - 10;
      }
    }

    for (int i = 0; i < intArray.length; i++) {
      for (int j = 0; j < intArray[i].length; j++) {
        if (intArray[i][j] > 0) {
          sum += intArray[i][j];
          count++;
        }
      }
    }

    System.out.println("The average is " + sum/count);


    // Do not modify this class otherwise
  }
}