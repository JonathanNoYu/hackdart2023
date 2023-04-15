package model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import javafx.scene.control.TextField;

public class TaxModel implements ITaxModel {
  final private int inputCount;
  private int filledInputCount;
  private final Random rand;
  private boolean poppedUp;
  private final String[] diaries = new String[]{"Diary1"};
  private final int[] diary1 = new int[]{2,10203,6,0,4,3,1,0,3,6,3,2};
  private final HashMap<String, int[]> scale = new HashMap<>();

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
    scale.put("Diary1",diary1);
  }

  @Override
  public void generateDocs() {
    // length of array is total possible inputs
    int arraylength = this.inputCount;

    // creating array with that length
    String[] answerArray = new String[arraylength];


    // document 1 generation - No Need
    // document 2 generation - No Need

    // document 3 generation (goods amount)
    String[] documentThree = new String[6];
    documentThree[0] = String.valueOf(rand.nextInt(201) + 100);
    documentThree[1] = String.valueOf(rand.nextInt(301) + 200);
    documentThree[2] = String.valueOf(rand.nextInt(501) + 500);
    documentThree[3] = String.valueOf(rand.nextInt(1001) + 500);
    documentThree[4] = String.valueOf(rand.nextInt(2001) + 1000);
    documentThree[5] = String.valueOf(rand.nextInt(3001) + 2000);

    // document 4 generation (prize winnings)
    float[][] documentFour = new float[8][8];
    float[] array2dint = new float[8];
    float[] array2dfloat = new float[8];

    // 8 ints between 100 and 1000
    for (int i = 0; i < array2dint.length; i++) {
      array2dint[i] = rand.nextInt(901) + 100;
    }

    // 8 floats 0-1
    for (int i = 0; i < array2dfloat.length; i++) {
      array2dfloat[i] = rand.nextFloat();
    }

    //sorting arrays
    Arrays.sort(array2dint);
    Arrays.sort(array2dfloat);

    //creating 8 by 8 array
    for (int i = 0; i<array2dint.length; i++){
      for (int j = 0; j < array2dfloat.length; i++){
        documentFour[i][j] = array2dint[i] * array2dfloat[j];
      }
    }

    // document 5 generation
    int[] document5 = new int[3];
    for (int i = 0; i < 3; i++){
      document5[i] = rand.nextInt(1001) + 9000;
    }

    // document 6 generation
    int[] document6 = new int[3];
    for (int i = 0; i < 3; i++){
      document6[i] = rand.nextInt(1001) + 9000;
    }

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
    if (!poppedUp) {
      this.renderDoc("");
    }
  };
}
