package weapon;

import exceptions.WeaponException;

public class Stabilizer extends Attachment {
  
  public Stabilizer(Weapon baseWeapon)  {
    base = baseWeapon;
    System.out.println("Stabilizer added!");
  }

  @Override
  public void updateTime(int time) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public int fire(int distance) throws WeaponException {
    if (base.getCurrentAmmo() == 0) {
      base.reload();
    }
    return Double.valueOf(base.fire(distance) * 1.25).intValue();
  }
  
  @Override
  public String toString()  {
    
    return base.toString() + " , Stabilizer";
  }
}
