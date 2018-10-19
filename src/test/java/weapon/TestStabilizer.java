package weapon;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.WeaponException;

public class TestStabilizer {

  @Test
  public void testOnPlasmaCannon() throws WeaponException {
    Weapon gun = new PlasmaCannon();
    gun = new Stabilizer(gun);
    
    assertEquals(62, gun.fire(5));
  }
  
  @Test
  public void testTwoOnPlasmaCannon() throws WeaponException {
    Weapon gun = new PlasmaCannon();
    gun = new Stabilizer(gun);
    gun = new Stabilizer(gun);
    
    assertEquals(74, gun.fire(5));
  }

}
