package weapon;

import exceptions.WeaponException;
import gameplay.TimerObserver;

public interface Weapon extends TimerObserver {
  /**
   * Fire the weapon once, this reduces the current ammo by one bullet
   * @param distance
   *              the distance to the target, for now, if the target is in range, 
   *              it will be hit
   * @return
   *            the damage the weapon deals to the target, the target's armor may 
   *            mitigate this damage. The damage will be zero if a) the target is out
   *             of range (the ammo is still used in this case) OR b) the weapon was 
   *             out of ammo (ammo cannot be negative)  
   */
  public int fire(int distance) throws WeaponException;
  
  public int getBaseDamage();
  
  public int getCurrentAmmo();
  
  public int getMaxAmmo();
  
  public int getMaxRange();
  
  public int getNumAttachments();
  
  public int getRateOfFire();
  
  public int getShotsLeft();
  
  /**
   * reload the clip to full capacity. For now, we assume a limitless supply of clips. 
   * This may be refactored in the future to take ammo reserves into account.
   */
  public void reload();
  
  /**
   * Displays the Weapon and any attachments.
   */
  public String toString();

}
