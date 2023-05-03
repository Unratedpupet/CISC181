/**
 * <h1>Action</h1>
 * <h2>CISC 181-052L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * Abstract class the holds the baseline
 * action functions.
 * @author Zach Phillips and Leo Chan
 * @version 1.0
 * @since 2023-04-18
 */

public abstract class Action {

    protected Game game;
    protected int fromSquareRowIndex;
    protected int fromSquareColIndex;
    protected int toSquareRowIndex;
    protected int toSquareColIndex;

    // Constructor
    public Action(
            Game game, int fromSquareRowIndex, int fromSquareColIndex,
            int toSquareRowIndex, int toSquareColIndex
    ) {
        this.game = game;
        this.fromSquareRowIndex = fromSquareRowIndex;
        this.fromSquareColIndex = fromSquareColIndex;
        this.toSquareRowIndex = toSquareRowIndex;
        this.toSquareColIndex = toSquareColIndex;
    }

    //Abstract method.
    abstract void performAction();
}
