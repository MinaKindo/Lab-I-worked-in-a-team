package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import exceptions.WeaponException;
import gameplay.SimpleTimer;

/**
 * 
 * @author Nate Bream
 *
 */
public class TestGenericWeapon {

  /**
   * Tests to make sure ammo is properly subtracted
   * 
   * @throws WeaponException
   *           If out of range
   */
  @Test
  public void testUseAmmo() throws WeaponException {
    GenericWeapon weapon = new MockWeapon();
    weapon.fire(10);
    assertEquals(2, weapon.getCurrentAmmo());
    weapon.fire(10);
    assertEquals(1, weapon.getCurrentAmmo());
    weapon.fire(10);
    assertEquals(0, weapon.getCurrentAmmo());
  }

  /**
   * Tests to make sure RoF/Shots left works as intended
   * 
   * @throws WeaponException
   *           If out of range
   */
  @Test
  public void testRateOfFire() throws WeaponException {
    GenericWeapon weapon = new MockWeapon();
    SimpleTimer st = new SimpleTimer(100);
    st.addTimeObserver(weapon);
    weapon.fire(10);
    weapon.fire(10);
    weapon.fire(10);
    weapon.reload();
    assertEquals(0, weapon.getShotsLeft());
    st.timeChanged();
    weapon.reload();
    assertEquals(weapon.getRateOfFire(), weapon.getShotsLeft());
  }

  /**
   * Tests reload functionality
   * 
   * @throws WeaponException
   *           if out of range
   */
  @Test
  public void testReload() throws WeaponException {
    GenericWeapon weapon = new MockWeapon();
    weapon.fire(10);
    assertEquals(2, weapon.getCurrentAmmo());
    weapon.reload();
    assertEquals(weapon.getMaxAmmo(), weapon.getCurrentAmmo());
  }

  /**
   * Tests to make sure you cannot do damage when out of ammo Also tests to make
   * sure ammo does not go into the negative
   * 
   * @throws WeaponException
   */
  @Ignore
  public void testOutOfAmmo() throws WeaponException {
    GenericWeapon weapon = new MockWeapon();
    while (weapon.getCurrentAmmo() > 0) {
      weapon.fire(10);
    }
    weapon.reload();
    assertEquals(weapon.getMaxAmmo(), weapon.getCurrentAmmo());
    while (weapon.getCurrentAmmo() > 0) {
      weapon.fire(10);
    }
    weapon.fire(10);
    assertEquals(0, weapon.getCurrentAmmo());
  }

  /**
   * Tests firing when out of range
   * 
   * @throws WeaponException
   *           if out of range
   */
  @Test
  public void testFireOutOfRange() throws WeaponException {
    GenericWeapon weapon = new MockWeapon();
    assertEquals(0, weapon.fire(50));
  }
}
