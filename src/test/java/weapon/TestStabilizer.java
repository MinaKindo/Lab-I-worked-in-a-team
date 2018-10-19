package weapon;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.WeaponException;

public class TestStabilizer {

  @Test
  public void testOnPlasmaCannon() throws WeaponException {
    Weapon gun = new PlasmaCannon();
    gun = new Stabilizer(gun);
    
    assertEquals("PlasmaCannon , Stabilizer", gun.toString());
    
    assertEquals(62, gun.fire(5));
  }
  
  @Test
  public void testTwoOnPlasmaCannon() throws WeaponException {
    Weapon gun = new PlasmaCannon();
    gun = new Stabilizer(gun);
    gun = new Stabilizer(gun);
    
    assertEquals("PlasmaCannon , Stabilizer , Stabilizer", gun.toString());
    
    assertEquals(77, gun.fire(5));
  }
  
  @Test
  public void testOnPistolWithScope() throws WeaponException  {
    Weapon gun = new Pistol();
    gun = new Scope(gun);
    gun = new Stabilizer(gun);
    
    assertEquals("Pistol , Scope , Stabilizer", gun.toString());
    
    assertEquals(16, gun.fire(10));
  }
  
  @Test
  public void testOnChainGunWithPowerBooster() throws WeaponException {
    Weapon gun = new ChainGun();
    gun = new PowerBooster(gun);
    gun = new Stabilizer(gun);
    
    assertEquals("ChainGun , PowerBooster , Stabilizer", gun.toString());
    
    assertEquals(25, gun.fire(20));
  }

}
