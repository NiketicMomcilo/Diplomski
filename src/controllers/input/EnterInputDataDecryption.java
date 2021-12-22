package controllers.input;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import util.Main;
import util.RC6;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class EnterInputDataDecryption implements Initializable {
    public TextField encryptionKeyTextField;
    public TextField sArrayTextField;
    public TextField lArrayTextField;
    public TextField ciphertextTextField;
    public Button nextButton;
    public Button setDefaultEncryptionDataId;
    public Button generateKeyId;

    @Override
    public void initialize ( URL url, ResourceBundle resourceBundle ) {

    }
    /*TODO provera da li je uniti kljuc odgovarajuceg formata*/
    public void generateKey ( ) {
        byte[] key = RC6.hexStringToByteArray(encryptionKeyTextField.getText().replace(" ",""));
        RC6.KeySchedule(key);
        StringBuilder sb = new StringBuilder();
        for ( int i = 0 ; i < RC6.S.length ; i++ ) {
            sb.append(RC6.S[ i ]).append(" ");
        }
        this.sArrayTextField.setText(sb.toString());
        sb = new StringBuilder();
        for ( int i = 0 ; i < RC6.L.length ; i++ ) {
            sb.append(RC6.L[ i ]).append(" ");
        }
        this.lArrayTextField.setText(sb.toString());

        String text_data = ciphertextTextField.getText();
        text_data = text_data.replace(" ", "");
        byte[] words = RC6.hexStringToByteArray(text_data);
        RC6.decryption(words);
    }

    public void setDefaultDecryptionData ( ) {
        this.encryptionKeyTextField.setText("01 23 45 67 89 ab cd ef 01 12 23 34 45 56 67 78 89 9a ab bc cd de ef f0 10 32 54 76 98 ba dc fe");
        this.ciphertextTextField.setText("87 f2 36 15 1c 59 96 ce aa 17 63 2e 88 c9 0d 4e");
    }

    public void nextScene ( ) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../forms/FirstRound.fxml")));
        Main.primaryStage.setTitle("FirstRound");
        Main.primaryStage.setScene(new Scene(root, 773, 625));
    }
}
