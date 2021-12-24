package controllers.decryption;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class FirstRound implements Initializable {

    public TextField AStart;
    public TextField BStart;
    public TextField CStart;
    public TextField DStart;

    public TextField AFinish;
    public TextField BFinish;
    public TextField CFinish;
    public TextField DFinish;

    public Button nextButton;

    public TextField AminS2r2;
    public TextField CminS2r3;

    public TextField Ashift;
    public TextField Bshift;
    public TextField Cshift;
    public TextField Dshift;
    public Circle f21;
    public Circle f211;

    @Override
    public void initialize ( URL url, ResourceBundle resourceBundle ) {
       

    }

    public void next ( ) throws IOException {
        Main.roundCounter++;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/encryption/MiddleRound.fxml")));
        Main.primaryStage.setTitle("FirstRound");
        Main.primaryStage.setScene(new Scene(root, 773, 625));
    }
}
