package weapon;

import exceptions.AttachmentException;
import exceptions.WeaponException;

public class Stabilizer extends Attachment {
  
  public Stabilizer(Weapon baseWeapon) throws AttachmentException  {
   /** if (getNumAttachments() >= 2) {
      throw new AttachmentException("Weapon already has 2 attachments!");
    }*/
    base = baseWeapon;
    System.out.println("Stabilizer added!");
  }

  @Override
  public void updateTime(int time) {
    base.updateTime(time); 
  }

  @Override
  public int fire(int distance) throws WeaponException {
    if (base.getCurrentAmmo() <= 0) {
      base.reload();
    }
    return Double.valueOf(base.fire(distance) * 1.25).intValue();
  }
  
  @Override
  public String toString()  {
    
    return base.toString() + " , Stabilizer";
  }
}
