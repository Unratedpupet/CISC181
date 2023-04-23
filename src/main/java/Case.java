
public class Case {

    private String ownerName;
    private String color;

    public Case(String ownerName, String color) {
        this.ownerName = ownerName;
        this.color = color;
    }

    public Case(){
        this.ownerName = "John Doe";
        this.color = "Blue";
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getColor() {
        return color;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //
    @Override
    public String toString(){
        return "Case Owner: " + ownerName + " , Color: " + color;
    }

    public static void main(String[] args) {
        Case sueCase = new Case("Sue", "Maroon");
        System.out.println(sueCase);

    }
}
