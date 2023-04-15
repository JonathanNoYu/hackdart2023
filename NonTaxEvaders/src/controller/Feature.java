package controller;

public interface Feature {
  /**
   *  Creates a new popup with
   */
  void popUpDoc(String imageName);

  /**
   * Sets the count of filled inputs in the model.
   *
   * @param count is the number of filled text-fields
   */
  void setToFilled(int count);

  /**
   * Checks if all the inputs are right and if all of them are filled out.
   * If they are not all filled out, render warning to say it is
   */
  void checkAnswers();
}
