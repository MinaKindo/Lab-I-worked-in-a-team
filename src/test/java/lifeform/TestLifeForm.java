package lifeform;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import exceptions.WeaponException;
import weapon.ChainGun;
import weapon.Pistol;
import weapon.PlasmaCannon;

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
    // this should be true
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
    // this should be true
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
    // this should be true
    assertTrue(entity.pickUpWeapon(pistol));
    assertTrue(entity.hasWeapon());
    entity.dropWeapon();
    assertFalse(entity.hasWeapon());
  }

  /**
   * @author Aminata
   * @throws WeaponException
   */
  @Test
  public void canAttackWithPistol() throws WeaponException {
    LifeForm bob = new MockLifeForm("Bob", 40, 5);
    LifeForm eve = new MockLifeForm("Eve", 40, 5);
    Pistol pistol = new Pistol();
    bob.pickUpWeapon(pistol);
    // eve is at 10 feet, attack will be done using weapon
    bob.attack(eve, 10);
    // eve currentLP should be 32
    assertEquals(31, eve.getCurrentLifePoints());
  }

  /**
   * @author Conner Hill
   * @throws WeaponException
   */
  @Test
  public void canAttackWithPlasmaCannon() throws WeaponException {
    LifeForm bob = new MockLifeForm("Bob", 40, 5);
    LifeForm eve = new MockLifeForm("Eve", 60, 5);
    PlasmaCannon plasma = new PlasmaCannon();
    bob.pickUpWeapon(plasma);
    bob.attack(eve, 10);
    assertEquals(10, eve.getCurrentLifePoints());

  }

  /**
   * @author Aminata
   * @throws WeaponException
   */
  @Test
  public void meleeAttackWhenNoWeapon() throws WeaponException {
    LifeForm bob = new MockLifeForm("Bob", 40, 5);
    LifeForm eve = new MockLifeForm("Eve", 40, 5);
    // eve is at 10 feet, no damage to eve
    bob.attack(eve, 10);
    // eve currentLP should be 35
    assertEquals(40, eve.getCurrentLifePoints());
  }

  /**
   * @author Conner
   * @throws WeaponException
   */
  @Test
  public void meleeAttackWhenNoAmmo() throws WeaponException {
    LifeForm bob = new MockLifeForm("Bob", 40, 5);
    LifeForm eve = new MockLifeForm("Eve", 40, 5);
    PlasmaCannon plasma = new PlasmaCannon();
    bob.pickUpWeapon(plasma);

    for (int i = 0; i < 4; i++) {
      plasma.fire(10);
      plasma.updateTime(9);
    }

    bob.attack(eve, 4);
    assertEquals(35, eve.getCurrentLifePoints());

  }

  /**
   * @author Conner
   */
  @Test
  public void meleeAttackOverFiveFeet() throws WeaponException {
    LifeForm bob = new MockLifeForm("Bob", 40, 5);
    LifeForm eve = new MockLifeForm("Eve", 40, 5);

    bob.attack(eve, 30);
    assertEquals(40, eve.getCurrentLifePoints());

    bob.attack(eve, 3);
    assertEquals(35, eve.getCurrentLifePoints());

    bob.attack(eve, 30);
    assertEquals(35, eve.getCurrentLifePoints());
  }

  /**
   * @author Conner
   */
  @Test
  public void testReload() throws WeaponException {
    LifeForm bob = new MockLifeForm("Bob", 40, 5);
    LifeForm eve = new MockLifeForm("Eve", 40, 5);
    Pistol pistol = new Pistol();
    bob.pickUpWeapon(pistol);

    for (int i = 0; i < 2; i++) {
      bob.attack(eve, 10);
    }

    assertEquals(8, pistol.getCurrentAmmo());

    pistol.reload();

    assertEquals(10, pistol.getCurrentAmmo());

  }

  
  //End of lab 4 tests****************************
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
  public void testAttackOpponent() throws WeaponException {

    LifeForm bob = new MockLifeForm("Bob", 100, 10);
    LifeForm john = new MockLifeForm("John", 100, 15);

    // assures getAttackStrength returns proper attack strength
    assertEquals(10, bob.getAttackStrength());
    assertEquals(15, john.getAttackStrength());

    bob.attack(john, 0);
    john.attack(bob, 0);

    assertEquals(90, john.getCurrentLifePoints());
    assertEquals(85, bob.getCurrentLifePoints());
  }

  @Test
  public void testNoAttackWhenDead() throws WeaponException {

    LifeForm bob = new MockLifeForm("Bob", 100, 100);
    LifeForm john = new MockLifeForm("John", 100, 15);

    bob.attack(john, 0);

    // john should be unable to attack
    john.attack(bob, 0);

    assertEquals(0, john.getCurrentLifePoints());
    assertEquals(100, bob.getCurrentLifePoints());
  }

}
