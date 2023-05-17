/**
 * <h1>ActionRecruit</h1>
 * <h2>CISC 181-052L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * Extends the Action class and implements the Recruit method.
 * @author Zach Phillips and Leo Chen
 * @version 1.0
 * @since 2023-04-18
 */

public class ActionRecruit extends Action{

    public ActionRecruit(
            Game game, int fromSquareRow, int fromSquareCol,
            int toSquareRow, int toSquareCol
    ) {
        super(game, fromSquareRow, fromSquareCol, toSquareRow, toSquareCol);
    }

    /**
     * This method recruits another unit to the team.
     */
    public void performAction() {
        // Gets the board
        BoardSquare[][] squares = game.getBoardSquares();
        // Sets the from square and the to square.
        BoardSquare fromSquare = squares[fromSquareRow][fromSquareCol];
        BoardSquare toSquare = squares[toSquareRow][toSquareCol];
        //Gets the units
        Unit opposingUnit = toSquare.getUnit();
        Unit recruitingUnit = fromSquare.getUnit();
        //Gets the teams

        //Removes unit from the opposite team, and adds it to current team
        game.getOpponentPlayer().getTeam().removeUnitsFromTeam(opposingUnit);
        game.getCurrentPlayer().getTeam().addUnitsToTeam(opposingUnit);

        game.changeTurn();
    }

    @Override
    public String toString() {
        return game.getCurrentPlayer().getTeam().getTeamColor() + " team's " + game.getBoardSquares()[fromSquareRow][fromSquareCol]
           .getUnit().getName() + " unit recruits the unit on " + toSquareRow + "," + toSquareCol + " from " + fromSquareRow + "," + fromSquareCol;
    }
}
