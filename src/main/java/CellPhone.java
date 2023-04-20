public class CellPhone {

    private String ownerName;
    private String phoneNumber;
    private String ringtone;
    private boolean doNotDisturb;

    public CellPhone(String ownerName, String phoneNumber) {
        this.ownerName = ownerName;
        this.phoneNumber = phoneNumber;
        this.ringtone = "beep";
        this.doNotDisturb = false;
    }

    public CellPhone() {
        this.ownerName = "John Doe";
        this.phoneNumber = "1234567890";
        this.ringtone = "beep";
        this.doNotDisturb = false;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getRingTone() {
        return ringtone;
    }

    public boolean isDoNotDisturb() {
        return doNotDisturb;
    }

    public void setDoNotDisturb(boolean doNotDisturb) {
        this.doNotDisturb = doNotDisturb;
    }

    public void setRingTone(String ringtone) {
        this.ringtone = ringtone;
    }

    public void incomingCall() {
        //displays value of ringtone if dnd is false
        //otherwise return shhh

        if (!doNotDisturb) {
            System.out.print(ringtone);
        }
        else {
            System.out.print("shhh");
        }

    }

    @Override
    public String toString(){
        return "Phone Owner : " + ownerName + " , Number : " + phoneNumber;
    }

    public static void main(String[] args) {

        CellPhone cell1 = new CellPhone("Sue", "888-999-0000");
        cell1.setRingTone("New Ringtone");
        cell1.incomingCall();

        System.out.println();

        cell1.setDoNotDisturb(true);
        cell1.incomingCall();

        System.out.println();

        System.out.println(cell1);

    }


}
