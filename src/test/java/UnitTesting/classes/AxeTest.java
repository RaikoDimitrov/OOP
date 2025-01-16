package UnitTesting.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AxeTest {

    private Dummy dummy;

    @BeforeEach
    public void setUp() {
        this.dummy = new Dummy(10, 10);
    }

    @Test
    public void testThatAxeAttackLosesDurability() {
        //arrange
        Axe axe = new Axe(10, 10);
        //act
        axe.attack(dummy);
        //assert
        assertEquals(9, axe.getDurabilityPoints());
    }

    @Test
    public void testThatBrokenAxeCantAttack() {
        assertThrows(IllegalStateException.class, () -> {
            Axe brokenAxe = new Axe(10, 0);
            brokenAxe.attack(dummy);
        });
    }

}