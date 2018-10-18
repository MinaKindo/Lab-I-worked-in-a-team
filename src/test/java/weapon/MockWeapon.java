package weapon;

import exceptions.WeaponException;

public class MockWeapon extends GenericWeapon {

  private int damage = 10;
  
  /**
   * @author Nate Bream
   */
  public MockWeapon() {
    super();
  }

  @Override
  public void updateTime(int time) {
    
  }

  @Override
  public int fire(int distance) throws WeaponException {
    if (currentAmmo > 0 && distance >= 0 && distance <= maxRange && shotsLeft > 0) {
      currentAmmo--;
      return damage;
    }
    return 0;
  }

  @Override
  public String toString() {
    return "MockWeapon";
  }
}
