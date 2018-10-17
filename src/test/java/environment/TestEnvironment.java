package environment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lifeform.LifeForm;
import lifeform.MockLifeForm;

/**
 * Tests the functionality of our Environment class.
 */
public class TestEnvironment {

  /**
   * Tests a basic one cell environment
   */
  @Test
  public void testEnvironmentInitialization() {

    Environment cells = new Environment(1, 1);
    assertNull(cells.getLifeForm(0, 0));
  }

  /**
   * Tests initialization of an environment with one lifeform
   */
  @Test
  public void testOneEntityEnvironment() {

    Environment cells = new Environment(2, 3);
    LifeForm bob = new MockLifeForm("Bob", 20, 0);
    LifeForm fred = new MockLifeForm("Fred", 50, 0);

    boolean success = cells.addLifeForm(bob, 0, 1);

    // The cell is empty so this should work.

    assertEquals(bob, cells.getLifeForm(0, 1));
    assertTrue(success);

    // The cell is not empty so this should fail.

    success = cells.addLifeForm(fred, 0, 1);

    assertFalse(success);
    assertEquals(bob, cells.getLifeForm(0, 1));
  }

  /**
   * tests removing a lifeform from the environment
   */
  @Test
  public void testRemoveLifeFormFromEnvironment() {

    Environment cells = new Environment(2, 3);
    LifeForm bob = new MockLifeForm("Bob", 20, 0);

    cells.addLifeForm(bob, 0, 1);
    assertEquals(bob, cells.getLifeForm(0, 1));

    cells.removeLifeForm(0, 1);

    // Environment at selected Cell should be null.
    assertNull(cells.getLifeForm(0, 1));
  }

  /**
   * tests border cases for adding a lifeform
   */
  @Test
  public void testBorderCases() {

    Environment cells = new Environment(5, 6);
    LifeForm bob = new MockLifeForm("bob", 20, 0);
    LifeForm fred = new MockLifeForm("fred", 20, 0);

    // adds lifeforms to the outside cells of the environment
    boolean bobSuccess = cells.addLifeForm(bob, 4, 5);
    boolean fredSuccess = cells.addLifeForm(fred, 0, 0);

    assertTrue(bobSuccess);
    assertTrue(fredSuccess);

    assertEquals(bob, cells.getLifeForm(4, 5));
    assertEquals(fred, cells.getLifeForm(0, 0));

    // tries to overwrite lifeforms already added; should be false
    bobSuccess = cells.addLifeForm(fred, 4, 5);
    fredSuccess = cells.addLifeForm(bob, 0, 0);

    assertFalse(bobSuccess);
    assertFalse(fredSuccess);
  }
}
