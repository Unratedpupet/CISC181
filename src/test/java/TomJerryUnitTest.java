
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TomJerryUnitTest {

    @Test
    public void testingTomJerryNoParameterConstructor() {
        System.out.println("Creating Tom & Jerry with 0 parameter constructor");

        TomJerryUnit tj = new TomJerryUnit();

        System.out.println();
        System.out.println("-- Testing Getters");
        System.out.println();

        System.out.println("-- Testing Symbol");
        assertEquals('T', tj.getSymbol());

        System.out.println("-- Testing Name");
        assertEquals("Tom & Jerry", tj.getName());

        System.out.println("-- Testing Health");
        assertEquals(100.0, tj.getHealth(), 0.0001);

        System.out.println("-- Testing Health Modifier");
        assertEquals(0.0, tj.getHealthModifier(), 0.0001);

        System.out.println("-- Testing Damage");
        assertEquals(25.0, tj.getDamage(), 0.0001);

        System.out.println("-- Testing Damage Modifier");
        assertEquals(0.0, tj.getDamageModifier(), 0.0001);

        System.out.println("-- Testing Luck");
        assertEquals(0, tj.getLuck());

        System.out.println("-- Testing xCor");
        assertEquals(5, tj.getxCor());

        System.out.println("-- Testing yCor");
        assertEquals(5, tj.getyCor());

        System.out.println("-- Testing Movement");
        assertEquals(1, tj.getMovement());

        System.out.println("-- Testing Movement Modifier");
        assertEquals(0, tj.getMovementModifier());

        System.out.println("-- Testing Homing Rocket");
        assertTrue(tj.canHomingRocket());

        System.out.println("-- Testing Offer Cheese");
        assertTrue(tj.canOfferCheese());

        System.out.println("-- Testing Hiding");
        assertFalse(tj.isHiding());

        System.out.println();
        System.out.println("-- Testing Setters");
        System.out.println();

        System.out.println("-- Testing Symbol");
        tj.setSymbol('J');
        assertEquals('J', tj.getSymbol());

        System.out.println("-- Testing Name");
        tj.setName("Tom And Jerry");
        assertEquals("Tom And Jerry", tj.getName());

        System.out.println("-- Testing Health");
        tj.setHealth(90.0F);
        assertEquals(90.0, tj.getHealth(), 0.0001);

        System.out.println("-- Testing Health Modifier");
        tj.setHealthModifier(5.0F);
        assertEquals(5.0, tj.getHealthModifier(), 0.0001);

        System.out.println("-- Testing Damage");
        tj.setDamage(23.0F);
        assertEquals(23.0, tj.getDamage(), 0.0001);

        System.out.println("-- Testing Damage Modifier");
        tj.setDamageModifier(7.0F);
        assertEquals(7.0, tj.getDamageModifier(), 0.0001);

        System.out.println("-- Testing Luck");
        tj.setLuck(95);
        assertEquals(95, tj.getLuck());

        System.out.println("-- Testing xCor");
        tj.setxCor(4);
        assertEquals(4, tj.getxCor());

        System.out.println("-- Testing yCor");
        tj.setyCor(4);
        assertEquals(4, tj.getyCor());

        System.out.println("-- Testing Movement");
        tj.setMovement(0);
        assertEquals(0, tj.getMovement());

        System.out.println("-- Testing Movement Modifier");
        tj.setMovementModifier(2);
        assertEquals(2, tj.getMovementModifier());

        System.out.println("-- Testing Homing Rocket");
        tj.setHomingRocket(false);
        assertFalse(tj.canHomingRocket());

        System.out.println("-- Testing Offer Cheese");
        tj.setOfferCheese(false);
        assertFalse(tj.canOfferCheese());

        System.out.println("-- Testing Hiding");
        tj.setHiding(true);
        assertTrue(tj.isHiding());

        System.out.println();
        System.out.println("-- Testing Instance Methods 2");
        System.out.println();

        System.out.println("-- Testing Deal Damage");
        assertEquals(30.0, tj.dealDamage(), 0.0001);
        tj.setHomingRocket(true);
        assertEquals(40.0, tj.dealDamage(), 0.0001);

        System.out.println("-- Testing Take Damage");
        tj.takeDamage(25.0);
        assertEquals(90.0, tj.getHealth(), 0.0001);
        tj.setHiding(false);
        tj.takeDamage(25.0);
        assertEquals(65.0, tj.getHealth(), 0.0001);

    }

    @Test
    public void testingTomJerryParameterConstructor() {
        System.out.println("Creating Tom & Jerry with 14 parameter constructor");

        TomJerryUnit tj = new TomJerryUnit('T', "Tom And Jerry", "Blue", 100.0, 10.0,
                25.0, 5.0, 1, 1, 1, 0, 1, 0,
                true, true, false);

        System.out.println();
        System.out.println("-- Testing Getters");
        System.out.println();

        System.out.println("-- Testing Symbol");
        assertEquals('T', tj.getSymbol());

        System.out.println("-- Testing Name");
        assertEquals("Tom And Jerry", tj.getName());

        System.out.println("-- Testing Health");
        assertEquals(100.0, tj.getHealth(), 0.0001);

        System.out.println("-- Testing Health Modifier");
        assertEquals(10.0, tj.getHealthModifier(), 0.0001);

        System.out.println("-- Testing Damage");
        assertEquals(25.0, tj.getDamage(), 0.0001);

        System.out.println("-- Testing Damage Modifier");
        assertEquals(5.0, tj.getDamageModifier(), 0.0001);

        System.out.println("-- Testing Luck");
        assertEquals(1, tj.getLuck());

        System.out.println("-- Testing xCor");
        assertEquals(1, tj.getxCor());

        System.out.println("-- Testing yCor");
        assertEquals(1, tj.getyCor());

        System.out.println("-- Testing Movement");
        assertEquals(0, tj.getMovement());

        System.out.println("-- Testing Movement Modifier");
        assertEquals(1, tj.getMovementModifier());

        System.out.println("-- Testing Homing Rocket");
        assertTrue(tj.canHomingRocket());

        System.out.println("-- Testing Offer Cheese");
        assertTrue(tj.canOfferCheese());

        System.out.println("-- Testing Hiding");
        assertFalse(tj.isHiding());

        System.out.println();
        System.out.println("-- Testing Setters");
        System.out.println();

        System.out.println("-- Testing Symbol");
        tj.setSymbol('J');
        assertEquals('J', tj.getSymbol());

        System.out.println("-- Testing Name");
        tj.setName("Tom & Jerry");
        assertEquals("Tom & Jerry", tj.getName());

        System.out.println("-- Testing Health");
        tj.setHealth(90.0F);
        assertEquals(90.0, tj.getHealth(), 0.0001);

        System.out.println("-- Testing Health Modifier");
        tj.setHealthModifier(5.0F);
        assertEquals(5.0, tj.getHealthModifier(), 0.0001);

        System.out.println("-- Testing Damage");
        tj.setDamage(20.0F);
        assertEquals(20.0, tj.getDamage(), 0.0001);

        System.out.println("-- Testing Damage Modifier");
        tj.setDamageModifier(7.0F);
        assertEquals(7.0, tj.getDamageModifier(), 0.0001);

        System.out.println("-- Testing Luck");
        tj.setLuck(95);
        assertEquals(95, tj.getLuck());

        System.out.println("-- Testing xCor");
        tj.setxCor(4);
        assertEquals(4, tj.getxCor());

        System.out.println("-- Testing yCor");
        tj.setyCor(4);
        assertEquals(4, tj.getyCor());

        System.out.println("-- Testing Movement");
        tj.setMovement(1);
        assertEquals(1, tj.getMovement());

        System.out.println("-- Testing Movement Modifier");
        tj.setMovementModifier(2);
        assertEquals(2, tj.getMovementModifier());

        System.out.println("-- Testing Homing Rocket");
        tj.setHomingRocket(false);
        assertFalse(tj.canHomingRocket());

        System.out.println("-- Testing Offer Cheese");
        tj.setOfferCheese(false);
        assertFalse(tj.canOfferCheese());

        System.out.println("-- Testing Hiding");
        tj.setHiding(true);
        assertTrue(tj.isHiding());

        System.out.println();
        System.out.println("-- Testing Instance Methods 2");
        System.out.println();

        System.out.println("-- Testing Deal Damage");
        assertEquals(27.0, tj.dealDamage(), 0.0001);
        tj.setHomingRocket(true);
        assertEquals(37.0, tj.dealDamage(), 0.0001);

        System.out.println("-- Testing Take Damage");
        tj.takeDamage(25.0);
        assertEquals(90.0, tj.getHealth(), 0.0001);
        tj.setHiding(false);
        tj.takeDamage(25.0);
        assertEquals(65.0, tj.getHealth(), 0.0001);

    }


}
