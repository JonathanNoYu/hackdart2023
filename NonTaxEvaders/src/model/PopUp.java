package model;

import java.util.Objects;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import java.util.HashMap;

public class PopUp extends Application {
    private static int totalPages = 0;
    private static String diary = "diary-1";

    public PopUp() {

    }

    public void main(String[] args) {

        Stage stage = new Stage();
        try {
            totalPages = Integer.parseInt(args[0]);
            diary = args[1];

        } catch (NumberFormatException e) {
            totalPages = 0;
            diary = args[1];
        }
        String css = Objects.requireNonNull(getClass().getResource("/style/Diary1.css"))
            .toExternalForm();

        HashMap<Integer, Scene> map = new HashMap<>();

        int maxPages = totalPages;
        final int[] pageNum = {0};

        for(int i = 0; i < maxPages; i++) {
            Label label = new Label("This is the " + (i+1) + " Scene");
            HBox layout = new HBox();
            layout.getStylesheets().add(css);
            layout.setId(i+"");

            layout.setId(i + "");
            System.out.println("Layout ID: " + i);
            layout.setAlignment(Pos.CENTER);

            map.put(i, new Scene(layout, 900, 600));

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
    public void start(Stage stage) {
    }
}
