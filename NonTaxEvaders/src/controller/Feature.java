package controller;

public interface Feature {
  /**
   *
   */
  void process();

  /**
   *
   */
  void setView();

  /**
   * If We have enough time we will add
   *
   */
  void processFlag(String flag);

}
