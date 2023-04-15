package view;

import controller.Feature;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;
import util.popUpUtil;

public class TaxView implements ITaxView{
  Button submit = new Button("Submit");
  TextField txf1;
  TextField txf2;
  TextField txf3;
  TextField txf4;
  TextField txf5;
  TextField txf6;
  TextField txf7;
  TextField txf8;
  TextField txf9;
  TextField txf10;
  TextField txf11;
  TextField txf12;
  TextField txf13;
  TextField txf14;
  TextField txf15;
  TextField txf16;
  TextField txf17;
  public TaxView() {
    this.txf1 = new TextField("FIRST NAME");
    this.txf2 = new TextField("LAST NAME");
    this.txf3 = new TextField("IS MARRIED?");
    this.txf4 = new TextField("NUMBER OF DEPENDENTS");
    this.txf5 = new TextField("MONEY FROM MUSHROOMS");
    this.txf6 = new TextField("MONEY FROM CAT BELLS");
    this.txf7 = new TextField("MONEY FROM STAR COINS");
    this.txf8 = new TextField("MONEY FROM POWER MOONS");
    this.txf9 = new TextField("MONEY FROM SUPER CROWNS");
    this.txf10 = new TextField("MONEY FROM 1-UPS");
    this.txf11 = new TextField("TOTAL MONEY FROM COMMON");
    this.txf12 = new TextField("MONEY FROM RACES");
    this.txf13 = new TextField("MONEY FROM ARTIFACTS");
    this.txf14 = new TextField("DECLARED MONEY FROM DAMAGES");
    this.txf15 = new TextField("GROSS");
    this.txf16 = new TextField("BENEFITS FROM DEPENDENCIES ");
    this.txf17 = new TextField("TOTAL TAX OWED");

  }

  @Override
  public void addFeatures(Feature feature) {

  }

  @Override
  public void end() {
    Platform.exit();
  }

  @Override
  public void renderError(String message) {
    popUpUtil.renderError(message).showAndWait();
  }

  @Override
  public void renderWarning(String message) {
    popUpUtil.renderWarning(message).showAndWait();
  }

  @Override
  public String getTextFromField(TextField textField, int ind) {
    String str = textField.getText();
    if (str == "") {
      throw new IllegalArgumentException("Empty");
    }
    if (ind >= 2) { // 1 or 2 is first and last name, aka Strings
      try {
        Integer.parseInt(str);
      } catch (NumberFormatException e) {
        throw new IllegalArgumentException("Invalid answer, got: " + str + ", instead of a number");
      }
    }
    textField.setText("");
    return str;
  }

  @Override
  public int getInputCount() {
    return 17;
  }
}
