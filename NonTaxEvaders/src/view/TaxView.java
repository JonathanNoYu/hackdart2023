package view;

import controller.Feature;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import org.w3c.dom.Text;
import util.popUpUtil;

public class TaxView implements ITaxView{
  private final BorderPane mainPanel;
  private final Button submit = new Button("Submit");
  private final HashMap<Integer, TextField> textFieldMap = new HashMap<Integer, TextField>();
  private final int[] fillArr = new int[18];
  private final String css;
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
  TextField txf18;
  public TaxView() {
    this.css = Objects.requireNonNull(getClass().getResource("/style/mainStyles.css"))
        .toExternalForm();
    this.mainPanel = new BorderPane();
    this.mainPanel.setPrefHeight(900);
    this.mainPanel.setPrefWidth(1800);
    this.mainPanel.getStylesheets().add(this.css);
    this.mainPanel.setId("main");

    VBox leftPane = new VBox();
    leftPane.setPrefHeight(900);
    leftPane.setPrefWidth(600);

    VBox middlePane = new VBox();
    middlePane.setPrefHeight(900);
    middlePane.setPrefWidth(600);


    VBox rightPane = new VBox();
    rightPane.setPrefHeight(900);
    rightPane.setPrefWidth(600);

    this.mainPanel.setLeft(leftPane);
    this.mainPanel.setCenter(middlePane);
    this.mainPanel.setRight(rightPane);


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
    this.txf17 = new TextField("NUMBER OF COINS");
    this.txf18 = new TextField("TOTAL TAX OWED");

    textFieldMap.put(0, this.txf1);
    textFieldMap.put(1, this.txf2);
    textFieldMap.put(2, this.txf3);
    textFieldMap.put(3, this.txf4);
    textFieldMap.put(4, this.txf5);
    textFieldMap.put(5, this.txf6);
    textFieldMap.put(6, this.txf7);
    textFieldMap.put(7, this.txf8);
    textFieldMap.put(8, this.txf9);
    textFieldMap.put(9, this.txf10);
    textFieldMap.put(10, this.txf11);
    textFieldMap.put(11, this.txf12);
    textFieldMap.put(12, this.txf13);
    textFieldMap.put(13, this.txf14);
    textFieldMap.put(14, this.txf15);
    textFieldMap.put(15, this.txf16);
    textFieldMap.put(16, this.txf17);
    textFieldMap.put(17, this.txf18);

    for (int i = 0; i < this.textFieldMap.size(); i++) {
      middlePane.getChildren().add(this.textFieldMap.get(i));
    }

    middlePane.getChildren().add(this.submit);
  }

  @Override
  public void addFeatures(Feature feature) {
    for (Map.Entry<Integer, TextField> entry : this.textFieldMap.entrySet()) {
      int id = entry.getKey();
      TextField txf = entry.getValue();
      txf.setPromptText(txf.getText());
      txf.setFocusTraversable(false);
      txf.setText("");
      txf.setOnMouseClicked((evt) -> {
        for (Map.Entry<Integer, TextField> entry2 : this.textFieldMap.entrySet()) {
          int id2 = entry2.getKey();
          TextField txf2 = entry2.getValue();
          if (this.checkFilled(txf2, id2)) {
            fillArr[id2] = 1;
          } else {
            fillArr[id2] = 0;
          }
        }
        System.out.println("TextField Printed ID:" + id + " fillArr sum:" + this.sumFilledArr());
        feature.setToFilled(this.sumFilledArr());
      });
    }

    this.submit.setOnAction((evt) -> {
      feature.checkAnswers();
      System.out.println("Submit Pressed" + System.lineSeparator());
    });
  }

  /**
   * Sums the total filled text-fields
   * @return an int of the sum of the array
   */
  private int sumFilledArr() {
    int sum = 0;
    for (int i = 0; i < fillArr.length; i++) {
      sum += fillArr[i];
    }
    return sum;
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
  public boolean checkFilled(TextField textField, int id) {
    String str = textField.getText();
    return str != "";
  }

  @Override
  public String getTextFromField(TextField textField, int ind) {
    String str = textField.getText();
    if (str == "") {
      throw new IllegalArgumentException("Empty");
    }
    if (ind >= 2) { // 0 or 1 is first and last name, aka Strings
      try {
        Integer.parseInt(str);
      } catch (NumberFormatException e) {
        throw new IllegalArgumentException("Invalid answer, got: " + str + ", instead of a number");
      }
    }
    return str;
  }

  @Override
  public TextField getTextField(int id) throws IllegalArgumentException {
    return this.textFieldMap.get(id);
  }

  @Override
  public int getInputCount() {
    return this.textFieldMap.size();
  }

  @Override
  public Parent getView() {
    return this.mainPanel;
  }
}
