package weapon;

import exceptions.WeaponException;

/**
 * class for weapon of type pistol
 * @author Aminata
 *
 */
public class Pistol extends GenericWeapon {
  
  /**
   * constructor for pistol
   */
  public Pistol() {
    maxAmmo = 10;
    currentAmmo = maxAmmo;
    rateOfFire = 2;
    maxRange = 50;
    baseDamage = 10;
    shotsLeft = rateOfFire;
  }

  @Override
  public void updateTime(int time) {
    shotsLeft = rateOfFire;
  }

  @Override
  public int fire(int distance) throws WeaponException {
    
    if (distance < 0) { // Cannot fire negative distance
      throw new WeaponException("Distance must be greater than or equal to 0!");
    }

    if (currentAmmo <= 0) {
      currentAmmo = 0;
      return 0;
    }

    if (shotsLeft <= 0) {
      shotsLeft = 0;
      return 0;
    }

    if (distance > maxRange) { // No damage if past maxRange
      currentAmmo--;
      shotsLeft--;
      return 0;
    }
    double damage = (Double.valueOf(baseDamage)
        * (Double.valueOf(maxRange) - Double.valueOf(distance) 
            + Double.valueOf(10))) / Double.valueOf(maxRange);
    currentAmmo--;
    shotsLeft--;
    return Double.valueOf(Math.floor(damage)).intValue();

  }

  @Override
  public String toString() {
    return "Pistol";
  }

}
