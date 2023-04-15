package model;

import com.sun.jdi.connect.TransportTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

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
  public void checkInput(String input) {

  }

  @Override
  public void addToFillCount() {

  }
}
