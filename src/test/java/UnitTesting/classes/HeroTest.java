package UnitTesting.classes;

import UnitTesting.classes.interfaces.Target;
import UnitTesting.classes.interfaces.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeroTest {

    private Hero hero;

    @BeforeEach
    void setUp() {

        Weapon mockedAxe = Mockito.mock(Weapon.class);
        this.hero = new Hero("Ragnarok", mockedAxe);
    }

    @Test
    void testThatHeroGetsXPWhenTargetKilled() {
        Target mockedTarget = Mockito.mock(Target.class);
        Mockito.when(mockedTarget.isDead()).thenReturn(true);
        Mockito.when(mockedTarget.giveExperience()).thenReturn(100);
        this.hero.attack(mockedTarget);
        assertEquals(100, this.hero.getExperience());
    }
}