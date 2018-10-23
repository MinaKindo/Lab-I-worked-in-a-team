package weapon;

import exceptions.WeaponException;

public class ChainGun extends GenericWeapon {

  /**
   * Kamrin Langan
   */
  public ChainGun() {
    baseDamage = 15;
    maxRange = 60;
    maxAmmo = 40;
    currentAmmo = maxAmmo;
    rateOfFire = 4;
    shotsLeft = rateOfFire;
  }
  
  /**
   * @author Nate Bream
   */
  @Override
  public void updateTime(int time) {
    shotsLeft = rateOfFire;
  }

  @Override
  public int fire(int distance) throws WeaponException {
    double damage = 0.0;
    if (distance < 0) {
      throw new WeaponException("Distance must be greater than 0!");
    }
    
    if (shotsLeft <= 0) {
      shotsLeft = 0;
      return 0;
     } 
    
    if (currentAmmo <= 0) {
      currentAmmo = 0;
      return 0;
     }
    
    if (distance > maxRange)  {
      currentAmmo--;
      shotsLeft--;
      return 0;
    }
    
    damage = baseDamage * (Double.valueOf(distance) / Double.valueOf(maxRange));
    shotsLeft--;
    currentAmmo--;

    return Double.valueOf(Math.floor(damage)).intValue();
  }

  @Override
  public String toString() {

    return "ChainGun";
  }

}
