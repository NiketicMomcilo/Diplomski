package controllers.input;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import util.Main;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class EnterParameters implements Initializable {


    public static int wordLength;
    public static int numberOfRounds;
    public static int keyLength;
    public TextField wordLengthInputField;
    public TextField numberOfRoundsInputField;
    public TextField keyLengthInputField;
    public CheckBox Encryption;

    @Override
    public void initialize ( URL location, ResourceBundle resources ) {

    }
    public void Button_goToEncryptionDescription ( ) throws IOException {
        keyLength = Integer.parseInt(this.keyLengthInputField.getText());
        wordLength = Integer.parseInt(this.wordLengthInputField.getText());
        numberOfRounds = Integer.parseInt(this.numberOfRoundsInputField.getText());
        this.changeScene();
    }
    /*TODO provera ispravnosti unetih parametara */
    public void setDefault ( ) {
        wordLengthInputField.setText("32");
        numberOfRoundsInputField.setText("20");
        keyLengthInputField.setText("192");
    }

    private void changeScene ( ) throws IOException {
        if ( this.Encryption.isSelected() ) {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../forms/EnterInputDataEncryption.fxml")));
            Main.primaryStage.setTitle("Encryption");
            Main.primaryStage.setScene(new Scene(root, 600, 400));
        } else {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../forms/EnterInputDataDecryption.fxml")));
            Main.primaryStage.setTitle("Decryption");
            Main.primaryStage.setScene(new Scene(root, 600, 400));
        }

    }
}
