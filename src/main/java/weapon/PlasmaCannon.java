package weapon;

import exceptions.WeaponException;

public class PlasmaCannon extends GenericWeapon {

  public PlasmaCannon() {
    maxAmmo = 4;
    currentAmmo = maxAmmo;
    baseDamage = 50;
    rateOfFire = 1;
    maxRange = 20;
    shotsLeft = rateOfFire;
  }

  @Override
  public void updateTime(int time) {
    shotsLeft = rateOfFire;
  }

  /**
   * @author Conner
   */
  @Override
  public int fire(int distance) throws WeaponException {

    double damage = Double.valueOf(baseDamage) * (Double.valueOf(currentAmmo) / Double.valueOf(maxAmmo));
    if (distance < 0) {
      throw new WeaponException("Distance must be greater than or equal to 0!");
    }

    if (distance > maxRange) {
      currentAmmo--;
      shotsLeft--;
      return 0;
    }
    if (shotsLeft <= 0) {
      shotsLeft = 0;
      return 0;
    } 
    if (currentAmmo <= 0) {
      throw new WeaponException("Weapon is out of Ammo!");
    }
    currentAmmo--;
    shotsLeft--;
    return Double.valueOf(Math.floor(damage)).intValue();
  }

  @Override
  public String toString() {

    return "PlasmaCannon";
  }
}
