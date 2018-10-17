package environment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lifeform.LifeForm;
import lifeform.MockLifeForm;

/**
 * The test cases for the Cell class
 *
 */

public class TestCell {

  /**
   * At initialization, the Cell should be empty and not contain a LifeForm.
   */

  @Test
  public void testCellInitialization() {
    Cell cell = new Cell();
    assertNull(cell.getLifeForm());
  }

  /**
   * Checks to see if we change the LifeForm held by the Cell that getLifeForm
   * properly responds to this change.
   */
  @Test
  public void testAddLifeForm() {

    LifeForm bob = new MockLifeForm("Bob", 40, 0);
    LifeForm fred = new MockLifeForm("Fred", 40, 0);
    Cell cell = new Cell();

    // The cell is empty so this should work.

    boolean success = cell.addLifeForm(bob);
    assertTrue(success);
    assertEquals(bob, cell.getLifeForm());

    // The cell is not empty so this should fail.

    success = cell.addLifeForm(fred);
    assertFalse(success);
    assertEquals(bob, cell.getLifeForm());

  }

  /**
   * Checks to see if the LifeForm is removed from the Cell.
   */
  @Test
  public void testRemoveLifeForm() {

    LifeForm bob = new MockLifeForm("Bob", 40, 0);
    Cell cell = new Cell();

    // Make sure LifeForm is added to the Cell.

    cell.addLifeForm(bob);
    assertEquals(bob, cell.getLifeForm());

    // Should remove LifeForm from cell and set to null.

    cell.removeLifeForm();

    assertEquals(null, cell.getLifeForm());
  }
}
