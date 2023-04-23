import java.util.ArrayList;
public class PracticeSet5 {
    public static void main(String[] args) {
        // Put your code in this method under the appropriate comment

        // 1) make an ArrayList called schoolBooks to hold books
        ArrayList<Book> schoolBooks = new ArrayList<>();

        // 2) add a 250 page college ruled notebook to your list
        schoolBooks.add(new Notebook(250,10.0, true));

        // 3) add a 300 page notebook that is not college ruled to your list
        schoolBooks.add(new Notebook(300, 12.0, false));


        // 4) add a 100 page textbook to your list
        schoolBooks.add(new Textbook(100, 20.0, "Math"));


        // 5) print the price of the textbook from your list
        System.out.println(schoolBooks.get(2).getPrice());
        //  6) create a for loop to print each book in your list
        for (int i = 0; i < schoolBooks.size(); i++) {
            System.out.println(schoolBooks.get(i));
        }

        // 7. Assume you did the last step correctly – what exactly is displayed? Put your answer in the comment provided below
        /*
        College Ruled NB: 250
        NB: 300
        Math 100

         */


        // Do not modify this class otherwise
    }
}


abstract class Book{
    private int numPages;
    private double price;

    public Book(int numPages, double price){
        this.numPages = numPages;
        this.price = price;
    }
    public int getPages() {return numPages;}
    public double getPrice() {return price;}
    public String toString(){
        return "Book: " + numPages ;
    }
}

class Notebook extends Book{
    private boolean collegeRuled;
    public Notebook(int pgs, double p, boolean c){
        super(pgs, p);
        collegeRuled = c;
    }
    public String toString(){
        if (collegeRuled)
            return "College Ruled NB: " + getPages();
        else
            return "NB: " + getPages();
    }
}

class Textbook extends Book{
    private String name;
    public Textbook(int pgs, double p, String name){
        super(pgs, p);
        this.name = name;}
    public String toString(){
        return name + " " + getPages();
    }
}
