/**
 * @author Robby Renz Abeysinghe
 * Student Number: 3073208
 * Part A of Assignment 2
 */

public class Peg {
    
    // fields
    private String color;
    private boolean match;

    // constructor
    public Peg(String color) {
        this.color = color;
        this.match = false;
    }

    // getters
    /**
     * Gets the color of the peg
     * @return the color of the peg
     */
    public String getColor() {
        return color;
    }

    /**
     * Checks to see if the peg matches with the user's guess
     * @return true if it matches the user's guess, false otherwise
     */
    public boolean isMatch() {
        return match;
    }

    // setters

    // other methods

    /**
     * retrieves the color of the peg
     * @return color of the peg instance
     */
    public String toString() {
        return this.color;
    }

    /**
     * Checks to see if the peg matches with the contents of an ArrayList
     * @param list
     * @return if the peg matches with the contents of an ArrayList
     */
    public boolean equals(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != this.getColor())
                return false;
        }
        return true;
    }
}
