package controller;

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
    if (count >= 5) {
      this.model.popAllDocs();
    }
  }

  @Override
  public void checkAnswers() {
    int inputCount = this.view.getInputCount();
    TextField input;
    for(int i = 0; i < inputCount; i++) {
      input = this.view.getTextField(i);
      this.model.checkInput(input, i);
    }
  }
}
