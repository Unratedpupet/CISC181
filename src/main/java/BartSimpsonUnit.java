import static java.lang.Math.abs;

/**
 * <h1>TomJerryUnit</h1>
 * <h2>CISC 181-052L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * Practice with classes, constructors, getters and setters
 * with American classic The Simpsons
 * @author Zach Phillips
 * @version 1.2
 * @since 2023-02-14
 */

public class BartSimpsonUnit extends Recruiter {

    private int numTimesSpawned;
    private boolean distract;
    private boolean recruit;
    final int MAX_NUM_SPAWNED = 2;


    public BartSimpsonUnit(char symbol, String name, String teamColor, double health, double healthModifier, double damage, double damageModifier, int luck, int xCor, int yCor, int movement, int movementModifier, int numRecruits, int numTimesSpawned, boolean distract, boolean recruit) {
        super(symbol, name, teamColor, health, healthModifier, damage, damageModifier, luck, xCor, yCor, movement, movementModifier, numRecruits);
        this.numTimesSpawned = numTimesSpawned;
        this.distract = distract;
        this.recruit = recruit;
    }

    public BartSimpsonUnit(int numTimesSpawned, boolean distract, boolean recruit) {
        super('B', "Bart Simpson", "Red", 100.0, 0.0, 25.0, 0.0, 0, 5, 5, 1, 0, 0);
        this.numTimesSpawned = numTimesSpawned;
        this.distract = distract;
        this.recruit = recruit;
    }

    public BartSimpsonUnit() {this(0, true, true);}


    public int getNumTimesSpawned() {
        return numTimesSpawned;
    }

    public void setNumTimesSpawned(int numTimesSpawned) {
        this.numTimesSpawned = numTimesSpawned;
    }

    public boolean canDistract() {
        return distract;
    }

    public void setDistract(boolean distract) {
        this.distract = distract;
    }

    public boolean canRecruit() {
        return recruit;
    }

    public void setRecruit(boolean recruit) {
        this.recruit = recruit;
    }

    public int getMAX_NUM_SPAWNED() {
        return MAX_NUM_SPAWNED;
    }

    public void takeDamage(double damage) {this.health -= damage; }

    /**
     * Checks to see if the unit can be distracted, and prints out that it is distracted.
     */
    public void distracted() {
        if (this.canDistract()) {
            System.out.println("Unit Distracted");
        }
    }

    /**
     * canSpawn – this method has no parameters and will return true or false
     * based on whether the piece can make a copy of itself
     * only original pieces can make copies
     * pieces can only spawn if it hasn’t reached max number of times it  can spawn
     *
     */
    public boolean canSpawn() {
        if (this.symbol == 'B') {
            if (numTimesSpawned < MAX_NUM_SPAWNED) {
                return true;
            }
        }
        return false;
    }


    /**
     * Spawns a new Bart Simpson after checking to see if it is spawnable.
     * @return A new Bart Simpson Unit.
     */
    public BartSimpsonUnit spawn() {
        if (this.canSpawn()) {
            numTimesSpawned++;
            return new BartSimpsonUnit('b', "Bart Simpson", "Blue", 100.0, 5.0, 25.0, 10.0, 0, 1, 1, 1, 1, 0, 0,true, true);
        }

        return null;
    }



    public boolean validSpawnPath(int fromRowIndex, int fromColIndex, int toRowIndex, int toColIndex) {

        //Up and down the column, but no movement across the row.
        if (fromColIndex == toColIndex && fromRowIndex != toRowIndex) {
            return true;
        }
        //Only two spaces across the row, no movement up or down column.
        else if ((abs(fromColIndex - toColIndex) <= 2) && fromRowIndex == toRowIndex) {
            return true;
        }
        return false;
    }

    public boolean validMovePath(int fromRowIndex, int fromColIndex, int toRowIndex, int toColIndex) {

        //Up and down the column, but no movement across the row.
        if (fromColIndex == toColIndex && fromRowIndex != toRowIndex) {
            return true;
        }
        //Only two spaces across the row, no movement up or down column.
        else if ((abs(fromColIndex - toColIndex) <= 2) && fromRowIndex == toRowIndex) {
            return true;
        }
        return false;
    }

    public boolean validRecruitPath(int fromRowIndex, int fromColIndex, int toRowIndex, int toColIndex) {

        //Up and down the column, but no movement across the row.
        if (fromColIndex == toColIndex && fromRowIndex != toRowIndex) {
            return true;
        }
        //Only two spaces across the row, no movement up or down column.
        else if ((abs(fromColIndex - toColIndex) <= 2) && fromRowIndex == toRowIndex) {
            return true;
        }
        return false;
    }
}
