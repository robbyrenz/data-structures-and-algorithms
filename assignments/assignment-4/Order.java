/**
 * @author Robby Renz Abeysinghe
 * Student Number: 3073208
 * Answer of Part B of Assignment 4
 */

public class Order {
    // private variables
    private String orderID;
    private String customerID;
    private double amount;

    // constructors
    public Order() {
        orderID = "unknown";
        customerID = "unknown";
        amount = 0.00;
    }

    public Order(String orderId, String customerID, double amount) {
        this.orderID = orderId;
        this.customerID = customerID;
        this.amount = amount;
    }

    // accessor methods
    public String getOrderID() {
        return orderID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public double getAmount() {
        return amount;
    }

    // update methods
    public void setOrderID(String s) {
        orderID = s;
    }

    public void setCustomerID(String s) {
        customerID = s;
    }

    public void setAmount(double d) {
        amount = d;
    }

    // other methods
    public String toString() {
        return this.orderID + " " + this.customerID + " " + this.amount;
    }
}
