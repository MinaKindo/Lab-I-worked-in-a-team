package weapon;

import exceptions.WeaponException;

public class MockWeapon extends GenericWeapon {

  private int damage;

  /**
   * @author Nate Bream
   */
  public MockWeapon() {
    baseDamage = 5;
    maxRange = 20;
    rateOfFire = 3;
    maxAmmo = 3;
    currentAmmo = 3;
    shotsLeft = rateOfFire;
  }

  @Override
  public void updateTime(int time) {
    shotsLeft = rateOfFire;
  }

  @Override
  public int fire(int distance) throws WeaponException {
    if (distance < 0) {
      throw new WeaponException("Range cannot be less than zero.");
    } else if (shotsLeft <= 0) {
      throw new WeaponException("Weapon is out of shots this round!");
    } else if (currentAmmo > 0 && distance >= 0 && distance <= maxRange) {
      currentAmmo--;
      shotsLeft--;
      return damage;
    } else {
      currentAmmo--;
      shotsLeft--;
      return 0;
    }
  }

  @Override
  public String toString() {
    return "MockWeapon";
  }
}
