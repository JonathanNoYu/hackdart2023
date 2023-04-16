package view;

import controller.Feature;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public interface ITaxView {

  /**
   * Adds in the features/controller to give request to.
   *
   * @param feature is the controller/feature used to request changes
   */
  void addFeatures(Feature feature);

  /**
   * Renders an error if something goes wrong and an error is given in the code.
   *
   * @param message is the error message
   */
  void renderError(String message);

  /**
   * Renders a warning if something is slightly off or unwanted gets inputted.
   *
   * @param message is the error message
   */
  void renderWarning(String message);

  /**
   * Checks if the text field is a filled out with valid answer(s).
   *
   * @param textField is the text-field we want to get the text of
   * @param id is the identification number of the text-field !! indexed at 0 !!
   * @return true if the text-field is filled
   *
   */
  boolean checkFilled(TextField textField, int id);

  /**
   * Gets the text from a textFieldMap and resets the text to an empty string.
   *
   * @param textField is the text-field we want to get the text of
   * @param id is the identification number of the text-field !! indexed at 0 !!
   * @return the string value for the text-field
   * @throw a exception if the text-field is not filled out correctly
   *
   */
  String getTextFromField(TextField textField, int id) throws IllegalArgumentException;

  /**
   * Gets the text-field of the id
   * @param id is identification number !! indexed at 0 !!
   * @return the text-field from the corresponding id
   * @throws IllegalArgumentException
   */
  TextField getTextField(int id) throws IllegalArgumentException;

  /**
   * Getter method to retrieve the amount of text-fields that need to be filled out.
   * @return the number of inputs the user has to deal with
   */
  int getInputCount();

  /**
   * Exits the view properly.
   */
  void end();

  /**
   * Gets the parent panel of the view
   * @return the parent panel
   */
  Parent getView();

  /**
   * Ends the game and depending on the boolean will show a different win or lose screen.
   * @param win is the boolean that tells us if you win or lose.
   */
  void gameOver(boolean win);

  /**
   * Sets the main background to a new one!
   * @param background
   */
  void renderBackground(String background);
}
