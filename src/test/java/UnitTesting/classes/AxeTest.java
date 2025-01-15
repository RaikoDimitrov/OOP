package UnitTesting.classes;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;


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
        Assert.assertEquals(9, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class) //assert
    public void testThatBrokenAxeCantAttack() {
        //arrange
        Axe brokenAxe = new Axe(10, 0);
        //act
        brokenAxe.attack(dummy);
    }

}