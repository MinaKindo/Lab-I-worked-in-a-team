package recovery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRecoveryFractional {

  @Test
  public void testNotHurt() {
    
    RecoveryFractional rf = new RecoveryFractional(0.1);
    int maxLifePts = 100;
    int result = rf.calculateRecovery(maxLifePts, maxLifePts);
    assertEquals(maxLifePts, result);
  }
  
  @Test
  public void testLittleHurt()  {
    
    RecoveryFractional rf = new RecoveryFractional(0.1);
    int maxLifePts = 100;
    int currentLifePts = 90;
    int result = rf.calculateRecovery(currentLifePts, maxLifePts);
    assertEquals(99, result);
  }

  @Test
  public void noRecoveryDead() {

    RecoveryFractional rf = new RecoveryFractional(0.1);
    int maxLifePts = 30;
    int currentLifePts = 0;
    int result = rf.calculateRecovery(currentLifePts, maxLifePts);
    assertEquals(0, result);
  }
  
  @Test
  public void testRoundUp() {
    
    RecoveryFractional rf = new RecoveryFractional(0.1);
    int maxLifePts = 120;
    int currentLifePts = 93;
    int result = rf.calculateRecovery(currentLifePts, maxLifePts);
    assertEquals(103, result);
  }
}
