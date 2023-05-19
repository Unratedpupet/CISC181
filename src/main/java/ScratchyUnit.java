// New Unit Modifications

import static java.lang.Math.abs;

/**
 * <h1>ScratchyUnit</h1>
 * <h2>CISC 181-052L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * Practice with classes, constructors, getters and setters
 * with American classic The Simpsons
 *
 * @author Zach Phillips and Leo Chen
 * @version 1.2
 * @since 2023-02-14
 */

public class ScratchyUnit extends BartSimpsonUnit{

    public ScratchyUnit(
            char symbol, String name, String teamColor, double health, double healthModifier,
            double damage, double damageModifier, int luck, int xCor, int yCor, int movement,
            int movementModifier, int numRecruits, int numTimesSpawned, boolean distract, boolean recruit) {
        super(
                symbol, name, teamColor, health, healthModifier, damage, damageModifier,
                luck, xCor, yCor, movement, movementModifier, numRecruits, numTimesSpawned, distract, recruit);
    }

    public ScratchyUnit(int numTimesSpawned, boolean distract, boolean recruit) {
        super(numTimesSpawned, distract, recruit);
    }

    public ScratchyUnit() {
    }

    public void takeDamage(double damage) {
        this.health -= damage;
    }

    // Can move anywhere, but can only spawn or recruit from an adjacent square.
    public boolean validSpawnPath(int fromRowIndex, int fromColIndex, int toRowIndex, int toColIndex) {

        return (abs(fromColIndex - toColIndex) <= 1) && abs(fromRowIndex - toRowIndex) <= 1;
    }

    public boolean validMovePath(int fromRowIndex, int fromColIndex, int toRowIndex, int toColIndex) { return true; }

    public boolean validRecruitPath(int fromRowIndex, int fromColIndex, int toRowIndex, int toColIndex) {

        return (abs(fromColIndex - toColIndex) <= 1) && abs(fromRowIndex - toRowIndex) <= 1;
    }



}
