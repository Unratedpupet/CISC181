/**
 * <h1>Rules</h1>
 * <h2>CISC 181-052L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * The Rules class checks to see if the action that the Player wants to do is valid.
 * @author Zach Phillips and Leo Chen
 * @version 1.0
 * @since 2023-04-14
 */

public class Rules {

    /**
     * This method checks to see if the Player action is valid and returns a boolean representation
     * @param game - Game object to check
     * @param actionRow - The BoardSquare Row Index that the Player is on.
     * @param actionCol - The BoardSquare Column Index that the Player is on.
     * @param receiveRow - The BoardSquare Row Index that the Player wants to take the action on.
     * @param receiveCol - The BoardSquare Row Column that the Player wants to take the action on.
     * @param action - The action that the Player wants to take based on the set criteria of what actions are available
     * @return - boolean - Returns the boolean value of the result.
     */
    public static boolean checkValidAction(Game game, int actionRow, int actionCol, int receiveRow, int receiveCol, char action) {
       
        /**
         * The To and From Square indexes should be in bounds of the board
         * There should be a Unit on the From Square
         * The Unit on the From Square should belong to the Team whose turn it is
         * There should not be a Unit on the To Square
         * The path between the To and From Square should be a valid path for moving this Unit (call the Unit’s validMovePath
         */

        String currentTeam = game.getCurrentPlayer().getTeam().getTeamColor();
        BoardSquare actionSquare = game.getGameBoard().getSquares()[actionRow][actionCol];
        BoardSquare targetSquare = game.getGameBoard().getSquares()[receiveRow][receiveCol];
        if (game.getGameBoard().inBounds(actionRow, actionCol) && game.getGameBoard().inBounds(receiveRow, receiveCol)){
            if (actionSquare.isEmpty()) { return false; }
            if (!actionSquare.getUnit().getTeamColor().equals(currentTeam)) { return false; }
            if (actionSquare.getUnit().teamColor.equals(currentTeam)) {
                switch (action) {
                    case 'M':
                        if (targetSquare.isEmpty()) {
                            return actionSquare.getUnit().validMovePath(actionRow, actionCol, receiveRow, receiveCol);
                        }
                        break;
                    case 'S':
                        if (targetSquare.isEmpty()) {
                            if (targetSquare.getUnit() instanceof BartSimpsonUnit) {
                                BartSimpsonUnit bUnit = (BartSimpsonUnit) targetSquare.getUnit();
                                if (bUnit.getNumTimesSpawned() < bUnit.getMAX_NUM_SPAWNED()) {
                                    return actionSquare.getUnit().validSpawnPath(actionRow, actionCol, receiveRow, receiveCol); 
                                }
                            }
                            return actionSquare.getUnit().validSpawnPath(actionRow, actionCol, receiveRow, receiveCol);
                        }
                        break;
                    case 'R':
                        if (actionSquare.getUnit() instanceof BartSimpsonUnit) {
                            if (!targetSquare.isEmpty()) {
                                BartSimpsonUnit rUnit = (BartSimpsonUnit)actionSquare.getUnit();
                                return rUnit.validRecruitPath(actionRow, actionCol, receiveRow, receiveCol);
                            }
                        }
                        break;
                    case 'A':
                        if (actionSquare.getUnit() instanceof Attacker) {
                            if (!targetSquare.isEmpty()) {
                                Attacker aUnit = (Attacker)actionSquare.getUnit();
                                return aUnit.validAttackPath(actionRow, actionCol, receiveRow, receiveCol);
                            }
                        }
                        break;
                }
            }
            
        }
        return false;
    }
}
