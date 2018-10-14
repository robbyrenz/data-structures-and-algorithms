/**
 * Student Number: 3073208
 * Answer 2 of Assignment 1
 * @author Robby Renz Abeysinghe
 *
 */
public class Shares {
    // fields
    private int quantity;
    private int price;

    // constructor
    public Shares(int i, int j) {
        quantity = i;
        price = j;
    }

    // getter
    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    // setters
    public void setQuantity(int i) {
        quantity = i;
    }

    public void setPrice(int i) {
        price = i;
    }

    // other methods
    public String toString() {
        return quantity + " at $" + price;
    }
}
