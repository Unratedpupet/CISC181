public class ActionMove extends Action{

    public ActionMove(
            Game game, int fromSquareRowIndex, int fromSquareColIndex,
            int toSquareRowIndex, int toSquareColIndex
    ) {
        super(game, fromSquareRowIndex, fromSquareColIndex, toSquareRowIndex, toSquareColIndex);
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
        BoardSquare fromSquare = squares[fromSquareRowIndex][fromSquareColIndex];
        BoardSquare toSquare = squares[toSquareRowIndex][toSquareColIndex];
        // Gets the unit from the from square and removes it from that square.
        Unit fromUnit = fromSquare.removeUnit();
        //Sets the from square unit to the to square
        toSquare.setUnit(fromUnit);

        game.changeTurn();
    }

}
