
/**
 * <h1>Recruiter</h1>
 * <h2>CISC 181-052L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * This class defines the abstract Recruiter class that extends the Unit class.
 * @author Zach Phillips and Leo Chen
 * @version 1.0
 * @since 2023-04-18
 */

public abstract class Recruiter extends Unit{


    private int numRecruits;

    // One parameter constructor
    public Recruiter(
                    char symbol, String name, String teamColor, double health, double healthModifier, double damage, 
                    double damageModifier, int luck, int xCor, int yCor, int movement, int movementModifier, int numRecruits
                    ) {
        super(
            symbol, name, teamColor, health, healthModifier, damage, damageModifier, luck, xCor, yCor, movement, movementModifier
        );
        this.numRecruits = numRecruits;
    }

    /**
     * Gets the number of recruits
     * @return - Int - Number of attacks.
     */
    public int getNumRecruits() {return this.numRecruits;}

    /**
     * Sets the number of recuits
     * @param numRecruits - Int - The number of recruits to set to.
     */
    public void setNumRecruits(int numRecruits) {this.numRecruits = numRecruits;}

    /**
     * This method checks to see if there is a valid path to recruit a unit.
     * @param bsRowIndex - board square row index
     * @param bsColIndex - board square column index
     * @param unitRowIndex - unit location row index
     * @param unitColIndex - unit location colum index
     * @return - Boolean value if the path is valid or not.
     */
    //int bsRowIndex, int bsColIndex, int unitRowIndex, int unitColIndex
    abstract boolean validRecruitPath();
}
