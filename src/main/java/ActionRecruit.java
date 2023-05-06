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
            Game game, int fromSquareRowIndex, int fromSquareColIndex,
            int toSquareRowIndex, int toSquareColIndex
    ) {
        super(game, fromSquareRowIndex, fromSquareColIndex, toSquareRowIndex, toSquareColIndex);
    }

    /**
     * This method recruits another unit to the team.
     */
    public void performAction() {
        // Gets the board
        BoardSquare[][] squares = game.getBoardSquares();
        // Sets the from square and the to square.
        BoardSquare fromSquare = squares[fromSquareRowIndex][fromSquareColIndex];
        BoardSquare toSquare = squares[toSquareRowIndex][toSquareColIndex];
        //Gets the units
        Unit opposingUnit = toSquare.getUnit();
        Unit recruitingUnit = fromSquare.getUnit();
        //Gets the teams

        //Removes unit from the opposite team, and adds it to current team
        game.getOpponentPlayer().getTeam().removeUnitsFromTeam(opposingUnit);
        game.getCurrentPlayer().getTeam().addUnitsToTeam(opposingUnit);

        game.changeTurn();
    }


}
