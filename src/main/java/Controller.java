import java.util.ArrayList;

/**
 * <h1>Controller</h1>
 * <h2>CISC 181-052L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * The Controller class is the user input gameplay class for the game.
 * @author Zach Phillips and Leo Chen
 * @version 1.0
 * @since 2023-04-14
 */

public class Controller {

    private Game game;
    private TextView textView;

    /**
     * This method sets up the game that was supplied by the instructor.
     * @return - Game - Returns the game to be played.
     */
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

        // Create a team object
        Team teamB = new Team("Red",piecesTeamB);
        Player playerTwo = new Player(2, false, teamB);
        teamB.addUnitsToTeam(bs2);
        teamB.addUnitsToTeam(tj2);

        // Create an instance of the game
        return new Game(8, 8, playerOne, playerTwo);
    }

    public Controller() {
        this.game = setUpGameModel();
        this.textView = new TextView();
        textView.updateView(game);
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
                break;
            case 'A':
                new ActionAttack(game, fromSquareRow, fromSquareCol, toSquareRow, toSquareCol).performAction();
                break;
            case 'R':
                new ActionRecruit(game, fromSquareRow, fromSquareCol, toSquareRow, toSquareCol).performAction();
                break;
            case 'S':
                new ActionSpawn(game, fromSquareRow, fromSquareCol, toSquareRow, toSquareCol).performAction();
                break;
        }
    }

    public void playGame() {
        // Need a while statement that runs step a and step b until the action is valid per checkValidAction()
        while (!Rules.checkValidAction(
                game, textView.getFromRow(), textView.getFromCol(),
                textView.getToRow(), textView.getToCol(), textView.getAction())
        ) {

            textView.getNextPlayersAction(game);
            Rules.checkValidAction(
                    game, textView.getFromRow(), textView.getFromCol(),
                    textView.getToRow(), textView.getToCol(), textView.getAction()
            );
        }

        carryOutAction(
                textView.getFromRow(), textView.getFromCol(),
                textView.getToRow(), textView.getToCol(), textView.getAction()
        );


        System.out.println(game);

        //if not isAWinner(), repeat playGame() **recursion??** or while loop?
        if (!game.isAWinner()) {
            playGame();
        }
        else {
            textView.printEndOfGame(game);

        }

    }

    public static void main(String[] args) {
        Controller gamePlay = new Controller();
        gamePlay.playGame();
    }

}
