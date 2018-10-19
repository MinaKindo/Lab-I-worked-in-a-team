package weapon;

import exceptions.WeaponException;

public class Pistol extends GenericWeapon {
  
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
    shotsLeft = rateOfFire;
    
  }

  @Override
  public int fire(int distance) throws WeaponException {
    double damage;
    if (distance < 0) {
      throw new WeaponException("Distance must be greater than or equal to 0!");
    }
    if (distance > maxRange || currentAmmo == 0) {
      damage = 0;
      currentAmmo--;
    }
    else {
      damage = baseDamage * (((double)maxRange - distance + 5)/(double)maxRange); 
      damage = (Math.floor(damage));
      currentAmmo--;
    }
    return (int) damage;
  }
  

  @Override
  public String toString() {
    return "Pistol";
  }
  

}
