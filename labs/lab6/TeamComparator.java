/**
 * @author Robby Renz Abeysinghe
 * Student Number: 3073208
 * Answer 2 of Lab 6
 */

import java.util.Comparator;

public class TeamComparator implements Comparator<Team> {
	public int compare (Team one, Team two) {
		if (one.points() != two.points())
			return one.points() - two.points();
		else if (one.gamesPlayed() == two.gamesPlayed())
			return one.getRow() - two.getRow();
		else
			return one.gamesPlayed() < two.gamesPlayed() ? one.gamesPlayed() : two.gamesPlayed();
	}
}

