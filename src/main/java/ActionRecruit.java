public class ActionRecruit extends Action{

    public ActionRecruit(
            Game game, int fromSquareRowIndex, int fromSquareColIndex,
            int toSquareRowIndex, int toSquareColIndex
    ) {
        super(game, fromSquareRowIndex, fromSquareColIndex, toSquareRowIndex, toSquareColIndex);
    }

    public void performAction() {
        // Gets the board
        BoardSquare[][] squares = game.getBoardSquares();
        // Sets the from square and the to square.
        BoardSquare fromSquare = squares[fromSquareRowIndex][fromSquareColIndex];
        BoardSquare toSquare = squares[toSquareRowIndex][toSquareColIndex];
        //Gets the units
        Unit opposingUnit = toSquare.getUnit();
        Unit recruitingUnit = fromSquare.getUnit();
        //Removes unit from the opposite team, and adds it to current team
        opposingUnit.setTeamColor(recruitingUnit.teamColor);


        game.changeTurn();
    }


}
