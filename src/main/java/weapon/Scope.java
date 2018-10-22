package weapon;

import exceptions.WeaponException;

public class Scope extends Attachment {
  
  public Scope(Weapon baseWeapon) {
    base = baseWeapon;
    System.out.println("Scope added!");
  }
  
  
  public int getMaxRange()  {
    return base.getMaxRange() + 10;
  }

  @Override
  public void updateTime(int time) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public int fire(int distance) throws WeaponException {
    
    if (base.getMaxRange() < distance || distance <= getMaxRange()) {
      return base.fire(base.getMaxRange()) + 5;
    }
    double addedScopeDamage = 1.0 + 
        (Double.valueOf(getMaxRange()) - distance)/Double.valueOf(getMaxRange());
    
    return Double.valueOf(base.fire(distance) * addedScopeDamage).intValue();
  }
  
  @Override
  public String toString()  {
    
    return base.toString() + " , Scope";
  }

}
