package controller;

import java.lang.module.FindException;
import javafx.scene.control.Button;

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

  /**
   * Starts some popups/information to let the user fill out some stuff or the game
   */
  void start();

  /**
   * Adds the submit button to the model class and closes windows if you submit
   * @param button is the submit button
   * @param feature is the controller used to help easily add action events to buttons
   */
  void addSubmit(Button button, Feature feature);
}
