public class Rules {

    public static boolean checkValidAction(Game game, int actionRowIndex, int actionColIndex, int receiveRowIndex, int receiveColIndex, char action) {
       
        /**
         * The To and From Square indexes should be in bounds of the board
         * There should be a Unit on the From Square
         * The Unit on the From Square should belong to the Team whose turn it is
         * There should not be a Unit on the To Square
         * The path between the To and From Square should be a valid path for moving this Unit (call the Unit’s validMovePath
         */

        // checks in bounds
        if (game.getGameBoard().inBounds(actionRowIndex, actionColIndex) && game.getGameBoard().inBounds(receiveRowIndex, receiveColIndex)) {
            //check to see if unit on from square... helper method?
            if (!unitOnActionSquare(game, actionRowIndex, actionColIndex)){

            }
                //check that unit belongs to team who's turn it is... helper method?
                    //checks to see if there is no unit on to square... helper method?
                        //valid path between squares
        }
        
        
        
        return false;
    }

    /**
     * This function is a helper function to check if there is a unit on the from square
     * @param game Game being checked
     * @param actionRowIndex - Row index of the gameboard
     * @param actionColIndex - Col index of the gameboard
     * @return boolean value of the isEmpty function of the BoardSquares
     */
    private static boolean unitOnActionSquare(Game game, int actionRowIndex, int actionColIndex) {
        BoardSquare[][] squares = game.getBoardSquares();
        BoardSquare squareToCheck;
        squareToCheck = squares[actionRowIndex][actionColIndex];

        return squareToCheck.isEmpty();
    }

    private static boolean unitOnReceiveSquare(Game game, int receiveRowIndex, int receiveColIndex) {
        BoardSquare[][] squares = game.getBoardSquares();
        BoardSquare squareToCheck;
        squareToCheck = squares[receiveRowIndex][receiveColIndex];

        return squareToCheck.isEmpty();
    }





    
}
