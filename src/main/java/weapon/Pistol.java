package weapon;

import exceptions.WeaponException;
/**
 * 
 * @author Aminata
 *
 */

public class Pistol extends GenericWeapon {
  public int myTime = 0; 
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
    myTime = time;
    //to make sure there is enough ammo
    if (currentAmmo > rateOfFire) {
      shotsLeft = rateOfFire;
    } else {
      shotsLeft = currentAmmo;
    }
     
  }

  @Override
  public int fire(int distance) throws WeaponException {
    int damage = 0;
    //Cannot fire a negative distance
    if (distance < 0 ) {
      throw new WeaponException("Distance must be greater than or equal to 0!");
    }
    
    //There is enough ammo but distance is unreachable
    //Can fire but will just lose ammo
    if (distance > maxRange) {
      damage = 0;
      //bothCurrent Ammo and Shots left should decrease
      currentAmmo--;
      shotsLeft--;
    } else if (canFire()) {
      damage = (int) (Math.floor(baseDamage * ((Double.valueOf(maxRange) - distance + 5)/Double.valueOf(maxRange))));
      currentAmmo--;
      shotsLeft--;
    } else {
      damage = 0;
    }
    return damage;
  }
  

  @Override
  public String toString() {
    return "Pistol";
  }
  
  public boolean canFire() {
    boolean status = false;
    if (currentAmmo > 0) {
      if (shotsLeft > 0) {
        status = true;
      }
    }
    return status;
  }
  

}
