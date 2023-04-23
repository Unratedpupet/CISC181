
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BartSimpsonUnitTest {

    @Test
    public void testingBartSimpsonNoParameterConstructor() {
        System.out.println("Creating Bart Simpson with 0 parameter constructor");
        
        BartSimpsonUnit bs = new BartSimpsonUnit();
        
        System.out.println();
        System.out.println("-- Testing Getters");
        System.out.println();

        System.out.println("-- Testing Symbol");
        assertEquals('B', bs.getSymbol());

        System.out.println("-- Testing Name");
        assertEquals("Bart Simpson", bs.getName());

        System.out.println("-- Testing Health");
        assertEquals(100.0, bs.getHealth(), 0.0001);

        System.out.println("-- Testing Health Modifier");
        assertEquals(0.0, bs.getHealthModifier(), 0.0001);

        System.out.println("-- Testing Damage");
        assertEquals(25.0, bs.getDamage(), 0.0001);

        System.out.println("-- Testing Damage Modifier");
        assertEquals(0.0, bs.getDamageModifier(), 0.0001);

        System.out.println("-- Testing Luck");
        assertEquals(0, bs.getLuck());

        System.out.println("-- Testing xCor");
        assertEquals(5, bs.getxCor());

        System.out.println("-- Testing yCor");
        assertEquals(5, bs.getyCor());

        System.out.println("-- Testing Movement");
        assertEquals(1, bs.getMovement());

        System.out.println("-- Testing Movement Modifier");
        assertEquals(0, bs.getMovementModifier());

        System.out.println("-- Testing Number Times Spawned");
        assertEquals(0, bs.getNumTimesSpawned());

        System.out.println("-- Testing Distracted");
        assertTrue(bs.canDistract());

        System.out.println("-- Testing Recruit");
        assertTrue(bs.canRecruit());

        System.out.println();
        System.out.println("-- Testing Setters");
        System.out.println();

        System.out.println("-- Testing Symbol");
        bs.setSymbol('B');
        assertEquals('B', bs.getSymbol());

        System.out.println("-- Testing Name");
        bs.setName("Bart Simpson");
        assertEquals("Bart Simpson", bs.getName());

        System.out.println("-- Testing Health");
        bs.setHealth(90.0F);
        assertEquals(90.0, bs.getHealth(), 0.0001);

        System.out.println("-- Testing Health Modifier");
        bs.setHealthModifier(5.0F);
        assertEquals(5.0, bs.getHealthModifier(), 0.0001);

        System.out.println("-- Testing Damage");
        bs.setDamage(23.0F);
        assertEquals(23.0, bs.getDamage(), 0.0001);

        System.out.println("-- Testing Damage Modifier");
        bs.setDamageModifier(7.0F);
        assertEquals(7.0, bs.getDamageModifier(), 0.0001);

        System.out.println("-- Testing Luck");
        bs.setLuck(95);
        assertEquals(95, bs.getLuck());

        System.out.println("-- Testing xCor");
        bs.setxCor(4);
        assertEquals(4, bs.getxCor());

        System.out.println("-- Testing yCor");
        bs.setyCor(4);
        assertEquals(4, bs.getyCor());

        System.out.println("-- Testing Movement");
        bs.setMovement(0);
        assertEquals(0, bs.getMovement());

        System.out.println("-- Testing Movement Modifier");
        bs.setMovementModifier(2);
        assertEquals(2, bs.getMovementModifier());

        System.out.println("-- Testing Number Times Spawned");
        bs.setNumTimesSpawned(1);
        assertEquals(1, bs.getNumTimesSpawned());

        System.out.println("-- Testing Distracted");
        bs.setDistract(false);
        assertFalse(bs.canDistract());

        System.out.println("-- Testing Recruit");
        bs.setRecruit(false);
        assertFalse(bs.canRecruit());

        System.out.println();
        System.out.println("-- Testing Instance Methods 2");
        System.out.println();

    }

    @Test
    public void testingBartSimpsonParameterConstructor() {
        System.out.println("Creating Bart Simpson with 14 parameter constructor");

        BartSimpsonUnit bs = new BartSimpsonUnit('B', "Bart Simpson", "Blue", 99.0, 0.5, 20.0, 0.5, 2, 4, 4, 4, 2, 2, 0,false, false);

        System.out.println("-- Testing getHealthModifier");
        assertEquals(0.5, bs.getHealthModifier());

        System.out.println("-- Testing getDamage");
        assertEquals(20.0, bs.getDamage());

        System.out.println("-- Testing getDamageModifier");
        assertEquals(0.5, bs.getDamageModifier());

        System.out.println("-- Testing getLuck");
        assertEquals(2, bs.getLuck());

        System.out.println("-- Testing getXCor");
        assertEquals(4, bs.getxCor());

        System.out.println("-- Testing getYCor");
        assertEquals(4, bs.getyCor());

        System.out.println("-- Testing getMovement");
        assertEquals(4, bs.getMovement());

        System.out.println("-- Testing getMovementModifier");
        assertEquals(2, bs.getMovementModifier());

        System.out.println("-- Testing setSymbol");
        bs.setSymbol('S');
        assertEquals('S', bs.getSymbol());

        System.out.println("-- Testing setDamageModifier");
        bs.setDamageModifier(1.0);
        assertEquals(1.0, bs.getDamageModifier());

        System.out.println("-- Testing setRecruit");
        bs.setRecruit(true);
        assertTrue(bs.canRecruit());

        System.out.println("-- Testing distracted(false)");
        bs.distracted();
        System.out.println("-- Testing distracted(true)");
        bs.setDistract(true);
        bs.distracted();



    }

    @Test
    public void test_spawn() {
        System.out.println("Testing spawn");
        // create a BartSimpsonUnit and call its spawn method
        BartSimpsonUnit bart = new BartSimpsonUnit();
        // bart should be able to spawn
        assertTrue(bart.canSpawn());

        // bart spawns
        BartSimpsonUnit lilBart = bart.spawn();
        // Number of times piece has spawned should be increased
        assertEquals(1, bart.getNumTimesSpawned());

        // Now that max time number of spawns reached - it
        // shouldn't be able to spawn anymore
        assertFalse(bart.canSpawn());
        assertFalse(lilBart.canSpawn());

    }


}