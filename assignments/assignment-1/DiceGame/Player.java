/**
 * A simple model of a typical player in a dice game.
 * Student Number: 3073208
 * Answer 1 of Assignment 1
 * @author Robby Renz Abeysinghe
 */

public class Player {
    // fields
    private String name;
    private int score;
    private boolean isEliminated;
    private static int numberOfPlayers = 0;

    // constructor

    /**
     * Constructs a new player instance
     * @param name of the designated player
     */
    public Player(String name) {
        this.name = name;
        score = 0;
        isEliminated = false;
        incrementNumberOfPlayers();
    }

    /**
     * Increments the static (class-level) variable "numberOfPlayers" to state how many players have been created
     */
    private void incrementNumberOfPlayers() {
        numberOfPlayers++;
    }

    // getters
    /**
     * Gets the name of the player
     * @return name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the score of the player
     * @return score is returned
     */
    public int getScore() {
        return score;
    }

    /**
     * Returns true or false if the player is eliminated
     * @return true of false of the variable "isEliminated"
     */
    public boolean getEliminated() {
        return isEliminated;
    }

    /**
     * Gets the number of player instantiated
     * @return the variable "numberOfPlayers"
     */
    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    // setters
    /**
     * Sets the score of the player
     * @param num num will be the new score
     */
    public void setScore(int num) {
        score = num;
    }

    /**
     * Sets the elimination state of the player
     */
    public void setEliminated() {
        isEliminated = true;
    }

    // methods required to update the score
    /**
     * Updates the player's score
     * @param num adds the variable "num" to the players score
     */
    public void updateScore(int num) {
        score += num;
    }

    // other methods
    /**
     * Gets a custom string representation of the player
     * @return the player's name and his/her/it's score
     */
    public String toString() {
        return "Player's name: " + name + "\nScore: " + score + "\n";
    }
}
