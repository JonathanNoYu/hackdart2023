package view;

import controller.Feature;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import org.w3c.dom.Text;
import util.popUpUtil;

public class TaxView implements ITaxView{
  private final BorderPane mainPanel;
  private final Button submit = new Button("Submit");
  private final HashMap<Integer, TextField> textFieldMap = new HashMap<Integer, TextField>();
  private final HashMap<Integer, Label> captionMap = new HashMap<Integer, Label>();
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

  Label txt1;
  Label txt2;
  Label txt3;
  Label txt4;
  Label txt5;
  Label txt6;
  Label txt7;
  Label txt8;
  Label txt9;
  Label txt10;
  Label txt11;
  Label txt12;
  Label txt13;
  Label txt14;
  Label txt15;
  Label txt16;
  Label txt17;
  Label txt18;

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

    this.txt1 = new Label("Field A1");
    this.txt2 = new Label("Field A1");
    this.txt3 = new Label("Field A1");
    this.txt4 = new Label("Field A1");
    this.txt5 = new Label("Field A1");
    this.txt6 = new Label("Field A1");
    this.txt7 = new Label("Field A1");
    this.txt8 = new Label("Field A1");
    this.txt9 = new Label("Field A1");
    this.txt10 = new Label("Field A1");
    this.txt11 = new Label("Field A1");
    this.txt12 = new Label("Field A1");
    this.txt13 = new Label("Field A1");
    this.txt14 = new Label("Field A1");
    this.txt15 = new Label("Field A1");
    this.txt16 = new Label("Field A1");
    this.txt17 = new Label("Field A1");
    this.txt18 = new Label("Field A1");

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

    captionMap.put(0, this.txt1);
    captionMap.put(1, this.txt2);
    captionMap.put(2, this.txt3);
    captionMap.put(3, this.txt4);
    captionMap.put(4, this.txt5);
    captionMap.put(5, this.txt6);
    captionMap.put(6, this.txt7);
    captionMap.put(7, this.txt8);
    captionMap.put(8, this.txt9);
    captionMap.put(9, this.txt10);
    captionMap.put(10, this.txt11);
    captionMap.put(11, this.txt12);
    captionMap.put(12, this.txt13);
    captionMap.put(13, this.txt14);
    captionMap.put(14, this.txt15);
    captionMap.put(15, this.txt16);
    captionMap.put(16, this.txt17);
    captionMap.put(17, this.txt18);

    for (int i = 0; i < this.textFieldMap.size(); i++) {
      HBox formLine = new HBox();
      formLine.getChildren().addAll(this.captionMap.get(i), this.textFieldMap.get(i));
      formLine.setBackground(new Background(new BackgroundFill(Color.TAN,
              CornerRadii.EMPTY,
              Insets.EMPTY)));
      middlePane.getChildren().addAll(formLine);
    }

    middlePane.getChildren().add(this.submit);
    middlePane.setAlignment(Pos.CENTER);
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
