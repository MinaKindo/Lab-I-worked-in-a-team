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
    assertEquals(6, gun.fire(23));
    assertEquals(9, gun.fire(10));
  }
  
  @Test
  public void testFireUnreachableDistance() throws WeaponException {
    Pistol gun = new Pistol();
    //Cannot reach, no damage because maxRange is 50.
    //but will still lose ammo
    assertEquals(0, gun.fire(51));
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
  
  
}
