
public class ArrayStaticMethods {

    /**
     *  Returns the sum of the squares of all the positive values in the array
     * @param data ->  array of
     * @return -> Returns the sum of all the positive values in the array
     */
    public static double sumSqrPos(double[] data) {
        double sum = 0.0;

        for (int i = 0; i < data.length; i++) {
            if (data[i] > 0 ) {
                sum += data[i] * data[i];
            }
        }

    return sum;
    }


    /**
     * This method takes in an array of chars, and then counts the number of times the
     * specified char is found in that array.
     *
     * @param arrayChars -> The array of chars that is being tested.
     * @param searchChar -> The char that is being counted.
     * @return -> Returns the int count of how many times the char was found.
     */
    public static int countChars(char[] arrayChars, char searchChar) {

        int count = 0;
        for (int i = 0; i < arrayChars.length; i++) {
            if (arrayChars[i] == searchChar) {
                count += 1;
            }
        }
        return count;
    }

    /**
     * This method takes in an array of ints, and replaces any instance of value1 with value2
     * @param data -> The array of ints to be checked.
     * @param value1 -> Value to be checked.
     * @param value2 -> Value to replace the checked value.
     * @return -> A NEW array of ints with the replaced value.
     */
    public static int[] replace(int[] data, int value1, int value2) {
        int[] newArray = data;

        for (int i =0; i < newArray.length; i++) {
            if (newArray[i] == value1) {
                newArray[i] = value2;
            }

        }
        return newArray;
    }

    /**
     * This method takes in an array, and moves negative numbers to the front of the array
     * @param data -> The array of ints to be sorted.
     * @return -> Returns a new array with the sorted array.
     */
    public static int[] moveNegatives(int[] data) {
        int[] newData = new int[data.length];
        int num = 0;
        //iterate through, and add negatives to the new array, and then iterate again, adding positives.
        for (int i = 0; i < data.length; i++) {
            if (data[i] < 0) {
                newData[num] = data[i];
                num += 1;
            }
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i] >= 0) {
                newData[num] = data[i];
                num += 1;
            }
        }

        return newData;
    }
}
