package UnitTesting.classes;

import org.junit.Assert;
import org.junit.Test;


public class AxeTest {

    @Test
    public void testThatWeaponAttackLosesDurability() {
        //arrange
        Axe axe = new Axe(10, 10);
        Dummy dummy = new Dummy(10, 10);
        //act
        axe.attack(dummy);
        //assert
        Assert.assertEquals(9, axe.getDurabilityPoints());
    }

}