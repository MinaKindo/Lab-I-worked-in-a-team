package environment;

import lifeform.LifeForm;
import environment.Cell;

/**
 * creates an environment that contains cells, which hold lifeforms
 */
public class Environment {

  /**
   * 2D array that contains cells for the environment
   */
  public Cell[][] cells;

  /**
   * @param row
   *          number of rows
   * @param col
   *          number of columns creates the environment
   */
  public Environment(int row, int col) {
    cells = new Cell[row][col];

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        cells[i][j] = new Cell();
      }
    }
  }

  boolean addLifeForm(LifeForm e, int row, int col) {
    if (cells[row][col].getLifeForm() != null) {
      return false;
    } else {
      cells[row][col].addLifeForm(e);
      return true;
    }
  }

  /**
   * @param row
   *          number of rows in environment
   * @param col
   *          number of columns in environment
   * @return the lifeform
   */
  public LifeForm getLifeForm(int row, int col) {

    return cells[row][col].getLifeForm();
  }

  void removeLifeForm(int row, int col) {

    cells[row][col].removeLifeForm();
  }
}