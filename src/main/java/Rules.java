public class Rules {

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
            if (actionSquare.isEmpty()) {
                return false;
            }
            if (!actionSquare.getUnit().getTeamColor().equals(currentTeam)) {
                return false;
            }
            if (actionSquare.getUnit().teamColor.equals(currentTeam)) {
                switch (action) {
                    case 'M':
                        return actionSquare.getUnit().validMovePath(actionRow, actionCol, receiveRow, receiveCol);
                    case 'S':
                        return actionSquare.getUnit().validSpawnPath(actionRow, actionCol, receiveRow, receiveCol);
                    case 'R':
                        if (actionSquare.getUnit() instanceof Recruiter) {
                            if (!targetSquare.isEmpty()) {
                                Recruiter rUnit = (Recruiter)actionSquare.getUnit();
                                return rUnit.validRecruitPath(actionRow, actionCol, receiveRow, receiveCol);
                            }
                        }
                    case 'A':
                        if (actionSquare.getUnit() instanceof Attacker) {
                            if (!targetSquare.isEmpty()) {
                                Attacker aUnit = (Attacker)actionSquare.getUnit();
                                return aUnit.validAttackPath(actionRow, actionCol, receiveRow, receiveCol);
                            }
                        }
                }
            }
            
        }
        return false;
    }
}
