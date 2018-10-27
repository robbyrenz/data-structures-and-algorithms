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
    public String getColor() {
        return color;
    }
    public boolean isEmpty() {
        return match;
    }

    // setters
    

    // other methods
    public String toString() {
        return this.color;
    }
}