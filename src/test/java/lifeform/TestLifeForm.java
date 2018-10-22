package lifeform;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import weapon.ChainGun;
import weapon.Pistol;

/**
 * Tests the functionality provided by the LifeForm class
 *
 */
public class TestLifeForm {

  /**
   * @author Aminata
   */
  @Test
  public void canPickUpWeapon() {
    LifeForm entity = new MockLifeForm("Bob", 40, 0);
    Pistol pistol = new Pistol();
    //this should be true
    assertTrue(entity.pickUpWeapon(pistol));
    assertTrue(entity.hasWeapon());
  }
  
  /**
   * @author Aminata
   */
  @Test
  public void canPickOnlyOneWeapon() {
    LifeForm entity = new MockLifeForm("Bob", 40, 0);
    Pistol pistol = new Pistol();
    ChainGun chain = new ChainGun();
    //this should be true
    assertTrue(entity.pickUpWeapon(pistol));
    assertTrue(entity.hasWeapon());
    assertFalse(entity.pickUpWeapon(chain));
  }
  
  /**
   * @author Aminata
   */
  @Test
  public void canDropWeapon() {
    LifeForm entity = new MockLifeForm("Bob", 40, 0);
    Pistol pistol = new Pistol();
    //this should be true
    assertTrue(entity.pickUpWeapon(pistol));
    assertTrue(entity.hasWeapon());
    entity.dropWeapon();
    assertFalse(entity.hasWeapon());
  }
  
  
  
  /**
   * When a LifeForm is created, it should know its name and how many life points
   * it has.
   */
  @Test
  public void testLifeFormInitialization() {
    LifeForm entity;
    entity = new MockLifeForm("Bob", 40, 0);
    assertEquals("Bob", entity.getName());
    assertEquals(40, entity.getCurrentLifePoints());
  }

  /**
   * tests a life form taking a hit.
   */
  @Test
  public void testTakeHit() {
    LifeForm entity;
    entity = new MockLifeForm("Bob", 50, 0);

    // should take a 10 point hit
    entity.takeHit(10);
    assertEquals(40, entity.getCurrentLifePoints());

    // if life form takes exact life in a hit, goes to 0 and dies.
    entity.takeHit(40);
    assertEquals(0, entity.getCurrentLifePoints());

    // ensures life points can't go below 0.
    entity = new MockLifeForm("Bob", 15, 0);
    entity.takeHit(25);
    assertEquals(0, entity.getCurrentLifePoints());
  }
  
  @Test
  public void testAttackOpponent()  {
    
    LifeForm bob = new MockLifeForm("Bob", 100, 10);
    LifeForm john = new MockLifeForm("John", 100, 15);
    
    //assures getAttackStrength returns proper attack strength
    assertEquals(10, bob.getAttackStrength());
    assertEquals(15, john.getAttackStrength());
    
    bob.attack(john);
    john.attack(bob);
    
    assertEquals(90, john.getCurrentLifePoints());
    assertEquals(85, bob.getCurrentLifePoints());
  }
  
  @Test
  public void testNoAttackWhenDead()  {
    
    LifeForm bob = new MockLifeForm("Bob", 100, 100);
    LifeForm john = new MockLifeForm("John", 100, 15);
    
    bob.attack(john);
    
    //john should be unable to attack
    john.attack(bob);
    
    assertEquals(0, john.getCurrentLifePoints());
    assertEquals(100, bob.getCurrentLifePoints());
  }


}
