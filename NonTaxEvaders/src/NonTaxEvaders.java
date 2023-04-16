import controller.Feature;
import controller.TaxController;
import java.util.Objects;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.ITaxModel;
import model.TaxModel;
import view.ITaxView;
import view.TaxView;

public class NonTaxEvaders extends Application {

  public static Image LOGO = new Image(Objects.requireNonNull(
      Thread.currentThread().getContextClassLoader().getResourceAsStream("logo_yes_yes.png")));

  public static void main(String[] args) {launch(args);}

  @Override
  public void start(Stage stage){
    // Start of full game MVC
    ITaxView view = new TaxView();
    ITaxModel model = new TaxModel(view.getInputCount());
    model.generateDocs();
    Feature controller = new TaxController(model, view);
    stage.setTitle("NonTaxEvaders!");
    Scene game = new Scene(view.getView());

    // Start Scene with start button
    HBox start = new HBox();
    start.setPrefHeight(900);
    start.setPrefWidth(1800);
    start.setId("START");
    start.getStylesheets().add("style/startingStyle.css");
    Button startButton = new Button("Start!");
    startButton.setId("startBut");
    Button exitButton = new Button("x");
    exitButton.setId("exitBut");
    start.getChildren().addAll(startButton,exitButton);
    stage.setScene(new Scene(start));
    stage.initStyle(StageStyle.TRANSPARENT);
    stage.getIcons().add(LOGO);

    stage.setMaximized(true);
    stage.show();

    startButton.setOnAction((evt) -> {
      view.addFeatures(controller);
      Stage newStage = new Stage();
      newStage.setMaximized(true);
      newStage.setScene(game);
      newStage.getIcons().add(LOGO);
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
