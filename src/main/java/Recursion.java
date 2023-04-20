public class Recursion {
    public static void mystery1(int num) {
        if (num >= 0 && num <= 9){
            System.out.println(num);
        }
        else{
            System.out.println(num % 10);
            mystery1(num / 10);
        }
    }
    public static int mystery2(int num) {
        if(num == 1) {
            return 5;
        }
        else {
            return mystery2(num - 1) + 5;
        }
    }
    public static int mystery3(int num) {
        if(num - 5 < 0) {
            return num;
        }
        else if(num == 5){
            return 0;
        }
        else {
            return mystery3(num - 5);
        }
    }
    public static void main(String[] args) {
        int orig = 1234;
        System.out.println("Test");
        mystery1(orig);
        System.out.println("test 1");
        System.out.println(mystery2(3));
        System.out.println("Test 2");
        System.out.println(mystery3(8));
        System.out.println("Test 3");
        System.out.println(mystery3(10));
        System.out.println("Test 4");
        System.out.println(mystery3(4));
    }
}