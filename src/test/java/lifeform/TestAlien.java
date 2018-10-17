package lifeform;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.RecoveryRateException;
import gameplay.SimpleTimer;
import recovery.RecoveryBehavior;
import recovery.RecoveryLinear;
import recovery.RecoveryNone;

public class TestAlien {

  private RecoveryBehavior rb = new RecoveryLinear(5);
  private RecoveryBehavior nr = new RecoveryNone();

  @Test
  public void testAlienInit() throws RecoveryRateException {

    Alien greenMan = new Alien("greenMan", 50);
    greenMan.setCurrentLifePoints(40);
    assertEquals("greenMan", greenMan.getName());
    assertEquals(40, greenMan.getCurrentLifePoints());
    assertEquals(50, greenMan.getMaxLifePoints());
    assertEquals(10, greenMan.getAttackStrength());
  }

  @Test
  public void testLinRecovery() throws RecoveryRateException {

    Alien blueMan = new Alien("blueMan", 50, rb);
    blueMan.setCurrentLifePoints(200);
    blueMan.takeHit(10);
    blueMan.recover();
    assertEquals(45, blueMan.getCurrentLifePoints());
    assertEquals(50, blueMan.getMaxLifePoints());
  }

  @Test
  public void testNoRecovery() throws RecoveryRateException {

    Alien redMan = new Alien("redMan", 50, nr);
    redMan.setCurrentLifePoints(100);
    redMan.takeHit(45);
    redMan.recover();
    assertEquals(5, redMan.getCurrentLifePoints());
    assertEquals(50, redMan.getMaxLifePoints());

  }

  @Test
  public void testAddRecoveryRate() throws RecoveryRateException {

    Alien blueMan = new Alien("blueMan", 100, rb, 5);
    assertEquals(5, blueMan.getRecoveryRate());
  }
  
  @Test
  public void testNoRecoveryRate() throws RecoveryRateException {
    
    Alien blueMan = new Alien("blueMan", 100, rb, 0);
    SimpleTimer timer = new SimpleTimer();
    timer.addTimeObserver(blueMan);
    
    blueMan.takeHit(25);
    timer.timeChanged();
    
    assertEquals(75, blueMan.getCurrentLifePoints());
  }

  @Test
  public void testRecoveryRateCheck() throws RecoveryRateException {

    Alien blueMan = new Alien("blueMan", 100, rb, 2);
    SimpleTimer timer = new SimpleTimer();
    timer.addTimeObserver(blueMan);

    blueMan.takeHit(20);

    timer.timeChanged();
    assertEquals(80, blueMan.getCurrentLifePoints());

    timer.timeChanged();
    assertEquals(85, blueMan.getCurrentLifePoints());
  }

  @Test
  public void testRecoveryRateTwo() throws RecoveryRateException {

    Alien blueMan = new Alien("blueMan", 100, rb, 3);
    SimpleTimer timer = new SimpleTimer();
    timer.addTimeObserver(blueMan);

    blueMan.takeHit(20);

    timer.timeChanged();
    assertEquals(80, blueMan.getCurrentLifePoints());

    timer.timeChanged();
    assertEquals(80, blueMan.getCurrentLifePoints());

    timer.timeChanged();
    assertEquals(85, blueMan.getCurrentLifePoints());
  }

  @Test
  public void testThrowsException() {

    try {
      Alien blueMan = new Alien("blueMan", 100, rb, -5);
    } catch (RecoveryRateException e) {
      System.out.println("Negative Recovery Rate!");
    }
  }
  
  @Test
  public void testTrackTime() throws RecoveryRateException {
    
    Alien blueMan = new Alien("blueMan", 100, rb, 3);
    SimpleTimer timer = new SimpleTimer();
    timer.addTimeObserver(blueMan);
    
    blueMan.takeHit(5);
    timer.timeChanged();
    assertEquals(1, timer.getRound());
  }

  @Test
  public void testRemoveObserver() throws RecoveryRateException {
    
    Alien blueMan = new Alien("blueMan", 100, rb, 1);
    SimpleTimer timer = new SimpleTimer();
    timer.addTimeObserver(blueMan);
    
    blueMan.takeHit(5);
    timer.removeTimeObserver(blueMan);
    
    timer.timeChanged();
    assertEquals(95, blueMan.getCurrentLifePoints());
    
  }
}
