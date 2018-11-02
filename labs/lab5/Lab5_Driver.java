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
        
        Iterator<Position<Integer>> piter = list.positions().iterator();

        while (piter.hasNext()) {
            Position p = piter.next();
            if (p.getElement().equals(1) || p.getElement().equals(2));
                list.set(p, 0);
        }
        System.out.println("List with the elements 1 & 2 removed:" + list);

        System.out.println("List with the every 4 replaced with 3:" + list);

        System.out.println("List with all the consecutive duplicated removed:" + list);

        System.out.println("The sum of the integers in the list:" + list);
    }
}
