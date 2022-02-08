package controllers.util;

import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class EnterParameters implements Initializable {


    public static int wordLength;
    public static int numberOfRounds;
    public static int keyLength;
    public ChoiceBox <String> mode;

    @Override
    public void initialize ( URL location, ResourceBundle resources ) {
        mode.setItems(FXCollections.observableArrayList("Encryption", "Decryption"));
        mode.setValue(mode.getItems().get(0));
    }
    public void Button_goToEncryptionDescription ( ) throws IOException {
        keyLength = 192;
        wordLength = 32;
        numberOfRounds = 20;
        this.changeScene();
    }

    private void changeScene ( ) throws IOException {
        if ( this.mode.getValue().equals("Encryption") ) {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/input/EnterInputDataEncryption.fxml")));
            Main.primaryStage.setTitle("Encryption");
            Main.primaryStage.setScene(new Scene(root, 850, 550));
        } else {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/input/EnterInputDataDecryption.fxml")));
            Main.primaryStage.setTitle("Decryption");
            Main.primaryStage.setScene(new Scene(root, 850, 550));
        }
    }

}
