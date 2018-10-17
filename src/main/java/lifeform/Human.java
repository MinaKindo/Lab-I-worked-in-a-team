package lifeform;

public class Human extends LifeForm {

  private int armorPoints;

  /**
   * constructor for Humans
   * @param name
   * @param life
   * @param armor
   */
  public Human(String name, int life, int armor) {

    super(name, life);

    myName = name;
    currentLifePoints = life;
    setArmorPoints(armor);
    attackStrength = 5;
  }

  public int getArmorPoints() {

    return armorPoints;
  }

  /**
   * sets armor points
   * @param points
   */
  public void setArmorPoints(int points) {

    if (points <= 0) {
      this.armorPoints = 0;
    } else {
      this.armorPoints = points;
    }
  }
  
  @Override
  public void takeHit(int damage) {
    
    if (this.currentLifePoints - damage + armorPoints <= 0) {

      currentLifePoints = 0;
      System.out.println("LifeForm is dead!");
      return;
    }
    if (damage <= armorPoints)  {
      return;
    } else {
      this.currentLifePoints = currentLifePoints - damage + armorPoints;
    }
  }

}
