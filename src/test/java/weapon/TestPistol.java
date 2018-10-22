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
    assertEquals(8, gun.fire(10));
  }
  
  @Test
  public void testFireUnreachableDistance() throws WeaponException {
    Pistol gun = new Pistol();
    gun.fire(26);
    assertEquals(9, gun.getCurrentAmmo());
    assertEquals(0, gun.fire(26));   
  }

  @Test
  public void testBug1() throws WeaponException {
    Pistol gun = new Pistol();
    for (int i=0; i<10; i++) {
      gun.fire(10);
    }

    gun.fire(1000);

    //This is what it should be
    assertEquals(0, gun.fire(10));
    assertEquals(0, gun.getCurrentAmmo());
    assertEquals(0, gun.fire(10));
    assertEquals(0, gun.getCurrentAmmo());

    /* You are able to pass the following which means the program is wrong
    assertEquals(8, gun.fire(10));
    assertEquals(-2, gun.getCurrentAmmo());
    assertEquals(8, gun.fire(10));
    assertEquals(-3, gun.getCurrentAmmo());
    */
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
