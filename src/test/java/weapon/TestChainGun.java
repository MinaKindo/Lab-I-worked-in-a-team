package weapon;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.WeaponException;

public class TestChainGun {

  /**
   * Kamrin Langan
   * 
   */

  /**
   * tests that chain gun does appropriate damage at certain distances
   * 
   * @throws WeaponException
   */
  @Test
  public void testDamageAtADistance() throws WeaponException {

    ChainGun cg = new ChainGun();

    assertEquals(3, cg.fire(15));
    assertEquals(5, cg.fire(20));
    assertEquals(13, cg.fire(55));
  }

}
