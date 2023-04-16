import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;

public class PopUp extends Application {

    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage stage){
        HashMap<Integer, Scene> map = new HashMap<>();

        int maxPages = 9;
        final int[] pageNum = {0};


        for(int i = 0; i < maxPages; i++) {
            Label label = new Label("This is the " + (i+1) + " Scene");
            VBox layout = new VBox();
            layout.setAlignment(Pos.CENTER);
            map.put(i, new Scene(layout, 300, 300));

            Button forward = new Button("-->");
            forward.setOnAction((evt) -> {
                if (pageNum[0] < maxPages - 1) {
                    pageNum[0]++;
                }
                stage.setScene(map.get(pageNum[0]));
            });

            Button back = new Button("<--");
            back.setOnAction((evt) -> {
                if (pageNum[0] > 0) {
                    pageNum[0]--;
                }
                stage.setScene(map.get(pageNum[0]));
            });


            layout.getChildren().addAll(label, forward, back);
        }


//        Scene scene1 = new Scene(diaryLayout, 300, 300);
//        Scene scene2 = new Scene(diaryLayout, 300, 300);
//        Scene scene3 = new Scene(diaryLayout, 300, 300);
//        Scene scene4 = new Scene(diaryLayout, 300, 300);
//        Scene scene5 = new Scene(diaryLayout, 300, 300);
//        Scene scene6 = new Scene(diaryLayout, 300, 300);
//        Scene scene7 = new Scene(diaryLayout, 300, 300);
//        Scene scene8 = new Scene(diaryLayout, 300, 300);
//        Scene scene9 = new Scene(diaryLayout, 300, 300);
//
//        map.put(1, scene1);
//        map.put(2, scene2);
//        map.put(3, scene3);
//        map.put(4, scene4);
//        map.put(5, scene5);
//        map.put(6, scene6);
//        map.put(7, scene7);
//        map.put(8, scene8);
//        map.put(9, scene9);
//
//        Label label1 = new Label("This is the 1 Scene");
//        Label label2 = new Label("This is the 2 Scene");
//        Label label3 = new Label("This is the 3 Scene");
//        Label label4 = new Label("This is the 4 Scene");
//        Label label5 = new Label("This is the 5 Scene");
//        Label label6 = new Label("This is the 6 Scene");
//        Label label7 = new Label("This is the 7 Scene");
//        Label label8 = new Label("This is the 8 Scene");
//        Label label9 = new Label("This is the 9 Scene");



//        VBox layout = new VBox();
//        VBox layout2 = new VBox();
//        layout.setAlignment(Pos.CENTER);
//        layout2.setAlignment(Pos.CENTER);

//        layout.getChildren().addAll(label1, button);
//        layout2.getChildren().addAll(label2, button2, text);

        stage.setTitle("CodersLegacy");
        stage.setScene(map.get(0));
        stage.show();

    }
}
