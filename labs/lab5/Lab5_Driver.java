/**
 * Lab 5
 * @author Robby Renz Abeysinghe
 * Student Number: 3073208
 */

import java.util.Iterator;

public class Lab5_Driver {
    public static void main (String[] args){
        PositionalList<Integer> list = new LinkedPositionalList<>();
        int[] temp = {8, 1, 8, 6, 2, 7, 5, 1, 2, 5, 5, 4, 0, 9, 1, 2, 9};
        for (int i : temp)
            list.addLast(i);
        System.out.println("Original list: ");
        System.out.println(list);

        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            if (iter.next() < 3)
                iter.remove();
        }
        System.out.println("List with the elements 1 & 2 removed:\n" + list);

        Iterator<Position<Integer>> piter = list.positions().iterator();
        for (Integer i: list) {
            Position p = piter.next();
            if (p.getElement().equals(4))
                list.set(p, 3);
        }
        System.out.println("List with the every 4 replaced with 3:\n" + list);

        Iterator<Integer> iterTwo = list.iterator();
        while (iterTwo.hasNext()) {
            int number = iterTwo.next();
            int secondNumber = iterTwo.next();
            if (number == secondNumber)
                iterTwo.remove();
        }
        System.out.println("List with all the consecutive duplicated removed:\n" + list);

        int sum = 0;
        Iterator<Position<Integer>> piterTwo = list.positions().iterator();
        for (Integer i: list) {
            Position p = piterTwo.next();
            sum += (int) p.getElement();
        }
        System.out.println("The sum of the integers in the list:\n" + sum);
    }
}
