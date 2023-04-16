package controller;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.ITaxModel;
import view.ITaxView;

public class TaxController implements Feature {

  final ITaxModel model;
  final ITaxView view;

  public TaxController(ITaxModel model, ITaxView view) {
    if (model == null || view == null) {
      throw new IllegalArgumentException("Cannot have null view or model");
    }
    this.model = model;
    this.view = view;
  }

  @Override
  public void popUpDoc(String doc) {
    this.model.renderDoc(doc);
  }

  @Override
  public void setToFilled(int count) {
    this.model.setFillCount(count);
    switch (count) {
      case 1:
        this.model.popAllDocs();
        break;
      case 4:
        this.view.renderBackground("toad");
        break;
      case 8:
        this.view.renderBackground("wario");
        break;
    }
  }

  @Override
  public void checkAnswers() {
    int inputCount = this.view.getInputCount();
    TextField input;
    boolean accumulator = true;
    for(int i = 0; i < inputCount; i++) {
      input = this.view.getTextField(i);
      try {
        accumulator = accumulator && this.model.checkInput(this.view.getTextFromField(input, i), i);
      } catch (IllegalArgumentException e) {
        accumulator = false;
      }
    }
    this.view.gameOver(accumulator);
  }

  @Override
  public void start() {
    this.model.start();
  }

  @Override
  public void addSubmit(Button button, Feature feature) {
    this.model.addSubmit(button, feature);
  }


}
