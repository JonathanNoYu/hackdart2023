package model;

import java.util.Random;
import javafx.scene.control.TextField;

public class TaxModel implements ITaxModel {
  final private int inputCount;
  private int filledInputCount;
  private final Random rand;

  public TaxModel(int inputCount) {
    this(inputCount, 0, new Random());
  }

  public TaxModel(int inputCount, int filledOutSoFar) {
    this(inputCount, filledOutSoFar, new Random());
  }

  public TaxModel(int inputCount, int filledInputCount, Random seed) {
    this.inputCount = inputCount;
    this.filledInputCount = filledInputCount;
    this.rand = seed;
  }

  @Override
  public void generateDocs() {

  }

  @Override
  public void checkInput(TextField input, int id) {

  }

  @Override
  public void setFillCount(int count) {
    this.filledInputCount = count;
  }

  @Override
  public void renderDoc(String Doc) {

  }

  @Override
  public void popAllDocs() {

  };
}
