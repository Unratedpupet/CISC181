// New Unit Modifications

import static java.lang.Math.abs;

public class Blademaster extends Attacker{

    // Battlefocus is going to increase the attack modifier.
    private boolean battleFocus;

    public Blademaster(char symbol, String name, String teamColor, double health, double healthModifier, double damage, double damageModifier, int luck, int xCor, int yCor, int movement, int movementModifier, int numAttacks, boolean homingRocket, boolean offerCheese, boolean hiding) {
        super(symbol, name, teamColor, health, healthModifier, damage, damageModifier, luck, xCor, yCor, movement, movementModifier, numAttacks);
        this.battleFocus = battleFocus;
    }

    public Blademaster(boolean battleFocus) {
        super('M', "Battlemaster", "Red", 100.0, 0.0, 25.0, 0.0, 0, 5, 5, 1, 0, 0);
        this.battleFocus = battleFocus;
    }

    public Blademaster() {
        this(false);
    }

    public boolean isBattleFocus(){ return battleFocus; }
    public void setBattleFocus(boolean battleFocus) { this.battleFocus = battleFocus; }

    public void takeDamage(double damageTaken) {
        this.health -= damageTaken;
    }

    @Override
    public Blademaster spawn() {
        Blademaster bm = new Blademaster('m', "Blademaster", "Blu", 100.0, 5.0, 25.0, 10.0, 0, 1, 1, 1, 1, 0, true, true, false);
        return bm;
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

    public double dealDamage() {
        double totalDamage = this.damage + this.damageModifier;

        if (battleFocus) {
            this.damageModifier = 10.0;
        }

        return totalDamage;
    }

}
