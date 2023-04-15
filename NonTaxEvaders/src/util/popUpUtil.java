package util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class popUpUtil {
  /**
   * Sets up a simple alert Dialogue that is shown and waited
   *
   * @param at      is the alert type that will show
   * @param title   is the title of the window/alert
   * @param header  is the header message which usually is null
   * @param message is the message you want to tell the user
   * @return the Alert just in case some changes are wanted.
   */
  public static Alert alertDialogue(AlertType at, String title, String header, String message) {
    Alert dialogue = new Alert(at);
    dialogue.setWidth(200);
    dialogue.setTitle(title);
    dialogue.setHeaderText(header);
    dialogue.setContentText(message);
    return dialogue;
  }

  /**
   * Renders an informative message to the user
   *
   * @param title   is the title of the window/alert
   * @param header  is the header message which usually is null
   * @param message is the message you want to tell the user
   * @return the Alert just in case some changes are wanted.
   */
  public static Alert renderMessage(String title, String header, String message) {
    return alertDialogue(AlertType.INFORMATION, title, header, message);
  }

  /**
   * Renders an error message to the user
   *
   * @param message is the error message, usually the message of an exception
   * @return the Alert just in case some changes are wanted.
   */
  public static Alert renderError(String message) {
    return alertDialogue(AlertType.ERROR, "Error!", null, message);
  }

  /**
   * Renders a warning message to the user, similar to the render error however with a warning sign
   *
   * @param message is the warning message, usually the message of an exception like the
   * @return the Alert just in case some changes are wanted.
   */
  public static Alert renderWarning(String message) {
    return alertDialogue(AlertType.WARNING, "Warning!", null, message);
  }
}
