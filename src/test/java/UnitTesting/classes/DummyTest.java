package UnitTesting.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DummyTest {

    private final static int DUMMY_HEALTH_POINTS = 100;
    private final static int XP = 50;
    private final static int ATTACK_POINTS = 10;

    private Dummy dummy;
    private Dummy deadDummy;

    @BeforeEach
    public void setUp() {
        System.out.println("Setting up dummy");
        this.dummy = new Dummy(DUMMY_HEALTH_POINTS, XP);
        this.deadDummy = new Dummy(0, XP);
    }


    @Test
    public void testThatDummyLosesHealthIfAttacked() {
        dummy.takeAttack(ATTACK_POINTS);
        assertEquals(DUMMY_HEALTH_POINTS - ATTACK_POINTS, dummy.getHealth());

    }

    @Test
    public void testThatDummyThrowsExceptionIfDead() {
        assertThrows(IllegalStateException.class, () -> deadDummy.takeAttack(100));
    }

    @Test
    public void testThatDeadDummyCanGiveXP() {
        assertEquals(XP, deadDummy.giveExperience());
    }

    @Test
    public void testThatAliveDummyCantGiveXP() {
        assertThrows(IllegalStateException.class, () -> dummy.giveExperience());
    }

}