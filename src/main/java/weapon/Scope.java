package weapon;

import exceptions.AttachmentException;
import exceptions.WeaponException;

/**
 * class for scope attachment
 * @author Michael Mitchell
 *
 */
public class Scope extends Attachment {

  /**
   * constructs a scope that wraps the weapon
   * @param baseWeapon
   * @throws AttachmentException
   */
  public Scope(Weapon baseWeapon) throws AttachmentException {
    base = baseWeapon;
    if (getNumAttachments() > 2) {
      throw new AttachmentException("Weapon already has 2 attachments!");
    }
    System.out.println("Scope added!");
  }

  public int getMaxRange() {
    return base.getMaxRange() + 10;
  }

  @Override
  public void updateTime(int time) {
    base.updateTime(time);
  }

  @Override
  public int fire(int distance) throws WeaponException {

    if (base.getMaxRange() < distance && distance <= getMaxRange()) {
      return base.fire(base.getMaxRange()) + 5;
    }
    double addedScopeDamage = 1.0 + (Double.valueOf(getMaxRange()) - distance) 
        / Double.valueOf(getMaxRange());

    return Double.valueOf(base.fire(distance) * addedScopeDamage).intValue();
  }

  @Override
  public String toString() {

    return base.toString() + " +Scope";
  }

}
