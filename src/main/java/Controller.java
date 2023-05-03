import java.util.ArrayList;

public class Controller {

    private Game game;
    private TextView textView;

    public Game setUpGameModel(){
        // Create 4 pieces for team A
        // Load the pieces in an ArrayList
        ArrayList<Unit> piecesTeamA = new ArrayList<Unit>();


        BartSimpsonUnit bs = new BartSimpsonUnit();
        bs.setTeamColor("Blu");


        TomJerryUnit tj = new TomJerryUnit();
        tj.setTeamColor("Blu");


        piecesTeamA.add(bs);
        piecesTeamA.add(tj);


        // Create a team object
        Team teamA = new Team("Blu",piecesTeamA);
        Player playerOne = new Player(1, true, teamA);


        // Create 4 pieces for team B
        // Load the pieces in an ArrayList
        ArrayList<Unit> piecesTeamB = new ArrayList<Unit>();


        BartSimpsonUnit bs2 = new BartSimpsonUnit();
        bs2.setTeamColor("Red");


        TomJerryUnit tj2 = new TomJerryUnit();
        tj2.setTeamColor("Red");


        piecesTeamB.add(bs2);
        piecesTeamB.add(tj2);


        // Create a team object
        Team teamB = new Team("Red",piecesTeamB);
        Player playerTwo = new Player(2, false, teamB);


        // Create an instance of the game
        return new Game(8, 8, playerOne, playerTwo);
    }

    public Controller() {
        this.game = setUpGameModel();
        this.textView = new TextView();
        textView.updateView();
    }

    /**
     * This method creates an instance of either ActionMove,
     * ActionAttack, ActionRecruit, or ActionSpawn based on which
     * action type is passed to this method and calls its performAction method.
     * @param fromSquareRow - int index of from square row
     * @param fromSquareCol - int index of from square column
     * @param toSquareRow - int index of to square row
     * @param toSquareCol - int index of to square column
     * @param action - char representing the action type.
     */
    public void carryOutAction(
            int fromSquareRow, int fromSquareCol, int toSquareRow,
            int toSquareCol, char action
            ) {
        switch (action) {
            case 'M':
                new ActionMove(game, fromSquareRow, fromSquareCol, toSquareRow, toSquareCol).performAction();
            case 'A':
                new ActionAttack(game, fromSquareRow, fromSquareCol, toSquareRow, toSquareCol).performAction();
            case 'R':
                new ActionRecruit(game, fromSquareRow, fromSquareCol, toSquareRow, toSquareCol).performAction();
            case 'S':
                new ActionSpawn(game, fromSquareRow, fromSquareCol, toSquareRow, toSquareCol).performAction();
        }
    }

    public void playGame() {
        //TODO Implement playGame algorithm
        /**
         * calls getNextPlayersAction
         * calls Rules.checkValidAction  to check if the user’s Action selection is valid
         * if the action isn’t valid repeat Step a) and b) until it is
         * calls carryOutAction
         * prints the game object
         * if the game has not ended repeat Steps a) through d)
         * prints a message that the game has ended and which Player (if any) has won
         */

        // Need a while statement that runs step a and step b until the action is valid per checkValidAction()
        //textView.getNextPlayersAction();
        //Rules.checkValidAction();

        //Once the action is valid, break while loop
        //call carryOutAction()

        System.out.println(game);

        //if not isAWinner(), repeat playGame() **recursion??** or while loop?

        //When game over, game.getWinner()


    }

    public static void main(String[] args) {
        Controller gamePlay = new Controller();
        gamePlay.playGame();
    }

}
