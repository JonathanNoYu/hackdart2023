package model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Random;
import javafx.scene.control.TextField;
import javax.swing.Popup;

public class TaxModel implements ITaxModel {
  final private int inputCount;
  final private String[] answerArray;
  private int filledInputCount;
  private final Random rand;
  private boolean poppedUp;
  private final String[] diaries = new String[]{"diary-1"};
  private final HashMap<String, Integer> diaryPages = new HashMap<>();
                                      //Answer     //scale 2w/d3  //2d arr //
  private final int[] diary1 = new int[]{2,10203,   6,0,4,3,1,0,   3, 5, 6, 1,      3,2};
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
    scale.put("diary-1",diary1);
    diaryPages.put("diary-1", 8);
    this.answerArray = new String[this.inputCount];
    this.answerArray[0] = "T. Yoshisaur";
    this.answerArray[1] = "Munchakoopas";
    this.answerArray[2] = "Y";
    this.answerArray[3] = String.valueOf(this.diary1[0]);
    this.answerArray[16] = String.valueOf(this.diary1[1]);
  }

  @Override
  public void generateDocs() {

    // document 3 generation (goods amount)
    int[] document3 = new int[6];
    document3[0] = rand.nextInt(201) + 100;
    document3[1] = rand.nextInt(301) + 200;
    document3[2] = rand.nextInt(501) + 500;
    document3[3] = rand.nextInt(1001) + 500;
    document3[4] = rand.nextInt(2001) + 1000;
    document3[5] = rand.nextInt(3001) + 2000;

    // document 4 generation (prize winnings)
    // Mushroom, Shell, Flower,
    float[][] document4 = new float[8][8];
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
    for (int i = 0; i < array2dfloat.length; i++){
      for (int j = 0; j < array2dint.length; i++){
        document4[i][j] = array2dint[i] * array2dfloat[j];
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

    this.answerArray[4] = String.valueOf(document3[0] * diary1[2]);
    this.answerArray[5] = String.valueOf(document3[1] * diary1[3]);
    this.answerArray[6] = String.valueOf(document3[2] * diary1[4]);
    this.answerArray[7] = String.valueOf(document3[3] * diary1[5]);
    this.answerArray[8] = String.valueOf(document3[4] * diary1[6]);
    this.answerArray[9] = String.valueOf(document3[5] * diary1[7]);

    int sum = 0;
    for (int i = 4; i < 10; i++) {
      sum += Integer.parseInt(this.answerArray[i]);
    }
    this.answerArray[10] = String.valueOf(sum);

    this.answerArray[11] = String.valueOf(document4[diary1[7]][diary1[8]] + document4[diary1[9]][diary1[10]]);

    int sum2 = 0;
    for (int k : document5) {
      sum2 += k;
    }
    this.answerArray[12] = String.valueOf(sum2);

    int sum3 = 0;
    for (int j : document6) {
      sum3 += j;
    }
    this.answerArray[13] = String.valueOf(sum3);

    this.answerArray[14] = String.valueOf(this.diary1[2] + sum2 + sum3);
    this.answerArray[15] = String.valueOf(this.diary1[0] * 25000);
    int sum4 = ((this.diary1[2] + sum2 + sum3) - (this.diary1[0] * 25000) + this.diary1[1]);
    this.answerArray[17] = String.valueOf(sum4 * 0.1);
  }

  @Override
  public boolean checkInput(TextField input, int id) {
    String str = input.getText();
    return (Objects.equals(str, this.answerArray[id]));
  }

  @Override
  public void setFillCount(int count) {
    this.filledInputCount = count;
  }

  @Override
  public void renderDoc(String Doc) {
    for(Map.Entry<String, Integer> entry : this.diaryPages.entrySet()) {
      if (entry.getKey() == Doc) {
        String[] args = new String[]{entry.getValue() + "",Doc};
        RunPopUp.main(args);
      }
    }
  }

  @Override
  public void popAllDocs() {
    if (!poppedUp) {
      this.renderDoc("diary-1");
      System.out.println("Pop All Docs Called in Model with Diary1");
      poppedUp = true;
    }
  };
}
