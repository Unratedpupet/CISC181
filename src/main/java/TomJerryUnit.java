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

    public TomJerryUnit(char symbol, String name, String teamColor, double health, double healthModifier, double damage, double damageModifier, int luck, int xCor, int yCor, int movement, int movementModifier, boolean homingRocket, boolean offerCheese, boolean hiding) {
        super(symbol, name, teamColor, health, healthModifier, damage, damageModifier, luck, xCor, yCor, movement, movementModifier);
        this.homingRocket = homingRocket;
        this.offerCheese = offerCheese;
        this.hiding = hiding;
    }

    public TomJerryUnit(boolean homingRocket, boolean offerCheese, boolean hiding) {
        super('T', "Tom & Jerry", "red", 100.0, 0.0, 25.0, 0.0, 0, 5, 5, 1, 0);
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
        TomJerryUnit tj = new TomJerryUnit('t', "Tom & Jerry", "Blue", 100.0, 5.0, 25.0, 10.0, 0, 1, 1, 1, 1, true, true, false);
        return tj;
    }

}
