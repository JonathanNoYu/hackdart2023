package model;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.HashMap;

public class PopUp extends Application {
    private static int totalPages = 0;
    private static String diary = "Diary";

    public static void main(String[] args) {
        Stage stage = new Stage();
        try {
            totalPages = Integer.parseInt(args[0]);
            diary = args[1];

        } catch (NumberFormatException e) {
            totalPages = 0;
            diary = args[1];
        }

        HashMap<Integer, Scene> map = new HashMap<>();

        int maxPages = totalPages;
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

        stage.setTitle("CodersLegacy");
        stage.setScene(map.get(0));
        stage.show();
    }


    @Override
    public void start(Stage stage){
        HashMap<Integer, Scene> map = new HashMap<>();

        int maxPages = totalPages;
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

        stage.setTitle("CodersLegacy");
        stage.setScene(map.get(0));
        stage.show();
    }
}
