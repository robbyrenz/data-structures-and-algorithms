/**
 * @author Robby Renz Abeysinghe
 * Student Number: 3073208
 * Answer 3 of Lab 6
 */

import java.util.ArrayList;

public class Driver {
	public static void main(String[] args) {
		Team jets = new Team("Winnipeg", "Jets", 52, 20, 10, 48);
		Team chicago = new Team("Chicago", "Blackhawks", 33, 39, 10, 32);
		Team dallas = new Team("Dallas", "Stars", 42, 32, 8, 38);
		Team nash = new Team("Nashville", "Predators", 53, 18, 11, 42);
		Team colo = new Team("Colorado", "Avalanche", 46, 27, 9, 40);
		Team min = new Team("Minnesota", "Wild", 45, 26, 11, 41);
		Team blue = new Team("St. Louis", "Blues", 44, 32, 6, 41);

		ArrayList<Team> list = new ArrayList<>();
		list.add(jets);
		list.add(chicago);		
		list.add(dallas);
		list.add(nash);
		list.add(colo);
		list.add(min);
		list.add(blue);

		for (Team t: list)
			System.out.println(t);
	}
}

