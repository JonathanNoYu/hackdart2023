package controller;

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
  public void process() {

  }

  @Override
  public void setView() {

  }

  @Override
  public void popUpImage(String imageName) {

  }

  @Override
  public void processFlag(String flag) {

  }
}
