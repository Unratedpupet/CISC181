import java.util.ArrayList;

/**
 * <h1>Player</h1>
 * <h2>CISC 181-052L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * The Player and the various related methods
 * @author Zach Phillips
 * @version 1.1
 * @since 2023-02-14
 */

public class Player {
    private int playerNumber;
    private boolean isTurn;
    private Team team;

    public Player (int playerNumber, boolean isTurn, Team unit) {
        this.playerNumber = playerNumber;
        this.isTurn = isTurn;
        this.team = unit;
    }

    public Player (int playerNumber, Team team) {
        this(playerNumber, false, team);
    }

    public Player () {
        this(1, false, new Team("", new ArrayList<Unit>()));
    }

    public int getPlayerNumber() {
        return this.playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public boolean getTurn() {
        return isTurn;
    }

    public void setTurn(boolean turn) {
        this.isTurn = turn;
    }

    public Team getTeam() {
        return this.team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }


}
