package weapon;

import exceptions.WeaponException;

public class PlasmaCannon extends GenericWeapon {

  public PlasmaCannon() {
    maxAmmo = 4;
    currentAmmo = maxAmmo;
    baseDamage = 50;
    rateOfFire = 1;
    maxRange = 20;
  }

  @Override
  public void updateTime(int time) {
    // TODO Auto-generated method stub

  }

  @Override
  public int fire(int distance) throws WeaponException {

    double damage = baseDamage * (Double.valueOf(currentAmmo) / Double.valueOf(maxAmmo));
    if (distance < 0) {
      throw new WeaponException("Distance must be greater than or equal to 0!");
    }

    if (distance > maxRange) {
      damage = 0;
    }
    if (currentAmmo > 0) {
      currentAmmo--;
    }
    return Double.valueOf(Math.floor(damage)).intValue();
  }

  @Override
  public String toString() {

    return "PlasmaCannon";
  }
}
