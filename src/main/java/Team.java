
import java.util.ArrayList;

/**
 * <h1>Team</h1>
 * <h2>CISC 181-052L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * The Team of a Player instance
 * @author Zach Phillips
 * @version 1.1
 * @since 2023-02-14
 */

public class Team {

    String teamColor;
    ArrayList<Unit> units;

    public Team(String teamColor, ArrayList<Unit> units) {
        this.teamColor = teamColor;
        this.units = units;
    }

    public String getTeamColor() {
        return this.teamColor;
    }

    public ArrayList<Unit> getTeamUnits() {
        return units;
    }

    /**
     * Removes the specified unit from the team.
     * @param unit - the unit to be removed.
     */
    public void removeUnitsFromTeam(Unit unit) {
        for (int i = 0; i < units.size(); i++) {
            if (units.get(i).equals(unit)) {
                units.remove(i);
                break;
            }
        }
    }

    /**
     * Adds a unit to the team.
     * @param unit - The unit to be added.
     */
    public void addUnitsToTeam(Unit unit) {
        unit.setTeamColor(teamColor);
        units.add(unit);
    }

    public String toString() {
        String returnString = "Team " + teamColor + " Units : \n";
        for (int i = 0; i < units.size(); i++) {
            returnString += units;
        }
        return returnString;
    }

}
