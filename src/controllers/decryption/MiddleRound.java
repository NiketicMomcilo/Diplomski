package controllers.decryption;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class MiddleRound implements Initializable {
    public TextField AStart;
    public TextField BStart;
    public TextField CStart;
    public TextField DStart;
    public TextField AFinish;
    public TextField BFinish;
    public TextField CFinish;
    public TextField DFinish;
    public Rectangle BaddS0;
    public Circle f2;
    public Button nextButton;
    public TextField Bshift;
    public TextField Cshift;
    public TextField Dshift;
    public TextField Ashift;

    @Override
    public void initialize ( URL url, ResourceBundle resourceBundle ) {

    }

    public void goToNextRound ( ActionEvent actionEvent ) {
    }

    public void goToPreviousRound ( ActionEvent actionEvent ) {
    }


}
