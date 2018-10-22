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
    maxRange = 25;
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
    int damage;
    //Cannot fire a negative distance
    if (distance < 0 ) {
      throw new WeaponException("Distance must be greater than or equal to 0!");
    }
    //weapon exception should be thrown if there is no more ammo
    if (currentAmmo == 0) {
      throw new WeaponException("No more ammunition!");
    }
    
    //also weapon exception should be thrown if there is no more shotsLeft
    if (shotsLeft == 0) {
      throw new WeaponException("No more shots!");
    }
    
    //There is enough ammo but distance is unreachable
    //Can fire but will just lose ammo
    if (distance > maxRange) {
      damage = 0;
      //bothCurrent Ammo and Shots left should decrease
      currentAmmo--;
      shotsLeft--;
    }
    else {
      damage = (int) (Math.floor(baseDamage * ((Double.valueOf(maxRange) - distance + 5)/Double.valueOf(maxRange))));
      currentAmmo--;
      shotsLeft--;
    }
    return damage;
  }
  

  @Override
  public String toString() {
    return "Pistol";
  }
  

}
