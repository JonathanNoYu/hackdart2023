import controller.Feature;
import controller.TaxController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
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
    // stage.getIcons().add(ImageUtil.LOGO);
    stage.setMaximized(true);
    stage.show();
  }
}
