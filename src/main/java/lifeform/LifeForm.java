package lifeform;

import exceptions.WeaponException;
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
   * @author Conner
   * attack method for lifeforms to attack other lifeforms
   * @param opponent
   * @param distance 
   * @throws WeaponException 
   */
  public void attack(LifeForm opponent, int distance) throws WeaponException {
    
    if (currentLifePoints == 0) {
      System.out.println("Can't attack when dead!");
      return;
    }
    
    if(hasWeapon() && weapon.getCurrentAmmo() > 0) {
      opponent.takeHit(weapon.fire(distance));
      return;
    }else if(distance <= 5) {
      opponent.takeHit(attackStrength);
      return;
    }else if(distance > 5){
      opponent.takeHit(0);
      return;
    }
    
  }
  
  

  /**
   * @author Aminata
   * @param weapon
   * @return true if LifeForm pick a weapon
   */
  public boolean pickUpWeapon(Weapon weapon) {
    boolean status = false;
    if (hasWeapon() == false) {
      this.weapon = weapon;
      status = true;
    }    
    return status;
  }
  
  /**
   * @author Aminata
   * @return true if LifeForm holds a weapon
   */
  public boolean hasWeapon() {
    boolean status = false;
    if (this.weapon != null) {
      status = true;
    }
    return status;
  }

  /**
   * @author Aminata
   */
  public Weapon dropWeapon() {
    this.weapon = null;
    return weapon;  
  }
}
