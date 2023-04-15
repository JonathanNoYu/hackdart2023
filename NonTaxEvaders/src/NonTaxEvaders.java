import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NonTaxEvaders extends Application {

  public static void main(String[] args) {launch(args);}

  @Override
  public void start(Stage stage){
    stage.setTitle("NonTaxEvaders!");
    // stage.setScene(new Scene(view.getView()));
    // stage.getIcons().add(ImageUtil.LOGO);
    stage.setMaximized(true);
    stage.show();
  }
}
