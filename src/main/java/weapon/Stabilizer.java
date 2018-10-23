package weapon;

import exceptions.AttachmentException;
import exceptions.WeaponException;

/**
 * class for stabilizer attachment
 * @author Michael Mitchell
 *
 */
public class Stabilizer extends Attachment {

  /**
   * constructs a stabilizer that wraps the weapon
   * @param baseWeapon
   * @throws AttachmentException
   */
  public Stabilizer(Weapon baseWeapon) throws AttachmentException {
    base = baseWeapon;
    if (getNumAttachments() > 2) {
      throw new AttachmentException("Weapon already has 2 attachments!");
    }
    System.out.println("Stabilizer added!");
  }

  @Override
  public void updateTime(int time) {
    base.updateTime(time);
  }

  @Override
  public int fire(int distance) throws WeaponException {
    double damage = Double.valueOf(base.fire(distance) * 1.25).intValue();
    if (base.getCurrentAmmo() <= 0) {
      base.reload();
    }
    return Double.valueOf(damage).intValue();
  }

  @Override
  public String toString() {

    return base.toString() + " +Stabilizer";
  }
}
