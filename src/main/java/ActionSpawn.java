public class ActionSpawn extends Action{

    public ActionSpawn(
            Game game, int fromSquareRowIndex, int fromSquareColIndex,
            int toSquareRowIndex, int toSquareColIndex
    ) {
        super(game, fromSquareRowIndex, fromSquareColIndex, toSquareRowIndex, toSquareColIndex);
    }

    /**
     * This method spawns a new unit to the 'to square'
     * Changes the turn
     */
    public void performAction() {
        // Gets the board
        BoardSquare[][] squares = game.getBoardSquares();
        // Sets the from square and the to square.
        BoardSquare fromSquare = squares[fromSquareRowIndex][fromSquareColIndex];
        BoardSquare toSquare = squares[toSquareRowIndex][toSquareColIndex];
        // Unit on From square calls spawn method
        Unit spawnedUnit = fromSquare.getUnit().spawn();
        // Add unit that was spawned to the current team.
        game.getCurrentPlayer().getTeam().addUnitsToTeam(spawnedUnit);
        //Put the spawned unit on the To square
        toSquare.setUnit(spawnedUnit);

        game.changeTurn();
    }

}
