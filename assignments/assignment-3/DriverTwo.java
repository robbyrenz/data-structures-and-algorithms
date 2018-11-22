/**
 * @author Robby Renz Abeysinghe
 * Student Number: 3073208
 * Answer for Part B of Assignment 3
 */

public class DriverTwo {
    public static void main(String[] args) {
        LinkedHeapPriorityQueue<Integer,String> queue = new LinkedHeapPriorityQueue<>();
        queue.insert(8, "John");
        queue.insert(9, "Micheal");
        queue.insert(11, "Jack");
        queue.insert(2, "Rick");
        queue.insert(5, "Charles");
        queue.insert(7, "Summer");
        queue.insert(15, "Jim");
        queue.insert(6, "Samuel");
        queue.insert(13, "Chris");
        // for (Position p : queue.positions());
        //     System.out.println(p);
        System.out.println(queue.returnsLast());
    }
}
