package lifeform;

import weapon.Weapon;

/**
 * Keeps track of the information associated with a simple life form. Also
 * provides the functionality related to the life form.
 */
public abstract class LifeForm {

  protected String myName;
  protected int currentLifePoints;
  protected int attackStrength;
  protected Weapon weapon;

  /**
   * Creates an instance
   * @param name the name of the life form
   * @param points the current starting life points of the life form
   */
  public LifeForm(String name, int points) {
    myName = name;
    currentLifePoints = points;
    attackStrength = 1;
  }
  
  /**
   * constructor for lifeforms with attack
   * @param name
   * @param points
   * @param attack
   */
  public LifeForm(String name, int points, int attack)  {
    myName = name;
    currentLifePoints = points;
    attackStrength = attack;
    
  }

  /**
   * @return the name of the life form
   */

  public String getName() {
    return myName;
  }

  /**
   * @return amount of current life points the life form has.
   */
  public int getCurrentLifePoints() {
    return currentLifePoints;
  }

  /**
   * reduces life points from life form, not below 0.
   */
  public void takeHit(int damage) {

    if (this.currentLifePoints - damage <= 0) {

      currentLifePoints = 0;
      System.out.println("LifeForm is dead!");
    } else {
      this.currentLifePoints = currentLifePoints - damage;
    }
  }
  
  public int getAttackStrength()  {
    return attackStrength;
  }
  
  /**
   * attack method for lifeforms to attack other lifeforms
   * @param opponent
   */
  public void attack(LifeForm opponent) {
    
    if (currentLifePoints == 0) {
      System.out.println("Can't attack when dead!");
      return;
    }
    opponent.takeHit(attackStrength);
  }

  public boolean pickUpWeapon(Weapon weapon) {
    boolean status = false;
    if (hasWeapon() == false) {
      this.weapon = weapon;
      status = true;
    }    
    return status;
  }
  
  public boolean hasWeapon() {
    // TODO Auto-generated method stub
    return false;
  }

  public Weapon dropWeapon() {
    return weapon;  
  }
}
