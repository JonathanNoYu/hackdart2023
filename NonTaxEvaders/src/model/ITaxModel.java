package model;

public interface ITaxModel {
  /**
   * Loads an image from the res file and will most likely have a pop-up show up with the image.
   * @throws IllegalArgumentException if name is not an existing file name
   */
  void loadImage(String name) throws IllegalArgumentException;

  /**
   * Sets a flag in the model storage.
   * @param flag a string name for a certain thing to happen
   */
  void addFlag(String flag);
}
