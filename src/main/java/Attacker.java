
/**
 * <h1>Attacker</h1>
 * <h2>CISC 181-052L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * This class defines the abstract Attacker unit that extends the Unit class.
 * @author Zach Phillips and Leo Chen
 * @version 1.0
 * @since 2023-04-18
 */

public abstract class Attacker extends Unit {

    private int numAttacks;

    // One parameter constructor
    public Attacker(
                char symbol, String name, String teamColor, double health, double healthModifier, double damage, 
                double damageModifier, int luck, int xCor, int yCor, int movement, int movementModifier, int numAttacks
            ) {
        super(
           symbol, name, teamColor, health, healthModifier, damage, damageModifier, luck, xCor, yCor, movement, movementModifier 
        );
        this.numAttacks = numAttacks;
    }

    /**
     * Gets numAttacks
     * @return - Int - Number of attacks.
     */
    public int getNumAttacks() {return this.numAttacks;}

    /**
     * Sets the number of attacks
     * @param numAttacks - Int - Number of attacks.
     */
    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
    }


    /**
     * This method checks to see if there is a valid path to attack a unit.
     * @param bsRowIndex - board square row index
     * @param bsColIndex - board square column index
     * @param unitRowIndex - unit location row index
     * @param unitColIndex - unit location colum index
     * @return - Boolean value if the path is valid or not.
     */


    abstract boolean validAttackPath(int bsRowIndex, int bsColIndex, int unitRowIndex, int unitColIndex);

    // New Unit Modifications
    abstract double dealDamage();

}
