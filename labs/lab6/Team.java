/**
 * @author Robby Renz Abeysinghe
 * Student Number: 3073208
 * Answer 1 of Lab 6
 */

public class Team {
	// private fields
	private String city;
	private String name;
	private int wins;
	private int losses;
	private int otl; // number of overtime/shootout wins
	private int row; // number of regulation overtime wins

	// constructors
	public Team() {
		this.city = "unknown";
		this.name = "unknown";
		this.wins = 0;
		this.losses = 0;
		this.otl = 0;
		this.row = 0;
	}

	public Team(String city, String name, int wins, int losses, int otl, int row) {
		this.city = city;
		this.name = name;
		this.wins = wins;
		this.losses = losses;
		this.otl = otl;
		this.row = row;
	}

	// getters
	public String getCity() {
		return city;
	}

	public String getName() {
		return name;
	}

	public int getWins() {
		return wins;
	}

	public int getLosses() {
		return losses;
	}

	public int getOtl() {
		return otl;
	}

	public int getRow() {
		return row;
	}
	
	// setters
	public void setCity(String s) {
		city = s;
	}

	public void setName(String s) {
		name = s;
	}

	public void setWins(int number) {
		wins = number;
	}

	public void setLosses(int number) {
		losses = number;
	}

	public void setOtl(int number) {
		otl = number;
	}

	public void setRow(int number) {
		row = number;
	}
	
	// other methods
	public String displayFullScore() {
		return city + " " + name + "\t\t\t" + wins + "\t" + losses + "\t" + otl + "\t" + row + "\t" + + this.gamesPlayed() + "\t" + this.points();
	}

	public String toString() {
		return city + " " + name;
	}

	public int gamesPlayed() {
		return wins + losses + otl;
	}

	public int points() {
		return wins * 2 + otl;
	}
}

