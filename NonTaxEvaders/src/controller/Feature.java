package controller;

public interface Feature {
  /**
   *  Creates a new popup with
   */
  void popUpImage(String imageName);

  /**
   * Counts up in the model
   */
  void addToFilledInput();

  /**
   * Checks if all the inputs are right and if all of them are filled out.
   * If they are not all filled out, render warning to say it is 
   */
  void checkAnswers();
}
