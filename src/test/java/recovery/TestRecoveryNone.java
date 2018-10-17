package recovery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRecoveryNone {

  @Test
  public void testStaysAtMax() {

    RecoveryNone recovery = new RecoveryNone();
    assertEquals(70, recovery.calculateRecovery(70, 70));
    assertEquals(30, recovery.calculateRecovery(30, 70));
  }

}
