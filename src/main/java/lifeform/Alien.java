package lifeform;

import exceptions.RecoveryRateException;
import gameplay.TimerObserver;
import recovery.RecoveryBehavior;
import recovery.RecoveryNone;

public class Alien extends LifeForm implements TimerObserver {

  private int maxLifePoints;
  RecoveryBehavior rb;
  static RecoveryBehavior nr = new RecoveryNone();
  int recoveryRate;
  int myTurn;

  public Alien(String name, int maxLife) throws RecoveryRateException {

    this(name, maxLife, nr);
  }

  /**
   * constructor for Alien
   * 
   * @param name
   * @param maxLife
   * @param rbEntered
   * @throws RecoveryRateException
   */
  public Alien(String name, int maxLife, RecoveryBehavior rbEntered) throws RecoveryRateException {

    super(name, maxLife);
    rb = rbEntered;

    myName = name;
    this.maxLifePoints = maxLife;
    attackStrength = 10;
  }

  /**
   * constructor for aliens with recovery rate
   * 
   * @param name
   * @param maxLife
   * @param rbEntered
   * @param recoveryRate
   * @throws RecoveryRateException
   */
  public Alien(String name, int maxLife, RecoveryBehavior rbEntered, int recoveryRate) 
      throws RecoveryRateException {

    super(name, maxLife);
    rb = rbEntered;

    myName = name;
    this.maxLifePoints = maxLife;
    attackStrength = 10;
    this.recoveryRate = recoveryRate;
    if (recoveryRate == 0) {
      rb = nr;
    }
    if (recoveryRate < 0) {
      throw new RecoveryRateException("Can't have negative Recovery rate!");
    }
  }

  /**
   * sets current life
   * 
   * @param life
   */
  public void setCurrentLifePoints(int life) {

    if (life > maxLifePoints) {
      System.out.println("Can't set life greater than max life!");
      currentLifePoints = maxLifePoints;
      return;
    }
    currentLifePoints = life;
  }

  public int getMaxLifePoints() {

    return maxLifePoints;
  }

  public int getRecoveryRate() {
    return recoveryRate;
  }

  public void recover() {
    currentLifePoints = rb.calculateRecovery(currentLifePoints, maxLifePoints);
  }

  @Override
  public void updateTime(int time) {
    myTurn = time;
    if (recoveryRate == 0) {
      return;
    }
    if (myTurn % recoveryRate == 0) {
      recover();
    }
  }

}
