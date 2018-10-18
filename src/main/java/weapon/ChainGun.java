package weapon;

import exceptions.WeaponException;

public class ChainGun extends GenericWeapon {

  /**
   * Kamrin Langan
   */
  public ChainGun() {
    baseDamage = 15;
    maxRange = 30;
    maxAmmo = 40;
    currentAmmo = maxAmmo;
    rateOfFire = 4;
  }

  @Override
  public void updateTime(int time) {

  }

  @Override
  public int fire(int distance) throws WeaponException {
    double damage;
    if (distance < 0) {
      throw new WeaponException("Distance must be greater than 0!");
    }

    if (distance > maxRange || currentAmmo == 0) {
      damage = 0;
    } else {
      damage = baseDamage * (Double.valueOf(distance) / Double.valueOf(maxRange));
    }

    if (currentAmmo > 0) {
      currentAmmo--;
    }
    return Double.valueOf(Math.floor(damage)).intValue();
  }

  @Override
  public String toString() {

    return "ChainGun";
  }

}
