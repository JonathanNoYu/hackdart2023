package model;

import javafx.scene.control.TextField;

public interface ITaxModel {

  /**
   * Generates the new documents based on the seed;
   */
  void generateDocs();

  /**
   * Checks the input given to see if it matches up with the rng answer.
   * @param input is the string input that needs
   * @param id is the number that is associated with which correct answer is.
   */
  void checkInput(TextField input, int id);

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
}
