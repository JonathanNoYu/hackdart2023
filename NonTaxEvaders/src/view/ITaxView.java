package view;

import controller.Feature;
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
   * Gets the text from a textField and resets the text to an empty string.
   *
   * @param textField is the text-field we want to get the text of
   * @param id is the identification number of the text-field
   * @return the string value for the text-field
   * @throw a exception if the text-field is not filled out correctly
   *
   */
  String getTextFromField(TextField textField, int id) throws IllegalArgumentException;

  /**
   * Getter method to retrieve the amount of text-fields that need to be filled out.
   * @return the number of inputs the user has to deal with
   */
  int getInputCount();

  /**
   * Exits the view properly.
   */
  void end();
}
