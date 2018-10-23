package weapon;

import exceptions.AttachmentException;
import exceptions.WeaponException;

public class PowerBooster extends Attachment {
  
  public PowerBooster(Weapon baseWeapon) throws AttachmentException  {
   /** if (getNumAttachments() >= 2) {
      throw new AttachmentException("Weapon already has 2 attachments!");
    }*/
    base = baseWeapon;
    System.out.println("PowerBooster Added!");
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



  @Override
  public void updateTime(int time) {
    base.updateTime(time);
  }

}
