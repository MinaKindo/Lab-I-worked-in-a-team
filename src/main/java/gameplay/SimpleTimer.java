package gameplay;

import java.util.ArrayList;
import java.util.List;

public class SimpleTimer extends Thread implements Timer {

  private List<TimerObserver> theObservers = new ArrayList<TimerObserver>();
  private int round;
  private int sleepTime;

  public SimpleTimer() {
    round = 0;
  }

  public SimpleTimer(int sleep) {
    round = 0;
    sleepTime = sleep;
  }

  public void addTimeObserver(TimerObserver observer) {
    theObservers.add(observer);
  }

  public int getNumObservers() {
    return theObservers.size();
  }

  public int getRound() {
    return round;
  }

  public void removeTimeObserver(TimerObserver observer) {
    theObservers.remove(observer);
  }

  /**
   * run method for timer
   */
  public void run() {
    for (; round < 50; timeChanged()) {
      try {
        Thread.sleep(sleepTime);
      } catch (InterruptedException e) {
        System.out.println("Something interrupted time!");
      }
    }
  }

  public void timeChanged() {
    round = round + 1;
    theObservers.forEach(observer -> observer.updateTime(round));
  }
}
