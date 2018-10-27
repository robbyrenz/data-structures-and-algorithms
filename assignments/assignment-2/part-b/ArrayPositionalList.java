/**
 * Implementation of a positional list with an array
 * @author 
 */

public class ArrayPositionalList<E> implements PositionalList<E> {
    
    private static class ArrPos<E> implements Position<E> {
        private int index;  
        private E element;  
        
        public ArrPos(E e, int i){
            index = i;
            element = e;
        }

        public E getElement() throws IllegalStateException {
           if (index == -1)
               throw new IllegalStateException("Position no longer valid");
           return element;
        }

        public void setElement(E e){
            element = e;
        }

        public int getIndex(){
            return index;
        }

        public void setIndex(int i){
            index = i;
        }   
    }   // end of nested ArrPos class

    
    
    
    
    
}


