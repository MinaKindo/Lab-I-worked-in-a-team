package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.AttachmentException;
import exceptions.WeaponException;

public class TestScope {

  @Test
  public void testOnPistol() throws WeaponException, AttachmentException {
    Weapon gun = new Pistol();
    gun = new Scope(gun);

    assertEquals("Pistol +Scope", gun.toString());

    assertEquals(9, gun.fire(30));
    assertEquals(21, gun.fire(5));
  }

  @Test
  public void testTwoOnPistol() throws WeaponException, AttachmentException {
    Weapon gun = new Pistol();
    gun = new Scope(gun);
    gun = new Scope(gun);

    assertEquals("Pistol +Scope +Scope", gun.toString());
    assertEquals(70, gun.getMaxRange());
    assertEquals(7, gun.fire(40));
  }

  @Test
  public void testOnChainGunWithPowerBooster() throws WeaponException, AttachmentException {
    Weapon gun = new ChainGun();
    gun = new PowerBooster(gun);
    gun = new Scope(gun);

    assertEquals("ChainGun +PowerBooster +Scope", gun.toString());

    assertEquals(7, gun.fire(10));
  }

  @Test
  public void testOnPlasmaCannonWithStabilizer() throws WeaponException, AttachmentException {
    Weapon gun = new PlasmaCannon();
    gun = new Stabilizer(gun);
    gun = new Scope(gun);

    assertEquals("PlasmaCannon +Stabilizer +Scope", gun.toString());

    assertEquals(105, gun.fire(15));
  }
}
