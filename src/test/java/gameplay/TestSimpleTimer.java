package gameplay;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestSimpleTimer {

  @Test
  public void testSimpleTimerInit() {

    SimpleTimer timer = new SimpleTimer();

    assertEquals(0, timer.getRound());
    assertEquals(0, timer.getNumObservers());
  }

  @Test
  public void testAddMockObservers() {

    SimpleTimer timer = new SimpleTimer();
    MockSimpleTimerObserver o1 = new MockSimpleTimerObserver();

    timer.addTimeObserver(o1);
    assertEquals(1, timer.getNumObservers());
  }

  @Test
  public void testRemoveMockObservers() {

    SimpleTimer timer = new SimpleTimer();
    MockSimpleTimerObserver o1 = new MockSimpleTimerObserver();
    MockSimpleTimerObserver o2 = new MockSimpleTimerObserver();

    timer.addTimeObserver(o1);
    timer.addTimeObserver(o2);

    timer.removeTimeObserver(o1);
    assertEquals(1, timer.getNumObservers());
  }

  @Test
  public void testTimeChangedWithoutObservers() {

    SimpleTimer timer = new SimpleTimer();

    timer.timeChanged();
    assertEquals(1, timer.getRound());
  }

  @Test
  public void testTimeChangedWithObservers() {

    SimpleTimer timer = new SimpleTimer();
    MockSimpleTimerObserver o1 = new MockSimpleTimerObserver();
    MockSimpleTimerObserver o2 = new MockSimpleTimerObserver();

    timer.addTimeObserver(o1);
    timer.addTimeObserver(o2);
    timer.timeChanged();

    assertEquals(1, timer.getRound());
  }

  @Test
  public void testSimpleTimerAsThread() throws InterruptedException {

    SimpleTimer st = new SimpleTimer(1000);
    st.start();
    Thread.sleep(250); // So we are 1/4th second difference
    for (int x = 0; x < 5; x++) {
      assertEquals(x, st.getRound()); // assumes round starts at 0
      Thread.sleep(1000); // wait for next time change
    }
  }
}
