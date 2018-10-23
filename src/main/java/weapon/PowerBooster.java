package weapon;

import exceptions.AttachmentException;
import exceptions.WeaponException;

/**
 * class for powerbooster attachment
 * @author Michael Mitchell
 *
 */
public class PowerBooster extends Attachment {

  /**
   * constructs a powerbooster that wraps the weapon
   * @param baseWeapon
   * @throws AttachmentException
   */
  public PowerBooster(Weapon baseWeapon) throws AttachmentException {
    base = baseWeapon;
    if (getNumAttachments() > 2) {
      throw new AttachmentException("Weapon already has 2 attachments!");
    }
    System.out.println("PowerBooster Added!");
  }

  @Override
  public int fire(int distance) throws WeaponException {
    double powerBoosterDamage = Double
        .valueOf(1.0 + (Double.valueOf(base.getCurrentAmmo()) / Double.valueOf(base.getMaxAmmo())));
    return Double.valueOf(base.fire(distance) * powerBoosterDamage).intValue();
  }

  @Override
  public String toString() {
    return base.toString() + " +PowerBooster";
  }

  @Override
  public void updateTime(int time) {
    base.updateTime(time);
  }

}
