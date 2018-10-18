package weapon;

import exceptions.WeaponException;

public abstract class GenericWeapon implements Weapon {

  protected int baseDamage;
  protected int currentAmmo;
  protected int maxAmmo;
  protected int maxRange;
  protected int rateOfFire;
  protected int shotsLeft;

  public GenericWeapon() {
    System.out.println("Generic Weapon Created!");
  }

  public abstract int fire(int distance) throws WeaponException;
<<<<<<< HEAD
  
=======

>>>>>>> c6ea2de074dc2c9dfbbe7fe29c12b133a41a45de
  @Override
  public abstract String toString();

  public int getNumAttachments() {
    return 0;
  }

  public void reload() {
    currentAmmo = maxAmmo;
  }

  public int getBaseDamage() {
    return baseDamage;
  }

  public int getMaxRange() {
    return maxRange;
  }

  public int getRateOfFire() {
    return rateOfFire;
  }

  public int getMaxAmmo() {
    return maxAmmo;
  }

  public int getCurrentAmmo() {
    return currentAmmo;
  }

  public int getShotsLeft() {
    return shotsLeft;
  }

}
