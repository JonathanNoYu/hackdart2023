package model;

import controller.Feature;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public interface ITaxModel {

  /**
   * Generates the new documents based on the seed;
   */
  void generateDocs();

  /**
   * Checks the text-field given to see if it matches up with the rng answer.
   * @param input is the string input text-field
   * @param id is the number that is associated with which correct answer is.
   * @return boolean to show if the input is correct or not.
   */
  boolean checkInput(TextField input, int id);

  /**
   * Checks the input given to see if it matches up with the rng answer.
   * @param input is the string input that needs
   * @param id is the number that is associated with which correct answer is.
   * @return boolean to show if the input is correct or not.
   */
  boolean checkInput(String input, int id);

  /**
   *  Sets the fill count of the model to the given count
   * @param count is the number of already filled inputs
   */
  void setFillCount(int count);

  /**
   * Renders the given document and will have it popup
   * @param Doc is the document name with the file extension on it.
   */
  void renderDoc(String Doc);

  /**
   * Pop up all the documents
   */
  void popAllDocs();

  /**
   * Starts by rendering the diary and the rules
   */
  void start();

  /**
   * Adds the submit button to the popUp class and closes windows if you submit
   * @param button is the submit button
   * @param feature is the controller used to help easily add action events to buttons
   */
  void addSubmit(Button button, Feature feature);
}
