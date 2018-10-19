package weapon;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.WeaponException;

public class TestPlasmaCannon {

  @Test
  public void testTwoDistances() throws WeaponException {
    PlasmaCannon pc = new PlasmaCannon();
    
    assertEquals(50, pc.fire(15));
    assertEquals(37, pc.fire(10));
  }

}
