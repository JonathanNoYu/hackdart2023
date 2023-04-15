package model;

public interface ITaxModel {

  /**
   * Generates the new documents based on the seed;
   */
  void generateDocs();

  /**
   * Checks the input given to see if it matches up with the rng answer.
   * @param input is the string input that needs
   */
  void checkInput(String input);

  /**
   *  Add one to the counter of Filled out inputs.
   */
  void addToFillCount();
}
