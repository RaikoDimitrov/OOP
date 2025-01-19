package UnitTesting.listIterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.jupiter.api.Assertions.*;

class ListIteratorTest {

    private static final String[] NAMES = new String[] {"Alex", "Raiko", "Ivan"};
    private ListIterator listIterator;

    @BeforeEach
    void setUp() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(NAMES);
    }

    //test constructor
    @Test
    void testThatCanInitializeListIterator() {

    }

    @Test
    void testThatThrowsExceptionListIterator() {
        assertThrows(OperationNotSupportedException.class, () -> listIterator = new ListIterator(null));
    }

    @Test
    void testThatCanMoveIndex() {
        boolean move = listIterator.move();
        assertTrue(move);
    }
    @Test
    void testThatCantMoveIndex() {
        listIterator.move();
        listIterator.move();
        listIterator.move();
        boolean move = listIterator.move();
        assertFalse(move);
    }

    @Test
    void testThatThereAreNextElements () {
        boolean hasNext = listIterator.hasNext();
        assertTrue(hasNext);
    }

    @Test
    void testThatCantPrintEmpty() {
        assertThrows(IllegalStateException.class, () -> {
            this.listIterator = new ListIterator();
            this.listIterator.print();
        });
    }

    @Test
    void testThatCanPrint() {
        int index = 0;
        while (listIterator.hasNext()) {
            assertEquals(NAMES[index], listIterator.print());
            index++;
            listIterator.move();
        }
    }
}