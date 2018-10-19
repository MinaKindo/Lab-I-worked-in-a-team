package weapon;

import exceptions.WeaponException;

public class PowerBooster extends Attachment {
  
  public PowerBooster(Weapon baseWeapon)  {
    base = baseWeapon;
    System.out.println("PowerBooster Added!");
  }

  @Override
  public void updateTime(int time) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public int fire(int distance) throws WeaponException {
    double powerBoosterDamage = Double.valueOf(1.0 + 
        (Double.valueOf(base.getCurrentAmmo())/Double.valueOf(base.getMaxAmmo())));
    return Double.valueOf(base.fire(distance) * powerBoosterDamage).intValue();
  }
  
  @Override
  public String toString()  {
    
    return base.toString() + " , PowerBooster";
  }

}
