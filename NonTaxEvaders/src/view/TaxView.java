package view;

import controller.Feature;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import util.popUpUtil;

public class TaxView implements ITaxView{
  private long start = System.currentTimeMillis();
  private final BorderPane mainPanel;
  private final Button submit = new Button("Submit");
  private final HashMap<Integer, TextField> textFieldMap = new HashMap<Integer, TextField>();
  private final HashMap<Integer, Label> captionMap = new HashMap<Integer, Label>();
  private final int[] fillArr = new int[18];
  private final HashMap<String, String> backgroundMap = new HashMap<>();
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
    backgroundMap.put("default",Objects.requireNonNull(getClass().getResource("/style/mainStyles.css"))
        .toExternalForm());
    backgroundMap.put("main",Objects.requireNonNull(getClass().getResource("/style/main_background.css"))
        .toExternalForm());
    backgroundMap.put("toad",Objects.requireNonNull(getClass().getResource("/style/toad_background.css"))
        .toExternalForm());
    backgroundMap.put("wario",Objects.requireNonNull(getClass().getResource("/style/wario_background.css"))
        .toExternalForm());
    this.mainPanel = new BorderPane();
    this.mainPanel.setPrefHeight(900);
    this.mainPanel.setPrefWidth(1800);
    this.mainPanel.getStylesheets().addAll(backgroundMap.get("default"),backgroundMap.get("main"));
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
    this.txt2 = new Label("Field A2");
    this.txt3 = new Label("Field A3");
    this.txt4 = new Label("Field A4");
    this.txt5 = new Label("Field B1");
    this.txt6 = new Label("Field B2");
    this.txt7 = new Label("Field B3");
    this.txt8 = new Label("Field B4");
    this.txt9 = new Label("Field B5");
    this.txt10 = new Label("Field B6");
    this.txt11 = new Label("Field B7");
    this.txt12 = new Label("Field C1");
    this.txt13 = new Label("Field C2");
    this.txt14 = new Label("Field D1");
    this.txt15 = new Label("Field D2");
    this.txt16 = new Label("Field D3");
    this.txt17 = new Label("Field D4");
    this.txt18 = new Label("Field D5");

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
        feature.setToFilled(this.sumFilledArr());
      });
    }

    this.submit.setOnAction((evt) -> {
      feature.checkAnswers();
    });

    Button fakeSubmit = new Button();
    fakeSubmit.onActionProperty().bindBidirectional(this.submit.onActionProperty());
    feature.addSubmit(fakeSubmit, feature);
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
    if (ind > 2) { // 0 or 1 is first and last name, aka Strings
      try {
        Integer.parseInt(str);
      } catch (NumberFormatException e) {
        throw new IllegalArgumentException("Invalid answer, got: " + str + ", instead of a number");
      }
    } else if (ind == 2 && str.toLowerCase().equals("y")
        || str.toLowerCase().equals("yes") || str.toLowerCase().equals("yeah")) {
      return "1";
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

  @Override
  public void gameOver(boolean win) {
    long end = System.currentTimeMillis();
    long time = end - start;
    String time_Taken = String.format("%d min, %d sec",
        TimeUnit.MILLISECONDS.toMinutes(time),
        TimeUnit.MILLISECONDS.toSeconds(time) -
            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(time))
    );
    this.mainPanel.getStylesheets().removeAll(this.mainPanel.getStylesheets());
    this.mainPanel.getChildren().removeAll(this.mainPanel.getChildren());
    VBox centerPane = new VBox();
    Label label = new Label("");
    Button exitButton = new Button("Exit");
    exitButton.setId("endButton");
    exitButton.setOnAction((evt) -> Platform.exit());
    centerPane.getChildren().addAll(label, exitButton);
    this.mainPanel.setCenter(centerPane);
    String css;
    if(win) {
      css = Objects.requireNonNull(getClass().getResource("/style/win.css"))
          .toExternalForm();
      label.setText("WOW, I didn't think you'll file your taxes correctly... Well done, You took " + time_Taken);
    } else {
      css = Objects.requireNonNull(getClass().getResource("/style/loss.css"))
          .toExternalForm();
      label.setText("Damn, it appears you just committed tax fraud. Your rights are now forfeit. Hand them over\nYou took " + time_Taken);
    }
    this.mainPanel.getStylesheets().add(css);
  }

  @Override
  public void renderBackground(String background) {
    for(Map.Entry<String, String> entry: backgroundMap.entrySet()) {
      if (Objects.equals(entry.getKey(), background)) {
        this.mainPanel.getStylesheets().remove(1);
        this.mainPanel.getStylesheets().add(entry.getValue());
        return;
      }
    }
  }
}
