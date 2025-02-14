package UnitTesting.listIterator;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;
import java.util.List;

public class ListIterator {
    private final List<String> elements;
    private int currentIndex;

    public ListIterator(String... elements) throws OperationNotSupportedException {
        if (elements == null) {
            throw new OperationNotSupportedException();
        }

        this.elements = Arrays.asList(elements);
        this.currentIndex = 0;
    }

    public boolean move(){
        if(hasNext()){
            this.currentIndex++;
            return true;
        }

        return false;
    }

    public boolean hasNext(){
        return currentIndex < elements.size() - 1;
    }

    public String print(){
        if(this.elements.size() == 0){
            throw new IllegalStateException("Invalid Operation!");
        }

        return this.elements.get(this.currentIndex);
    }
}
