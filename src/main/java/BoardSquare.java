
/**
 * <h1>BoardSquare</h1>
 * <h2>CISC 181-052L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * The individual tiles of a Game's Board
 *
 * @author Zach Phillips
 * @version 1.1
 * @since 2023-02-14
 */

public class BoardSquare {

    private boolean empty;
    private Unit unit;
    private String squareColor;

    public BoardSquare(String squareColor) {
        this.empty = true;
        this.unit = null;
        this.squareColor = squareColor;
    }

    public boolean isEmpty() {
        return empty;
    }

    public Unit getUnit() {
        return unit;
    }

    public String getSquareColor() {
        return squareColor;
    }

    public void setUnit(Unit unit) {
        this.empty = false;
        this.unit = unit;
    }
    
    public Unit removeUnit() {
        Unit tempUnit = unit;
        this.unit = null;
        this.empty = true;
        return tempUnit;
    }

    @Override
    public String toString() {
        return isEmpty() ? "-------" : "-" + unit.toString() + "-";
    }

}
