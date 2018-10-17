package recovery;

public class RecoveryNone implements RecoveryBehavior {

  public RecoveryNone() {
    System.out.println("No Recovery behavior implemented.");
  }

  @Override
  public int calculateRecovery(int currentLife, int maxLife) {

    if (currentLife == 0) {

      System.out.println("Can't recover when dead!");
      return 0;
    }
    return currentLife;
  }
}
