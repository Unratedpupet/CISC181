/**
 * <h1>Action</h1>
 * <h2>CISC 181-052L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * Abstract class the holds the baseline
 * action functions.
 * @author Zach Phillips and Leo Chen
 * @version 1.0
 * @since 2023-04-18
 */

public abstract class Action {

    protected Game game;
    protected int fromSquareRow;
    protected int fromSquareCol;
    protected int toSquareRow;
    protected int toSquareCol;

    // Constructor
    public Action(
            Game game, int fromSquareRow, int fromSquareCol,
            int toSquareRow, int toSquareCol
    ) {
        this.game = game;
        this.fromSquareRow = fromSquareRow;
        this.fromSquareCol = fromSquareCol;
        this.toSquareRow = toSquareRow;
        this.toSquareCol = toSquareCol;
    }

    //Abstract method.
    abstract void performAction();
}
