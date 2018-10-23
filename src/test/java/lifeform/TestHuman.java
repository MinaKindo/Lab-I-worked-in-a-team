package lifeform;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestHuman {

  @Test
  public void testHumanInit() {

    Human man = new Human("Man", 50, 1);
    assertEquals(50, man.getCurrentLifePoints());
    assertEquals(1, man.getArmorPoints());
    assertEquals(5, man.getAttackStrength());

    Human negArmorMan = new Human("Armorless", 50, -5);
    assertEquals(50, negArmorMan.getCurrentLifePoints());
    assertEquals(0, negArmorMan.getArmorPoints());
  }

  @Test
  public void testHumanNoArmor() {

    Human man = new Human("Man", 50, 0);

    man.takeHit(45);
    assertEquals(5, man.getCurrentLifePoints());
  }

  @Test
  public void testHumanWithArmor() {

    Human man = new Human("Man", 50, 15);
    man.takeHit(25);

    assertEquals(40, man.getCurrentLifePoints());

    // man life points should take no damage
    man.takeHit(5);
    assertEquals(40, man.getCurrentLifePoints());

    // man should die
    man.takeHit(55);
    assertEquals(0, man.getCurrentLifePoints());
  }

}
