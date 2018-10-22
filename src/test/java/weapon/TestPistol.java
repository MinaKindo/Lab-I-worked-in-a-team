package weapon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import exceptions.WeaponException;

/**
 * 
 * @author Aminata
 *
 */
public class TestPistol {
  @Test
  public void testFireReachableDistance() throws WeaponException {
    Pistol gun = new Pistol();       
    assertEquals(2, gun.fire(23));
    assertEquals(8, gun.fire(10));
  }
  
  @Test
  public void testFireUnreachableDistance() throws WeaponException {
    Pistol gun = new Pistol();
    //Cannot reach, no damage because maxRange is 25.
    //but will still lose ammo
    assertEquals(0, gun.fire(26));
    assertEquals(9, gun.getCurrentAmmo());
       
  }
  
  @Test
  public void testFireNegativeDistance() {
    
    try {
      Pistol gun = new Pistol();
      gun.fire(-23);
      fail();
      assertEquals(10, gun.getCurrentAmmo());
    } catch (WeaponException e) {
      new WeaponException("Distance must be greater than or equal to 0!");
    }
  }
  
  @Test
  public void testZeroAmmo() {
    
    try {
      Pistol gun = new Pistol();
      //fire and finish all ammo
      for (int i = 10; i > 0; i--) {
        gun.fire(6);
      }
      //try firing again , but 0 ammo should throw exception
      assertEquals(0, gun.getCurrentAmmo());
      gun.fire(6);
      fail();
    } catch (WeaponException e) {
      new WeaponException("Distance must be greater than or equal to 0!");
    }
  }
}
