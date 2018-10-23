package weapon;

import exceptions.WeaponException;

public class PlasmaCannon extends GenericWeapon {

  /**
   * constructor for pistol
   */
  public PlasmaCannon() {
    maxAmmo = 4;
    currentAmmo = maxAmmo;
    baseDamage = 50;
    rateOfFire = 1;
    maxRange = 40;
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

    if (distance < 0) {
      throw new WeaponException("Distance must be greater than or equal to 0!");
    }

    if (shotsLeft <= 0) {
      shotsLeft = 0;
      return 0;
    }

    if (currentAmmo <= 0) {
      currentAmmo = 0;
      return 0;
    }

    if (distance > maxRange) {
      currentAmmo--;
      shotsLeft--;
      return 0;
    }
    
    double damage = Double.valueOf(baseDamage) * (Double.valueOf(currentAmmo) 
        / Double.valueOf(maxAmmo));
    currentAmmo--;
    shotsLeft--;
    return Double.valueOf(Math.floor(damage)).intValue();
  }

  @Override
  public String toString() {

    return "PlasmaCannon";
  }
}
