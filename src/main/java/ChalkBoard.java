public class ChalkBoard {
   // File to test the GameEventsLinkedList constructors and methods
   public static void main(String[] args) {
      GameEvent GE = new GameEvent(1, "Roguelike", "Roguing");
      GameEvent GE2 = new GameEvent(2, "RPG", "Games to Role Play");
      GameEvent GE3 = new GameEvent(3, "Roguelike", "Roguing and liking");
      GameEvent GE4 = new GameEvent(4, "Battle Royale", "A kind of battle");
      GameEvent GE5 = new GameEvent(5, "Exploration", "Exploring and stuff");

      GameEventNode GEN = new GameEventNode(GE);
      GameEventNode GEN2 = new GameEventNode(GE2);
      GameEventNode GEN3 = new GameEventNode(GE3);
      GameEventNode GEN4 = new GameEventNode(GE4);
      GameEventNode GEN5 = new GameEventNode(GE5);

      GameEventsLinkedList GELL = new GameEventsLinkedList();
      GELL.push(GEN);
      GELL.push(GEN2);
      GELL.push(GEN3);
      GELL.push(GEN4);
      GELL.push(GEN5);

      GELL.display();
      System.out.println(GELL.getSize());
      GameEventsLinkedList GELL2 = GELL.pop("Roguelike");

      GELL2.display();
      System.out.println(GELL2.getSize());
      GameEventsLinkedList GELL3 = GELL2.pop("Roguelike");
      GELL3.display();
      System.out.println(GELL3.getSize());
      /*
      System.out.println('.');;
      GELL2.display();
      System.out.println(GELL2.getSize());
      System.out.println(GELL2.getSize());
      */

   }
}
