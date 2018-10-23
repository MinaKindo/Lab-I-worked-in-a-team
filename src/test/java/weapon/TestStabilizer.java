package weapon;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.AttachmentException;
import exceptions.WeaponException;

public class TestStabilizer {

  @Test
  public void testOnPlasmaCannon() throws WeaponException, AttachmentException {
    Weapon gun = new PlasmaCannon();
    gun = new Stabilizer(gun);
    
    assertEquals(1, gun.getNumAttachments());
    assertEquals("PlasmaCannon , Stabilizer", gun.toString());
    
    assertEquals(62, gun.fire(5));
  }
  
  @Test
  public void testTwoOnPlasmaCannon() throws WeaponException, AttachmentException {
    Weapon gun = new PlasmaCannon();
    gun = new Stabilizer(gun);
    gun = new Stabilizer(gun);
    
    assertEquals(2, gun.getNumAttachments());
    assertEquals("PlasmaCannon , Stabilizer , Stabilizer", gun.toString());
    
    assertEquals(77, gun.fire(5));
  }
  
  @Test
  public void testOnPistolWithScope() throws WeaponException, AttachmentException  {
    Weapon gun = new Pistol();
    gun = new Scope(gun);
    gun = new Stabilizer(gun);
    
    assertEquals("Pistol , Scope , Stabilizer", gun.toString());
    
    assertEquals(20, gun.fire(10));
  }
  
  @Test
  public void testOnChainGunWithPowerBooster() throws WeaponException, AttachmentException {
    Weapon gun = new ChainGun();
    gun = new PowerBooster(gun);
    gun = new Stabilizer(gun);
    
    assertEquals("ChainGun , PowerBooster , Stabilizer", gun.toString());
    
    assertEquals(12, gun.fire(20));
  }
  
  @Test
  public void testThreeAttachments() throws AttachmentException {
    Weapon gun = new ChainGun();
    gun = new Stabilizer(gun);
    gun = new Stabilizer(gun);
    try {
      gun = new Stabilizer(gun);
    } catch (AttachmentException e) {
      e.printStackTrace();
    }
    
    assertEquals(2, gun.getNumAttachments());
  }
}
