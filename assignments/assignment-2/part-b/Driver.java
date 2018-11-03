/**
 * Name: Robby Renz Abeysinghe
 * Student Number: 3073208
 * Answer 2 of Assignment 2
 * Note: this driver was taken from the sample solutions posted in Microsoft Teams
 */

public class Lab4_Driver {
    public static void main(String[] args) {
        PositionalList<Integer> list = new ArrayPositionalList<>();

        for (int i = 10; i > 0; i--) {
            list.addFirst(i);
        }
        
        System.out.println("Q1-b:\n");
        
        Position cursor = list.first();
        print("i", cursor, list);
        
        for (int j = 1; j < 5; j++)
            cursor = list.after(cursor);
        print("ii", cursor, list);             

        list.addBefore(cursor, 8);
        list.addAfter(cursor, 2);
        print("iii", cursor, list);
        
        cursor = list.before(cursor);
        cursor = list.before(cursor);
        print("iv", cursor, list);
        
        list.set(list.after(cursor), 0);
        list.remove(list.before(cursor));
        print("v", cursor, list);
    }

    public static <E> void print(String s, Position<E> p, PositionalList<E> pl){
        System.out.println(s + ": ");
        System.out.println("Cursor is at: " + p.getElement());
        System.out.println("LPL contents: " + pl );
    }
}
