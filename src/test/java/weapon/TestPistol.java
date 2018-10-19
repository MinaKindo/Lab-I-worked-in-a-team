package weapon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import exceptions.WeaponException;

public class TestPistol {
  @Test
  public void testFireReachableDistance() throws WeaponException {
    Pistol gun = new Pistol();
    gun.fire(23);
    assertEquals(9, gun.getCurrentAmmo());
    assertEquals(2, gun.fire(23));
  }
  
  @Test
  public void testFireUnreachableDistance() throws WeaponException {
    Pistol gun = new Pistol();
    gun.fire(26);
    assertEquals(9, gun.getCurrentAmmo());
    assertEquals(0, gun.fire(26));   
  }
  
  @Test
  public void testFireNegativeDistance(){
    Pistol gun = new Pistol();
    try {
      gun.fire(-23);
      fail();
      assertEquals(10, gun.getCurrentAmmo());
    } catch (WeaponException e) {
      new WeaponException("Distance must be greater than or equal to 0!");
    }
  }
}
