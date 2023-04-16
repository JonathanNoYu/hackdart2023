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
    System.out.println("called popUpDoc from Controller with name " + doc);
  }

  @Override
  public void setToFilled(int count) {
    this.model.setFillCount(count);
    if (count >= 5) {
      this.model.popAllDocs();
      System.out.println("Called popAllDocs() in Controller");
    }
    System.out.println("Set the Model fill count to " + count);
  }

  @Override
  public void checkAnswers() {
    int inputCount = this.view.getInputCount();
    TextField input;
    boolean accumulator = true;
    for(int i = 0; i < inputCount; i++) {
      input = this.view.getTextField(i);
      accumulator = accumulator && this.model.checkInput(input, i);
      try {
        System.out.print("Acc: " + accumulator + "  Model Check ID:" + i + "Input: "
            + this.view.getTextFromField(input, i) + System.lineSeparator());
      } catch (IllegalArgumentException e) {
        System.out.print("Acc: " + accumulator + "  Model Check ID:" + i + "Input: "
            + e.getMessage() + System.lineSeparator());
      }
    }
  }

  @Override
  public void start() {
    this.model.start();
  }


}
