/**
 * <h1>ActionSpawn</h1>
 * <h2>CISC 181-052L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * Extends the Action class and implements the Spawn method.
 * @author Zach Phillips and Leo Chen
 * @version 1.0
 * @since 2023-04-18
 */

public class ActionSpawn extends Action{

    public ActionSpawn(
            Game game, int fromSquareRow, int fromSquareCol,
            int toSquareRow, int toSquareCol
    ) {
        super(game, fromSquareRow, fromSquareCol, toSquareRow, toSquareCol);
    }

    /**
     * This method spawns a new unit to the 'to square'
     * Changes the turn
     */
    public void performAction() {
        // Gets the board
        BoardSquare[][] squares = game.getBoardSquares();
        // Sets the from square and the to square.
        BoardSquare fromSquare = squares[fromSquareRow][fromSquareCol];
        BoardSquare toSquare = squares[toSquareRow][toSquareCol];
        // Unit on From square calls spawn method
        Unit spawnedUnit = fromSquare.getUnit().spawn();
        // Add unit that was spawned to the current team.
        game.getCurrentPlayer().getTeam().addUnitsToTeam(spawnedUnit);
        //Put the spawned unit on the To square
        toSquare.setUnit(spawnedUnit);

        game.changeTurn();
    }

    @Override
    public String toString() {
        return game.getCurrentPlayer().getTeam().getTeamColor() + " team's " + game.getBoardSquares()[fromSquareRow][fromSquareCol]
           .getUnit().getName() + " unit spawns on " + toSquareRow + "," + toSquareCol + " from " + fromSquareRow + "," + fromSquareCol;
    }
}