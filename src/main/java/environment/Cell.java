package environment;

import lifeform.LifeForm;

/**
 * A cell that can hold a LifeForm.
 *
 */
public class Cell {

  private LifeForm entity;

  /**
   * Tries to add the LifeForm to the Cell. Will not add if a LifeForm is already
   * present.
   * 
   * @param entity
   *          the life form held in the cell.
   * @return true if the LifeFOrm was added to the Cell, false otherwise.
   */
  boolean addLifeForm(LifeForm entity) {
    if (this.entity != null) {
      return false;
    } else {
      this.entity = entity;
      return true;
    }
  }

  /**
   * Removes the LifeForm from the Cell and resets to null.
   */
  public void removeLifeForm() {
    this.entity = null;
  }

  /**
   * @return the LifeForm in this cell
   */
  public LifeForm getLifeForm() {
    return this.entity;
  }
}
