import controller.Feature;
import controller.TaxController;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
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
    ITaxView view = new TaxView();
    ITaxModel model = new TaxModel(view.getInputCount());
    Feature controller = new TaxController(model, view);
    view.addFeatures(controller);
    stage.setTitle("NonTaxEvaders!");
    stage.setScene(new Scene(view.getView()));
    stage.initStyle(StageStyle.UNIFIED);
    // stage.getIcons().add(ImageUtil.LOGO);
    stage.setMaximized(true);
    stage.show();
    delay(750, () -> controller.start());
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
