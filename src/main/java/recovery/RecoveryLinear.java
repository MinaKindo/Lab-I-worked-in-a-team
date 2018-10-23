package recovery;

public class RecoveryLinear implements RecoveryBehavior {

  private int recoveryStep;

  /**
   * constructor for linear recovery
   * 
   * @param recoveryAmount
   */
  public RecoveryLinear(int recoveryAmount) {

    recoveryStep = recoveryAmount;
    System.out.println("Linear Recovery behavior implemented.");
  }

  @Override
  public int calculateRecovery(int currentLife, int maxLife) {
    if (currentLife + recoveryStep >= maxLife) {

      return maxLife;
    }

    if (currentLife == 0) {

      System.out.println("Can't recover when dead!");
      return 0;
    }

    return currentLife + recoveryStep;
  }

}
