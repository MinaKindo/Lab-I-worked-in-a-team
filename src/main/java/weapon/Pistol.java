package weapon;

import exceptions.WeaponException;

public class Pistol extends GenericWeapon {
  
  public Pistol() {
    maxAmmo = 10;
    currentAmmo = 10;
    rateOfFire = 2;
    maxRange = 25;
    baseDamage = 10;
  }
  
  @Override
  public void updateTime(int time) {
    // TODO Auto-generated method stub
    
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
    // TODO Auto-generated method stub
    return null;
  }
  

}
