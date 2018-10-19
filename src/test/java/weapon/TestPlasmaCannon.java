package weapon;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.WeaponException;

public class TestPlasmaCannon {

  /**
   * Kamrin Langan
   */

  /**
   * tests that plasma cannon does appropriate damage at certain distances
   * 
   * @throws WeaponException
   */
  @Test
  public void testPlasmaCannon() throws WeaponException {

    PlasmaCannon pc = new PlasmaCannon();

    assertEquals(50, pc.fire(15));
    pc.shotsLeft = 1;
    assertEquals(37, pc.fire(10));
    pc.shotsLeft = 1;
    assertEquals(0, pc.fire(55));
  }

}
