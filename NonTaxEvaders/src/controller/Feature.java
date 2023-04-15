package controller;

public interface Feature {
  /**
   * General process of the view and model states, should be called
   */
  void process();

  /**
   * Sets the current window to this view
   */
  void setView();

  /**
   *  Creates a new popup with
   */
  void popUpImage(String imageName);

  /**
   * Processes a flag, most likely used to create a popup.
   *
   */
  void processFlag(String flag);

}
