
import java.util.Collections;

/**
 * <h1>Game</h1>
 * <h2>CISC 181-052L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * The Game and the initializing of it
 * @author Zach Phillips
 * @version 1.1
 * @since 2023-02-14
 */

public class Game {

    private GameBoard board;
    private Player playerOne;
    private Player playerTwo;

    private GameBoard initializeGameBoard(int numRows, int numColumns) {
        GameBoard GB = new GameBoard(numRows, numColumns);
        placeUnits(GB, this.playerOne);
        placeUnits(GB, this.playerOne);
        return GB;
    }

    public static GameBoard placeUnits(GameBoard board, Player player) {
        for (int i = 0; i < player.getTeam().getTeamUnits().size(); i++) {
            board.findRandomEmptySpace().setUnit(player.getTeam().getTeamUnits().get(i));
        }
        return board;
    }

    public Game(int numRows, int numColumns, Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.board = initializeGameBoard(numRows, numColumns);
    }

    public GameBoard getGameBoard() {
        return board;
    }

    public void setBoard(GameBoard board) {
        this.board = board;
    }

    public Player getCurrentPlayer() { return playerOne.getTurn() ? playerOne : playerTwo; }
    public Player getOpponentPlayer() { return playerOne.getTurn() ? playerTwo : playerOne; }
    public boolean isTurn(Player player) { return player.getTurn(); }
    public BoardSquare[][] getBoardSquares() { return board.getSquares(); }

    /**
     * Changes the players turn
     */
    public void changeTurn() {
        
        playerOne.setTurn(!playerOne.getTurn());
        playerTwo.setTurn(!playerTwo.getTurn());
    }


    /**
     * Overrides the toString method
     * @return A string representing the Game.
     */
    public String toString(){
        StringBuilder retString = new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getGameBoard().toString())
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getCurrentPlayer().getTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getOpponentPlayer().getTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\nIt is Player " + getCurrentPlayer().getPlayerNumber() + "'s (" + getCurrentPlayer().getTeam().getTeamColor() + "'s) turn\n");
        return retString.toString();
    }

    /**
     * Checks to see if there is a winner by checking if there is a team that has
     * zero units on the team.
     * @return - Boolean value if there is a winner.
     */
    public boolean isAWinner() {
        if (playerOne.getTeam().getTeamUnits().size() <= 0) {
            return true;
        }
        else return playerTwo.getTeam().getTeamUnits().size() <= 0;
    }

    /**
     * This method checks to see if there is a winner, and which team is the winner.
     * @return - The Player that is the winner.
     */
    public Player getWinner() {
        if (isAWinner()) {
            if (
                    playerOne.getTeam().getTeamUnits().size() > playerTwo.getTeam().getTeamUnits().size()
            ) {
                System.out.println("Player One Wins");
                return playerOne;
            }
            System.out.println("Player Two Wins!");
            return playerTwo;
        }
        return null;
    }

    /**
     * This method checks to see if either team has zero units, and if there are, it returns the boolean
     * @return - boolean value of if either team has zero units.
     */
    public boolean isGameEnded() {
        return playerOne.getTeam().getTeamUnits().size() <= 0 || playerTwo.getTeam().getTeamUnits().size() <= 0;
    }
}
