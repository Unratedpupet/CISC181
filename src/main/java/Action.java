public abstract class Action {

    private Game game;
    private int fromSquareRowIndex;
    private int fromSquareColIndex;
    private int toSquareRowIndex;
    private int toSquareColIndex;

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
