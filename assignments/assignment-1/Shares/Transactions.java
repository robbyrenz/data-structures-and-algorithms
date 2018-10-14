/**
 * Class that would help in the transactions of the shares in the queue
 * Student Number: 3073208
 * Answer 2 of Assignment 1
 * @author Robby Renz Abeysinghe
 */

public class Transactions {
    // fields
    private LinkedQueue<Shares> foo;

    // constructor
    public Transactions(LinkedQueue<Shares> s) {
        foo = s;
    }

    // ---------------just a couple of methods-----------------------

    // method to associate the LinkedQueue to this class
    public void theLink(LinkedQueue<Shares> s) {
        foo = s;
    }

    // method to get the total value of the shares
    public int getTotalValue() {
        LinkedQueue<Shares> temp = new LinkedQueue<>();
        int totalValue = 0;
        int sizeOfQueue = foo.size();
        for (int i = 0; i < sizeOfQueue; i++) {
            totalValue += foo.first().getPrice() * foo.first().getQuantity();
            temp.enqueue(foo.dequeue());
        }
        for (int i = 0; i < sizeOfQueue; i++) {
            foo.enqueue(temp.dequeue());
        }
        return totalValue;
    }

    // method to get the total number of the shares bought
    public int getTotalShares() {
        LinkedQueue<Shares> temp = new LinkedQueue<>();
        int totalShares = 0;
        int sizeOfQueue = foo.size();
        for (int i = 0; i < sizeOfQueue; i++) {
            totalShares += foo.first().getQuantity();
            temp.enqueue(foo.dequeue());
        }
        for (int i = 0; i < sizeOfQueue; i++) {
            foo.enqueue(temp.dequeue());
        }
        return totalShares;
    }

    // method to accommodate the selling of shares
    public int sellShares(int sharesToSell, int sellingPricePerShare, LinkedQueue<Shares> list) {
        LinkedQueue<Shares> temp = new LinkedQueue<>();
        int totalSellingPrice = sharesToSell * sellingPricePerShare;
        int totalPurchasePrice = 0;
        System.out.println(list.first().getQuantity());
        while (sharesToSell != 0) {
            if (sharesToSell > list.first().getQuantity()) {
                totalPurchasePrice += list.first().getPrice() * list.first().getQuantity();
                sharesToSell -= list.first().getQuantity();
                list.dequeue();
            }
            else if (sharesToSell < list.first().getQuantity()) {
                list.first().setQuantity(list.first().getQuantity() - sharesToSell);
                totalPurchasePrice += list.first().getQuantity() * list.first().getPrice();
                sharesToSell = 0;
            }
        }
        int capitalGain = totalSellingPrice - totalPurchasePrice;
        return capitalGain;
    }
}

