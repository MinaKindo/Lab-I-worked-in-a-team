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
      shotsLeft = rateOfFire;  

  }


  @Override  
  public int fire(int distance) throws WeaponException {
    int damage = 0;
    
    if(distance < 0) {    // Cannot fire negative distance
      throw new WeaponException("Distance must be greater than or equal to 0!");
    }
    
    if(currentAmmo <= 0) {  
      currentAmmo = 0;
      return 0;
    }
    
    if(shotsLeft <= 0) {
      shotsLeft = 0;
      return 0;
    }
    
    if(distance > maxRange) { // No damage if past maxRange
      currentAmmo--;
      shotsLeft--;
      return 0;}
    
    damage = (int) (Math.floor(baseDamage * ((Double.valueOf(maxRange) - distance + 5)/Double.valueOf(maxRange))));
    currentAmmo--;
    shotsLeft--;
    return damage;
    
  }
  

  @Override
  public String toString() {
    return "Pistol";
  }
  

  

}
