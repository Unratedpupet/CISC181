import java.util.ArrayList;
import java.util.Collections;

/**
 * <h1>Controller</h1>
 * <h2>CISC 181-052L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * The Controller class is the user input gameplay class for the game.
 * 
 * @author Zach Phillips and Leo Chen
 * @version 1.0
 * @since 2023-04-14
 */

public class Controller {

  private Game game;
  private TextView textView;
  private GameEventsLinkedList gell;

  /**
   * This method sets up the game that was supplied by the instructor.
   * 
   * @return - Game - Returns the game to be played.
   */
  public Game setUpGameModel() {
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
    Team teamA = new Team("Blu", piecesTeamA);
    Player playerOne = new Player(1, true, teamA);

    // Create 4 pieces for team B
    // Load the pieces in an ArrayList
    ArrayList<Unit> piecesTeamB = new ArrayList<Unit>();

    BartSimpsonUnit bs2 = new BartSimpsonUnit();
    bs2.setTeamColor("Red");

    TomJerryUnit tj2 = new TomJerryUnit();
    tj2.setTeamColor("Red");

    // Create a team object
    Team teamB = new Team("Red", piecesTeamB);
    Player playerTwo = new Player(2, false, teamB);
    teamB.addUnitsToTeam(bs2);
    teamB.addUnitsToTeam(tj2);

    // Create an instance of the game
    return new Game(8, 8, playerOne, playerTwo);
  }

  public Controller() {
    game = setUpGameModel();
    textView = new TextView();
    gell = new GameEventsLinkedList();
    textView.updateView(game);
  }

  /**
   * This method creates an instance of either ActionMove,
   * ActionAttack, ActionRecruit, or ActionSpawn based on which
   * action type is passed to this method and calls its performAction method.
   * 
   * @param fromSquareRow - int index of from square row
   * @param fromSquareCol - int index of from square column
   * @param toSquareRow   - int index of to square row
   * @param toSquareCol   - int index of to square column
   * @param action        - char representing the action type.
   */
  public void carryOutAction(
      int fromSquareRow, int fromSquareCol, int toSquareRow,
      int toSquareCol, char action) {
    GameEvent ge = null;
    int currentPlayerNum = game.getCurrentPlayer().getPlayerNumber();
    switch (action) {
      case 'M':
        ActionMove am = new ActionMove(game, fromSquareRow, fromSquareCol, toSquareRow, toSquareCol);
        am.performAction();
        ge = new GameEvent(currentPlayerNum, "Move", am.toString());
        break;
      case 'A':
        ActionAttack aa = new ActionAttack(game, fromSquareRow, fromSquareCol, toSquareRow, toSquareCol);
        aa.performAction();
        ge = new GameEvent(currentPlayerNum, "Attack", aa.toString());
        break;
      case 'R':
        ActionRecruit ar = new ActionRecruit(game, fromSquareRow, fromSquareCol, toSquareRow, toSquareCol);
        ar.performAction();
        ge = new GameEvent(currentPlayerNum, "Recruit", ar.toString());
        break;
      case 'S':
        ActionSpawn as = new ActionSpawn(game, fromSquareRow, fromSquareCol, toSquareRow, toSquareCol);
        as.performAction();
        ge = new GameEvent(currentPlayerNum, "Spawn", as.toString());
        break;
    }
    gell.push(new GameEventNode(ge));
    game.decreTurnCountdown();
  }

  public void playGame() {
    // Need a while statement that runs step a and step b until the action is valid
    // per checkValidAction()
    boolean validAction = false;
    while (!validAction) {

      textView.getNextPlayersAction(game);
      validAction = Rules.checkValidAction(
          game, textView.getFromRow(), textView.getFromCol(),
          textView.getToRow(), textView.getToCol(), textView.getAction());
    }

    carryOutAction(
        textView.getFromRow(), textView.getFromCol(),
        textView.getToRow(), textView.getToCol(), textView.getAction());

    System.out.println(game);

    // if not isAWinner(), repeat playGame() **recursion??** or while loop?
    if (!game.isGameEnded()) {
      playGame();
    } else {
      GameEventNode winningMove = gell.pop();
      System.out.println("Final move: " + winningMove.getGameState().getEventDetails());
      gell.push(winningMove);
      if (game.isAWinner()) { textView.printEndOfGame(game); } 
      else { System.out.println("Tied"); }
      ArrayList<GameEventsLinkedList> events = new ArrayList<GameEventsLinkedList>();

      while (!gell.isEmpty()) {
        events.add(gell.pop(gell.getHead().getGameState().getEventType()));
      }

      Collections.sort(events,Collections.reverseOrder());
      for (GameEventsLinkedList event : events) {

        System.out.println(event.getHead().getGameState().getEventType() + " " + event.getSize());
      }
    }
  }

  public static void main(String[] args) {
    Controller gamePlay = new Controller();
    gamePlay.playGame();
  }

}
