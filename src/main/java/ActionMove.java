/**
 * <h1>ActionMove</h1>
 * <h2>CISC 181-052L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * Extends the Action class and implements the move action.
 * 
 * @author Zach Phillips and Leo Chen
 * @version 1.0
 * @since 2023-04-18
 */

public class ActionMove extends Action {

    public ActionMove(
            Game game, int fromSquareRow, int fromSquareCol,
            int toSquareRow, int toSquareCol) {
        super(game, fromSquareRow, fromSquareCol, toSquareRow, toSquareCol);
    }

    /**
     * This method removes the Unit from the 'from square'
     * Sets the unit on the 'to square'
     * Changes the turn
     */
    public void performAction() {
        // Gets the board
        BoardSquare[][] squares = game.getBoardSquares();
        // Sets the from square and the to square.
        BoardSquare fromSquare = squares[fromSquareRow][fromSquareCol];
        BoardSquare toSquare = squares[toSquareRow][toSquareCol];
        // Gets the unit from the from square and removes it from that square.
        Unit fromUnit = fromSquare.removeUnit();
        // Sets the from square unit to the to square
        toSquare.setUnit(fromUnit);
        // New random square behavior changing team.
        //Gets the units
        Unit opposingUnit = toSquare.getUnit();
        Unit recruitingUnit = fromSquare.getUnit();
        if (toSquare == game.randomSquareAction(game.getGameBoard())) {
            game.getOpponentPlayer().getTeam().removeUnitsFromTeam(opposingUnit);
            game.getCurrentPlayer().getTeam().addUnitsToTeam(opposingUnit);
        }

        game.changeTurn();
    }

    @Override
    public String toString() {
        return game.getCurrentPlayer().getTeam().getTeamColor() + " team's " + game.getBoardSquares()[toSquareRow][toSquareCol]
           .getUnit().getName() + " unit moves from " + fromSquareRow + "," + fromSquareCol + " to " + toSquareRow + "," + toSquareCol;
    }
}
