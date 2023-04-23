
public class PracticeSet4 {
    public static void main(String[] args) {
        // Put your code for Part A here

        //Create bead
        Bead bead1 = new Bead("Red", null);
        //Create bracelet then add the new bead.
        Bracelet braceletOne = new Bracelet();
        braceletOne.addBead(bead1);
        //New bead w/ new color
        Bead bead2 = new Bead("Green", null);
        braceletOne.addBead(bead2);

        System.out.println(braceletOne.getStart().getColor());
        System.out.println(braceletOne.getStart().getNext().getColor());

        System.out.println(braceletOne.countBeads());



        // The order of the bead colors is:
        //Green -> Red
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

   */
  public int countBeads(){
    int beadCount = 0;
    Bead temp = this.start;
    if (getStart() == null) {
        return 0;
    }
    while (temp != null) {
        beadCount++;
        temp = temp.getNext();
    }



    return beadCount;
  }

}

