
import java.util.Iterator;

public class IteratorEg {
    public static void main(String[] args){
        PositionalList<Integer> list = new LinkedPositionalList<>();
        for (int i=10; i>0; i--){
            list.addFirst(i);
        }
        
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()){
            if (iter.next() < 3)
                iter.remove();
        }
        System.out.println("Remove if < 3: " + list);     
        
        Iterator<Position<Integer>> piter = list.positions().iterator();
        while (piter.hasNext()){
            Position p = piter.next();
            if (p.getElement().equals(7))
                list.set(p, 0);
        }
        System.out.println("Replace 7 with 0: " + list); 
     
    }
}
