package weapon;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.WeaponException;

public class testScope {

  @Test
  public void testOnPistol() throws WeaponException {
    Weapon gun = new Pistol();
    gun = new Scope(gun);
    
    assertEquals("Pistol , Scope", gun.toString());
    
    assertEquals(5, gun.fire(30));
    assertEquals(18, gun.fire(5));
  }
  
  @Test
  public void testTwoOnPistol() throws WeaponException  {
    Weapon gun = new Pistol();
    gun = new Scope(gun);
    gun = new Scope(gun);
    
    assertEquals("Pistol , Scope , Scope", gun.toString());
    assertEquals(45, gun.getMaxRange());
    assertEquals(10, gun.fire(40));
  }
  
  @Test
  public void testOnChainGunWithPowerBooster() throws WeaponException {
    Weapon gun = new ChainGun();
    gun = new PowerBooster(gun);
    gun = new Scope(gun);
    
    assertEquals("ChainGun , PowerBooster , Scope", gun.toString());
    
    assertEquals(17, gun.fire(10));
  }
  
  @Test
  public void testOnPlasmaCannonWithStabilizer() throws WeaponException {
    Weapon gun = new PlasmaCannon();
    gun = new Stabilizer(gun);
    gun = new Scope(gun);
    
    assertEquals("PlasmaCannon , Stabilizer , Scope", gun.toString());
    
    assertEquals(93, gun.fire(15));
  }
}
