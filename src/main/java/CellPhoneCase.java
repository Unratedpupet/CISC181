public class CellPhoneCase extends Case{

    private CellPhone cell;

    public CellPhoneCase(String ownerName, String color, String phoneNumber) {
        super(ownerName, color);
        this.cell = new CellPhone(ownerName, phoneNumber);

    }

    public CellPhone getCellPhone() {
        return this.cell;
    }

    public void quietPhone() {
        this.cell.setDoNotDisturb(true);
    }

    public static void swapPhones(CellPhoneCase oldPhoneCase, CellPhoneCase newPhoneCase){
        CellPhone temp1 = oldPhoneCase.cell;
        oldPhoneCase.cell = newPhoneCase.cell;
        newPhoneCase.cell = temp1;

    }

    @Override
    public String toString() {
        return super.toString() + " , " + cell;
    }

    public static void main(String[] args) {
        CellPhoneCase cell1Case = new CellPhoneCase("Tim", "black", "111-222-3333");
        CellPhoneCase cell2Case = new CellPhoneCase("Neena", "blue", "444-555-6666");

        System.out.println(cell1Case);
        System.out.println(cell2Case);

        System.out.println("Swapping cases");
        cell1Case.swapPhones(cell1Case, cell2Case);
        System.out.println(cell1Case);
        System.out.println(cell2Case);
    }
}
