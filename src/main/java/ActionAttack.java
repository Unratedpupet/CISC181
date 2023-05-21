/**
 * <h1>ActionAttack</h1>
 * <h2>CISC 181-052L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * Extends the Action class and implements the Attack method.
 * @author Zach Phillips and Leo Chen
 * @version 1.0
 * @since 2023-04-18
 */

public class ActionAttack extends Action{

    public ActionAttack(
            Game game, int fromSquareRow, int fromSquareCol,
            int toSquareRow, int toSquareCol
    ) {
        super(game, fromSquareRow, fromSquareCol, toSquareRow, toSquareCol);
    }

    // Gets the board
    BoardSquare[][] squares = game.getBoardSquares();
    // Sets the from square and the to square.
    BoardSquare fromSquare = squares[fromSquareRow][fromSquareCol];
    BoardSquare toSquare = squares[toSquareRow][toSquareCol];

    /**
     * This method implements the attack action. Checks to make sure the attacking
     * unit is a TomJerryUnit, if it is, then it will attack the unit in the 'to square'
     * If the defending unit is destroyed, the attacking unit moves to the 'to square'
     */
    public void performAction() {
        double damageAmount;
        //Gets the units and defending team
        Unit attackingUnit = fromSquare.getUnit();
        Unit defendingUnit = toSquare.getUnit();
        Team defendingTeam = game.getOpponentPlayer().getTeam();

        // Changed instance of from BS unit to Attacker to allow for Blademaster to use.
        // New Unit Modifications
        if (attackingUnit instanceof Attacker) {
            damageAmount = ((Attacker) attackingUnit).dealDamage();
            if (defendingUnit instanceof Attacker) {
                ((TomJerryUnit) defendingUnit).takeDamage(damageAmount);
                if (defendingUnit.getHealth() <= 0.0) {
                    //Removes unit from opposing team by removing from the to square.
                    defendingTeam.removeUnitsFromTeam(toSquare.removeUnit());
                }
            }
            //Removes BartSimpsonUnit from team and board.
            else {
                defendingTeam.removeUnitsFromTeam(toSquare.removeUnit());
            }

            //Moves attacking unit to the 'to square'
            if (toSquare.isEmpty()) {
                fromSquare.removeUnit();
                toSquare.setUnit(attackingUnit);
            }
        }

        game.changeTurn();
    }

    @Override
    public String toString() {
        return game.getCurrentPlayer().getTeam().getTeamColor() + " team's " + game.getBoardSquares()[toSquareRow][toSquareCol]
           .getUnit().getName() + " unit attacks " + toSquareRow + "," + toSquareCol + " from " + fromSquareRow + "," + fromSquareCol;
    }
}
