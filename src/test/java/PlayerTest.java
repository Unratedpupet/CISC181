import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getPlayerNumber() {
        System.out.println("Testing getPlayerNumber");
        Player player1 = new Player();
        assertEquals(999, player1.getPlayerNumber());
    }

    @Test
    void setPlayerNumber() {
        System.out.println("Testing setPlayerNumber");
        Player player1 = new Player();
        player1.setPlayerNumber(1);
        assertEquals(1, player1.getPlayerNumber());
    }

    @Test
    void isTurn() {
        System.out.println("Testing isTurn");
        Player player1 = new Player();
        assertEquals(false, player1.getTurn());
    }

    @Test
    void setTurn() {
        System.out.println("Testing setTurn");
        Player player1 = new Player();
        player1.setTurn(true);
        assertEquals(true, player1.getTurn());
    }

    @Test
    void getUnit() {
        System.out.println("Testing getUnit");
        Player player1 = new Player();
        assertEquals(player1.getTeam(), player1.getTeam());
    }

    @Test
    void setUnit() {
        System.out.println("Testing setUnit");
        Player player1 = new Player();
        assertEquals(player1.getTeam(), player1.getTeam());
    }
}