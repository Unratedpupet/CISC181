import java.util.Random;

/**
 * <h1>GameBoard</h1>
 * <h2>CISC 181-052L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * Representing a board on which a game
 * will be played
 * @author Zach Phillips
 * @version 1.1
 * @since 2023-02-14
 */
public class GameBoard {

    int numRows;
    int numColumns;
    BoardSquare[][] squares;

    public GameBoard(int numRows, int numColumns) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.squares = new BoardSquare[numRows][numColumns];
        setUpEmptyBoard();
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumColumns() {
        return numColumns;
    }

    public BoardSquare[][] getSquares() {
        return squares;
    }

    public boolean inBounds(int rowIndex, int columnIndex) {
        if ((rowIndex < 0 || columnIndex < 0)){
            return false;
        }
        return rowIndex < this.numRows && columnIndex < this.numColumns;
    }

    private void setUpEmptyBoard() {
        for (int i = 0; i < this.getNumRows(); i++) {
            for (int j = 0; j < this.getNumColumns(); j++) {
                squares[i][j] = (this.getNumRows() % 2 + this.getNumColumns() % 2 == 2)
                        ? new BoardSquare("White")
                        : new BoardSquare("Black");
            }
        }
    }

    public BoardSquare findRandomEmptySpace() {
        int rowCoord = 0, columnCoord = 0;
        do {
            rowCoord = (int)(Math.random() * this.getNumRows());
            columnCoord = (int)(Math.random() * this.getNumColumns());
        }
        while (!squares[rowCoord][columnCoord].isEmpty());
        return squares[rowCoord][columnCoord];
    }

    @Override
    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :       ");

        for(int col = 0; col < squares[0].length; col++){
            boardString.append(col + "        ");
        }
        boardString.append("\n");
        for(int row = 0; row < squares.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < squares[row].length; col++){
                boardString.append(squares[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }
}