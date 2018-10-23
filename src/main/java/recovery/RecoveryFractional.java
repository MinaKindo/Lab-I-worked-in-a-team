package recovery;

public class RecoveryFractional implements RecoveryBehavior {

  private double percentRecovery;

  public RecoveryFractional(double percent) {

    percentRecovery = percent;
  }

  @Override
  public int calculateRecovery(int currentLife, int maxLife) {

    double lifeIncrease = currentLife * percentRecovery;
    int life = (int) (lifeIncrease + currentLife);

    if (life >= maxLife) {
      return maxLife;
    }

    if (currentLife == 0) {

      System.out.println("Can't recover when dead!");
      return 0;
    }

    if (currentLife % lifeIncrease == 0) {
      return life;
    }
    return life + 1;
  }

}
