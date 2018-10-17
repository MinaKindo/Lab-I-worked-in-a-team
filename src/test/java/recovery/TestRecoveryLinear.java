package recovery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRecoveryLinear {

  @Test
  public void noRecoveryWhenNotHurt() {

    RecoveryLinear r1 = new RecoveryLinear(3);
    int maxLifePts = 30;
    int result = r1.calculateRecovery(maxLifePts, maxLifePts);
    assertEquals(maxLifePts, result);
  }

  @Test
  public void recoverWhenHurt() {

    RecoveryLinear r1 = new RecoveryLinear(5);
    int maxLifePts = 30;
    int currentLifePts = 20;
    int result = r1.calculateRecovery(currentLifePts, maxLifePts);
    assertEquals(currentLifePts + 5, result);
  }

  @Test
  public void onlyHurtsLittle() {

    RecoveryLinear r1 = new RecoveryLinear(5);
    int maxLifePts = 30;
    int currentLifePts = 28;
    int result = r1.calculateRecovery(currentLifePts, maxLifePts);
    assertEquals(maxLifePts, result);
  }

  @Test
  public void noRecoveryWhenDead() {

    RecoveryLinear r1 = new RecoveryLinear(5);
    int maxLifePts = 30;
    int currentLifePts = 0;
    int result = r1.calculateRecovery(currentLifePts, maxLifePts);
    assertEquals(0, result);
  }
}
