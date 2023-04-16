package model;

import controller.Feature;
import java.util.ArrayList;
import javafx.scene.control.Button;

public class RunPopUp {
    ArrayList<PopUp> pops = new ArrayList<>();
    Button submit;
    Feature controller;

    public RunPopUp() {}

    public void addSubmit(Button button, Feature controller) {

        this.submit = button;
        this.controller = controller;
    }

    public void main(String[] args) {
        PopUp pop = new PopUp();
        this.pops.add(pop);
        pop.main(args);
        submit.setOnAction((evt) -> {
            for(PopUp windows : pops) {
                windows.end();
            }
            this.controller.checkAnswers();
        });
    }
}
