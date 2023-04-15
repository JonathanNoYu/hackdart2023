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
   * @return the string value for the text-field
   */
  String getTextFromField(TextField textField);
}
