package model;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.HashMap;
import javafx.stage.StageStyle;

public class PopUp extends Application {
    private double xOffset = 0;
    private double yOffset = 0;
    private int totalPages = 0;
    private String docName = "diary-1";
    private final ArrayList<Stage> allStages = new ArrayList<>();
    public static Image LOGO = new Image(Objects.requireNonNull(
        Thread.currentThread().getContextClassLoader().getResourceAsStream("logo_yes_yes.png")));
    private final String diary1 = Objects.requireNonNull(getClass().getResource("/style/Diary1.css"))
        .toExternalForm();
    private final String artifact1 = Objects.requireNonNull(getClass().getResource("/style/Artifact.css"))
        .toExternalForm();
    private final String damaages = Objects.requireNonNull(getClass().getResource("/style/Damaages.css"))
        .toExternalForm();
    private final String trackPrizes = Objects.requireNonNull(getClass().getResource("/style/track_Prizes.css"))
        .toExternalForm();
    private final String conversions = Objects.requireNonNull(getClass().getResource("/style/Conversions.css"))
            .toExternalForm();
    private final String rules = Objects.requireNonNull(getClass().getResource("/style/Rules.css"))
            .toExternalForm();
    private final String buttonCSS = Objects.requireNonNull(getClass().getResource("/style/button.css"))
        .toExternalForm();
    private final String popUpStyle = Objects.requireNonNull(getClass().getResource("/style/popUpStyle.css"))
        .toExternalForm();
    private final HashMap<String, String> cssMap = new HashMap<>();

    public PopUp() {
        cssMap.put("diary-1",diary1);           // ID: 1
        cssMap.put("artifact1",artifact1);      // ID: 2
        cssMap.put("damaages", damaages);       // ID: 3
        cssMap.put("track_prizes", trackPrizes);// ID: 4
        cssMap.put("conversions", conversions); // ID: 5
        cssMap.put("rules", rules);             // ID: 6
    }

    public void main(String[] args) {

        Stage stage = new Stage();
        allStages.add(stage);
        stage.initStyle(StageStyle.TRANSPARENT);
        try {
            totalPages = Integer.parseInt(args[0]);
            docName = args[1];

        } catch (NumberFormatException e) {
            totalPages = 0;
            docName = args[1];
        }

        HashMap<Integer, Scene> map = new HashMap<>();

        int maxPages = totalPages;
        final int[] pageNum = {0};
        for(int i = 0; i < maxPages; i++) {
            Label label = new Label("Page " + (i+1) + " / Page " + maxPages);
            HBox layout = new HBox();
            layout.getStylesheets().addAll(this.popUpStyle, this.buttonCSS);
            for (Map.Entry<String,String> entry : this.cssMap.entrySet()) {
                if (Objects.equals(entry.getKey(), docName)) {
                    layout.getStylesheets().add(entry.getValue());
                }
            }
            layout.setId(i+"");

            layout.setId(i + "");
            System.out.println("Layout ID: " + i);
            layout.setAlignment(Pos.CENTER);

            Scene scene = new Scene(layout, 900, 600);
            map.put(i, scene);
            scene.setFill(Color.TRANSPARENT);

            Button exit = new Button("x");
            exit.setId("exit");
            exit.setOnAction((evt) -> stage.close());
            layout.getChildren().addAll(label, exit);

            if (maxPages > 1) {
                Button forward = new Button(">");
                forward.setId("forward");
                forward.setOnAction((evt) -> {
                    if (pageNum[0] < maxPages - 1) {
                        pageNum[0]++;
                    }
                    stage.setScene(map.get(pageNum[0]));
                });

                Button back = new Button("<");
                back.setId("back");
                back.setOnAction((evt) -> {
                    if (pageNum[0] > 0) {
                        pageNum[0]--;
                    }
                    stage.setScene(map.get(pageNum[0]));
                });
                layout.getChildren().addAll(forward, back);
            }

            layout.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                }
            });
            layout.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    stage.setX(event.getScreenX() - xOffset);
                    stage.setY(event.getScreenY() - yOffset);
                }
            });
        }

        stage.getIcons().add(LOGO);
        stage.setTitle(docName);
        stage.setScene(map.get(0));
        stage.show();
    }


    @Override
    public void start(Stage stage) {
    }

    /**
     * Closes all the Stages/Windows
     */
    public void end() {
        for(Stage stage: allStages) {
            stage.close();
        }
    }
}
