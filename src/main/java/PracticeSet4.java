/**
 * Part A) In the main method:
 *
 * create one Bead object that is not attached to another Bead object
 * create one Bracelet object that contains your newly created Bead object
 * create another Bead with a different color than the first Bead you created
 * add it to your Bracelet using the addBead method
 * What is the order of the bead colors in your Bracelet? - write a comment inside of main with the answer
 * Part B) Fill in the missing code in the countBeads method in the Bracelet class. (It helps to draw it.)
 */


public class PracticeSet4 {
    public static void main(String[] args) {
        // Put your code for Part C here


        // The order of the bead colors is:

        // Do not modify this class otherwise
    }
}

class Bead{
    private String color;
    private Bead next;

    public Bead(String color, Bead next) {
        this.color = color;
        this.next = next;
    }
    public String getColor() { return color;}
    public Bead getNext(){ return next;}

    public void setNext(Bead next){ this.next = next;}
}

class Bracelet {
    private Bead start;

    public Bracelet () {start = null;}

    public Bead getStart(){return start;}

    public void addBead(Bead bead){
        bead.setNext(start);
        start = bead;
    }

  /* Uncomment this method and complete it as part B
  This method should return the number of bead in the bracelet
  public int countBeads(){

  }
  */
}

