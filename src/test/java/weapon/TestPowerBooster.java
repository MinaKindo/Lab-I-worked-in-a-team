package weapon;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.WeaponException;

public class TestPowerBooster {

  @Test
  public void testOnChainGun() throws WeaponException {
    Weapon gun = new ChainGun();
    gun = new PowerBooster(gun);
    
    assertEquals("ChainGun , PowerBooster", gun.toString());
    
    assertEquals(14, gun.fire(15));
  }
  
  @Test
  public void testTwoOnChainGun() throws WeaponException  {
    Weapon gun = new ChainGun();
    gun = new PowerBooster(gun);
    gun = new PowerBooster(gun);
    
    assertEquals("ChainGun , PowerBooster , PowerBooster", gun.toString());
    assertEquals(28, gun.fire(15));
  }
  
  @Test
  public void testOnPistolWithScope() throws WeaponException  {
    Weapon gun = new Pistol();
    gun = new Scope(gun);
    gun = new PowerBooster(gun);
    
    assertEquals("Pistol , Scope , PowerBooster", gun.toString());
    
    assertEquals(26, gun.fire(10));
  }
  
  @Test
  public void testOnPlasmaCannonWithStabilizer() throws WeaponException {
    Weapon gun = new PlasmaCannon();
    gun = new Stabilizer(gun);
    gun = new PowerBooster(gun);
    
    assertEquals("PlasmaCannon , Stabilizer , PowerBooster", gun.toString());
    
    assertEquals(124, gun.fire(10));
  }

}
