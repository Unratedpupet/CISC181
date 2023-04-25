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
