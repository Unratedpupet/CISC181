import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class TextView {
   private int fromRow;
   private int fromCol;
   private int toRow;
   private int toCol;
   private char action;


   public int getFromRow() {
      return this.fromRow;
   }

   public void setFromRow(int fromRow) {
      this.fromRow = fromRow;
   }

   public int getFromCol() {
      return this.fromCol;
   }

   public void setFromCol(int fromCol) {
      this.fromCol = fromCol;
   }

   public int getToRow() {
      return this.toRow;
   }

   public void setToRow(int toRow) {
      this.toRow = toRow;
   }

   public int getToCol() {
      return this.toCol;
   }

   public void setToCol(int toCol) {
      this.toCol = toCol;
   }

   public char getAction() {
      return this.action;
   }

   public void setAction(char action) {
      this.action = action;
   }

   public static char getUsersNextActionType(Scanner scnr) {
      char action = ' ';
      do {
         System.out.println("M, S, R, or A?");
         if (scnr.hasNext()){
            action = scnr.nextLine().charAt(0);
         }
      }
      while (action != 'M' && action != 'S' && action != 'R' && action != 'A');
      return action;
   }

   public static int getValidInt(Scanner scnr) {
      int in = 0, mode = 0;
      do {
         System.out.println("Enter an integer: ");
         if (scnr.hasNextInt()) {
            in = scnr.nextInt();
            mode++;
         }
      }
      while (mode == 0);
      return in;
   }

   public void getNextPlayersAction(Game game) {
      Scanner scnr = new Scanner(System.in);
      action = getUsersNextActionType(scnr);
      System.out.println("Enter your Unit's row:");
      fromRow = getValidInt(scnr);
      while (fromRow > game.getGameBoard().getNumRows() - 1) { fromRow = getValidInt(scnr); }
      System.out.println("Enter your Unit's column");
      fromCol = getValidInt(scnr);
      while (fromCol > game.getGameBoard().getNumColumns() - 1) { fromCol = getValidInt(scnr); }
      System.out.println("Enter your target Unit's row");
      toRow = getValidInt(scnr);
      while (toRow > game.getGameBoard().getNumRows() - 1) { toRow = getValidInt(scnr); }
      System.out.println("Enter your target Unit's Column");
      toCol = getValidInt(scnr);
      while (toCol > game.getGameBoard().getNumColumns() - 1) { toCol = getValidInt(scnr); }
   }

   public void updateView(Game game) { System.out.println(game.toString()); }

   public void printEndOfGame(Game game) { System.out.println("Game over. Winner : " + game.getWinner()); }
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      System.out.println(getUsersNextActionType(scnr));
      //System.out.println(getValidInt(scnr));
   }
}
