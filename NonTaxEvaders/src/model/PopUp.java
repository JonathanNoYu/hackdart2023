package model;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.HashMap;
import java.util.Objects;

public class PopUp extends Application {
    private static int totalPages = 0;
    private static String diary = "diary-1";
    private static String PATH_TO_RES = "-fx-background-image: url(\"../../../../res/";
    private static String URL_END = "\");" + System.lineSeparator();
    private static String STYLE1 = "-fx-background-repeat: stretch;" + System.lineSeparator();
    private static String STYLE2 = "-fx-background-size: 900 600;" + System.lineSeparator();
    private static String STYLE3 = "-fx-background-position: center center;" + System.lineSeparator();

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

            layout.setId(String.valueOf(i));
            layout.setAlignment(Pos.CENTER);
            layout.setStyle(PATH_TO_RES + diary + URL_END + STYLE1 + STYLE2 + STYLE3);
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
    public void start(Stage stage) {
    }
}
