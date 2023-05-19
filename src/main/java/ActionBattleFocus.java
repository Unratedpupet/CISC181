// New Action Modification


/**
 * <h1>ActionBattleFocus</h1>
 * <h2>CISC 181-052L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * Extends the Action class and implements the BattleFocus method.
 * @author Zach Phillips and Leo Chen
 * @version 1.0
 * @since 2023-04-18
 */

public class ActionBattleFocus extends Action{

    public ActionBattleFocus(
            Game game, int fromSquareRow, int fromSquareCol,
            int toSquareRow, int toSquareCol
    ) {
        super(game, fromSquareRow, fromSquareCol, toSquareRow, toSquareCol);
    }

    public void performAction() {
        // Gets the board
        BoardSquare[][] squares = game.getBoardSquares();
        // Sets the from square and the to square.
        BoardSquare fromSquare = squares[fromSquareRow][fromSquareCol];
        BoardSquare toSquare = squares[toSquareRow][toSquareCol];

        //Gets the units from the attacking team
        Unit focusingUnit = fromSquare.getUnit();
        Unit focusedUnit = toSquare.getUnit();

        // Changes the damageModifier to a random number between 1 and 40.
        focusedUnit.setDamageModifier(1 + (Math.random() * 39));
    }
}
