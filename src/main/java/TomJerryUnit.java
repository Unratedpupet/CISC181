import static java.lang.Math.abs;

/**
 * <h1>TomJerryUnit</h1>
 * <h2>CISC 181-052L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * Practice with classes, constructors, getters and setters
 * with American classic Tom and Jerry
 * @author Zach Phillips
 * @version 1.1
 * @since 2023-02-14
 */


public class TomJerryUnit extends Attacker {


    private boolean homingRocket;
    private boolean offerCheese;
    private boolean hiding;

    public TomJerryUnit(char symbol, String name, String teamColor, double health, double healthModifier, double damage, double damageModifier, int luck, int xCor, int yCor, int movement, int movementModifier, int numAttacks, boolean homingRocket, boolean offerCheese, boolean hiding) {
        super(symbol, name, teamColor, health, healthModifier, damage, damageModifier, luck, xCor, yCor, movement, movementModifier, numAttacks);
        this.homingRocket = homingRocket;
        this.offerCheese = offerCheese;
        this.hiding = hiding;
    }

    public TomJerryUnit(boolean homingRocket, boolean offerCheese, boolean hiding) {
        super('T', "Tom & Jerry", "Red", 100.0, 0.0, 25.0, 0.0, 0, 5, 5, 1, 0, 0);
        this.homingRocket = homingRocket;
        this.offerCheese = offerCheese;
        this.hiding = hiding;
    }

    public TomJerryUnit() {
        this(true, true, false);
    }

    public boolean canHomingRocket() {
        return homingRocket;
    }

    public void setHomingRocket(boolean homingRocket) {
        this.homingRocket = homingRocket;
    }

    public boolean canOfferCheese() {
        return offerCheese;
    }

    public void setOfferCheese(boolean offerCheese) {
        this.offerCheese = offerCheese;
    }

    public boolean isHiding() {
        return hiding;
    }

    public void setHiding(boolean hiding) {
        this.hiding = hiding;
    }

     /**
     * This method has no parameters and returns a double.
     * It should add damage and damageModifier together to produce a totalDamage value. Additionally, a check should be
     * implemented to see if canHomingRocket is true. If so, add 10 more damage.
     *
     * @return - returns a double of the total amount of damage dealt.
     */
    public double dealDamage() {
        double totalDamage = this.damage + this.damageModifier;

        if (canHomingRocket()) {
            totalDamage += 10;
        }

        return totalDamage;
    }

    /**
     * The method updates health by subtracting the damage. Additionally, a check should be implemented to see if
     * isHiding is true. If so, no damage is subtracted.
     * @param damageTaken - Inputs a double of the total damage taken.
     */
    public void takeDamage(double damageTaken) {
        if (!isHiding()) {
            this.health -= damageTaken;
        }
    }

    @Override
    public TomJerryUnit spawn() {
        TomJerryUnit tj = new TomJerryUnit('t', "Tom & Jerry", "Blu", 100.0, 5.0, 25.0, 10.0, 0, 1, 1, 1, 1, 0, true, true, false);
        return tj;
    }

    public boolean canSpawn() {
        return true;
    }

    /**
     * This method checks to see if the spawn path is valid.
     * @param fromRowIndex - Unit move start row index
     * @param fromColIndex - Unit move start col index
     * @param toRowIndex - Unit move end row index
     * @param toColIndex - Unit move end col index
     * @return - boolean - Allowed to spawn anywhere, so always returns true.
     */
    public boolean validSpawnPath(int fromRowIndex, int fromColIndex, int toRowIndex, int toColIndex) {
        return true;
    }

    /**
     * This method checks to see if the move path is valid.
     * @param fromRowIndex - Unit move start row index
     * @param fromColIndex - Unit move start col index
     * @param toRowIndex - Unit move end row index
     * @param toColIndex - Unit move end col index
     * @return - boolean - Allowed to move anywhere, so always returns true.
     */
    public boolean validMovePath(int fromRowIndex, int fromColIndex, int toRowIndex, int toColIndex) {
        return true;
    }

    public boolean validAttackPath(int fromRowIndex, int fromColIndex, int toRowIndex, int toColIndex) {

        //Across the row, but not up and down a column.
        if (fromRowIndex == toRowIndex && fromColIndex != toColIndex) {
            return true;
        }
        // Two spaces up or down the column, but no spaces across the row.
        else if (fromColIndex == toColIndex && (fromRowIndex - toRowIndex == abs(2))) {
            return true;
        }

        else {
            return false;
        }
    }
}
