public class Practiceset2 {
  public static void main(String[] args) {
    // Your code goes here
    int[][][] intArray = new int[5][2][4];
    
	intArray[0][0][0] = 1;
    intArray[2][0][2] = 1;
    intArray[0][1][0] = -1;
    intArray[4][0][0] = 1;
    intArray[1][1][3] = 1;
    intArray[3][0][2] = -1;
    intArray[2][1][0] = 1;
    intArray[1][0][3] = 1;
    intArray[4][0][1] = 1;
    intArray[2][1][0] = -1;


    for (int[][] ints : intArray) {
      for (int j = 0; j < intArray.length; j++) {
        for (int k = 0; k < intArray.length; k++) {
          System.out.println(ints[j][k]);
        }
      }
    }
    // Do not modify this class otherwise
  }
}