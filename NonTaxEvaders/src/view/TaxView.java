package view;

import controller.Feature;
import java.util.HashMap;
import java.util.Map.Entry;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import util.popUpUtil;

public class TaxView implements ITaxView{
  private final BorderPane mainPanel;
  private final Button submit = new Button("Submit");
  private final HashMap<Integer, TextField> textFieldMap = new HashMap<Integer, TextField>();
  private final int[] fillArr = new int[17];
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
    this.mainPanel = new BorderPane();
    this.mainPanel.setPrefHeight(900);
    this.mainPanel.setPrefWidth(1800);

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

    for (int i = 0; i < this.textFieldMap.size(); i++) {
      this.mainPanel.getChildren().add(this.textFieldMap.get(i));
    }

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
  }

  @Override
  public void addFeatures(Feature feature) {
    this.txf1.setOnAction((evt) -> {
      if (this.checkFilled(this.txf1, 0)) {
        fillArr[0] = 1;
      } else {
        fillArr[0] = 0;
      }
      feature.setToFilled(this.sumFilledArr());
    });

    this.txf2.setOnAction((evt) -> {
      if (this.checkFilled(this.txf2, 1)) {
        fillArr[1] = 1;
      } else {
        fillArr[1] = 0;
      }
      feature.setToFilled(this.sumFilledArr());
    });

    this.txf3.setOnAction((evt) -> {
      if (this.checkFilled(this.txf3, 2)) {
        fillArr[2] = 1;
      } else {
        fillArr[2] = 0;
      }
      feature.setToFilled(this.sumFilledArr());
    });

    this.txf4.setOnAction((evt) -> {
      if (this.checkFilled(this.txf4, 3)) {
        fillArr[3] = 1;
      } else {
        fillArr[3] = 0;
      }
      feature.setToFilled(this.sumFilledArr());
    });

    this.txf5.setOnAction((evt) -> {
      if (this.checkFilled(this.txf5, 4)) {
        fillArr[4] = 1;
      } else {
        fillArr[4] = 0;
      }
      feature.setToFilled(this.sumFilledArr());
    });

    this.txf6.setOnAction((evt) -> {
      if (this.checkFilled(this.txf6, 5)) {
        fillArr[5] = 1;
      } else {
        fillArr[5] = 0;
      }
      feature.setToFilled(this.sumFilledArr());
    });

    this.txf7.setOnAction((evt) -> {
      if (this.checkFilled(this.txf7, 6)) {
        fillArr[6] = 1;
      } else {
        fillArr[6] = 0;
      }
      feature.setToFilled(this.sumFilledArr());
    });

    this.txf8.setOnAction((evt) -> {
      if (this.checkFilled(this.txf8, 7)) {
        fillArr[7] = 1;
      } else {
        fillArr[7] = 0;
      }
      feature.setToFilled(this.sumFilledArr());
    });

    this.txf9.setOnAction((evt) -> {
      if (this.checkFilled(this.txf9, 8)) {
        fillArr[8] = 1;
      } else {
        fillArr[8] = 0;
      }
      feature.setToFilled(this.sumFilledArr());
    });

    this.txf10.setOnAction((evt) -> {
      if (this.checkFilled(this.txf10, 9)) {
        fillArr[9] = 1;
      } else {
        fillArr[9] = 0;
      }
      feature.setToFilled(this.sumFilledArr());
    });

    this.txf11.setOnAction((evt) -> {
      if (this.checkFilled(this.txf11, 10)) {
        fillArr[10] = 1;
      } else {
        fillArr[10] = 0;
      }
      feature.setToFilled(this.sumFilledArr());
    });

    this.txf12.setOnAction((evt) -> {
      if (this.checkFilled(this.txf12, 11)) {
        fillArr[11] = 1;
      } else {
        fillArr[11] = 0;
      }
      feature.setToFilled(this.sumFilledArr());
    });

    this.txf13.setOnAction((evt) -> {
      if (this.checkFilled(this.txf13, 12)) {
        fillArr[12] = 1;
      } else {
        fillArr[12] = 0;
      }
      feature.setToFilled(this.sumFilledArr());
    });

    this.txf14.setOnAction((evt) -> {
      if (this.checkFilled(this.txf14, 13)) {
        fillArr[13] = 1;
      } else {
        fillArr[13] = 0;
      }
      feature.setToFilled(this.sumFilledArr());
    });

    this.txf15.setOnAction((evt) -> {
      if (this.checkFilled(this.txf15, 14)) {
        fillArr[14] = 1;
      } else {
        fillArr[14] = 0;
      }
      feature.setToFilled(this.sumFilledArr());
    });

    this.txf16.setOnAction((evt) -> {
      if (this.checkFilled(this.txf16, 15)) {
        fillArr[15] = 1;
      } else {
        fillArr[15] = 0;
      }
      feature.setToFilled(this.sumFilledArr());
    });

    this.txf17.setOnAction((evt) -> {
      if (this.checkFilled(this.txf17, 16)) {
        fillArr[16] = 1;
      } else {
        fillArr[16] = 0;
      }
      feature.setToFilled(this.sumFilledArr());
    });

    this.submit.setOnAction((evt) -> {
      feature.checkAnswers();
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
    try {
      this.getTextFromField(textField, id);
      return true;
    } catch (IllegalArgumentException e) {
      return false;
    }
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
