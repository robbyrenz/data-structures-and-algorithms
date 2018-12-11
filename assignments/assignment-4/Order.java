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
    /**
     * instantiates an Order instance
     */
    public Order() {
        orderID = "unknown";
        customerID = "unknown";
        amount = 0.00;
    }
    /**
     * instantiates an Order instance
     * @param orderId takes in an id of String type
     * @param customerID takes in an id of String type
     * @param amount takes in a number of double data type
     */
    public Order(String orderId, String customerID, double amount) {
        this.orderID = orderId;
        this.customerID = customerID;
        this.amount = amount;
    }

    // accessor methods
    /**
     * returns the orderID
     * @return orderID of String value
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * returns the customerID
     * @return customerID of String value
     */
    public String getCustomerID() {
        return customerID;
    }

    /**
     * returns the value of the amount
     * @return the amount in double
     */
    public double getAmount() {
        return amount;
    }

    // update methods
    /**
     * sets the orderID
     * @param s the orderID
     */
    public void setOrderID(String s) {
        orderID = s;
    }

    /**
     * sets the customerID
     * @param s the new ID of the customer
     */
    public void setCustomerID(String s) {
        customerID = s;
    }

    /**
     * sets the new price of the order
     * @param d the price of the order
     */
    public void setAmount(double d) {
        amount = d;
    }

    // other methods
    public String toString() {
        return this.orderID + " " + this.customerID + " " + this.amount;
    }
}
