import controller.Feature;
import controller.TaxController;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.ITaxModel;
import model.TaxModel;
import view.ITaxView;
import view.TaxView;

public class NonTaxEvaders extends Application {

  public static void main(String[] args) {launch(args);}

  @Override
  public void start(Stage stage){
    // Start of full game MVC
    ITaxView view = new TaxView();
    ITaxModel model = new TaxModel(view.getInputCount());
    Feature controller = new TaxController(model, view);
    view.addFeatures(controller);
    stage.setTitle("NonTaxEvaders!");
    Scene game = new Scene(view.getView());

    // Start Scene with start button
    HBox start = new HBox();
    start.setId("START");
    start.getStylesheets().add("style/startingStyle.css");
    Button startButton = new Button("Start!");
    startButton.setId("startBut");
    Button exitButton = new Button("x");
    exitButton.setId("endBut");
    start.getChildren().addAll(startButton,exitButton);
    stage.setScene(new Scene(start));
    stage.initStyle(StageStyle.TRANSPARENT);
    // stage.getIcons().add(ImageUtil.LOGO);
    stage.setMaximized(true);
    stage.show();

    startButton.setOnAction((evt) -> {
      Stage newStage = new Stage();
      newStage.setMaximized(true);
      newStage.setScene(game);
      newStage.show();
      stage.close();
      delay(1000, () -> controller.start());
    });

    exitButton.setOnAction((evt) -> stage.close());
  }

  public static void delay(long millis, Runnable continuation) {
    Task<Void> sleeper = new Task<Void>() {
      @Override
      protected Void call() throws Exception {
        try { Thread.sleep(millis); }
        catch (InterruptedException e) { }
        return null;
      }
    };
    sleeper.setOnSucceeded(event -> continuation.run());
    new Thread(sleeper).start();
  }
}
