package controllers.input;


import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Main;
import sample.RC6;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
//ab cd ef 3e c8 24 18 16 f0 d7 e4 89 20 ad 16 a1
//1E 44 B6 A6 37 E8 3E 61 EC 30 F8 74 EB D4 01 67
public class EnterInputDataEncryption implements Initializable {
    public TextField encryptionKeyTextField;
    public TextField sArrayTextField;
    public TextField lArrayTextField;
    public TextField plaintextTextField;
    public Button nextButton;
    @Override
    public void initialize ( URL url, ResourceBundle resourceBundle ) {

    }
    public void setDefaultEncryptionData ( ) {
        this.encryptionKeyTextField.setText("01 23 45 67 89 ab cd ef 01 12 23 34 45 56 67 78 89 9a ab bc cd de ef f0 10 32 54 76 98 ba dc fe");
        this.plaintextTextField.setText("45 46 47 48 c8 24 18 16 f0 d7 e4 89 20 ad 16 a1 ");
    }

    public void generateKey ( ) {
        byte[] key = RC6.hexStringToByteArray(encryptionKeyTextField.getText().replace(" ", ""));
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

        String text_data = plaintextTextField.getText();
        text_data = text_data.replace(" ", "");
        byte[] words = RC6.hexStringToByteArray(text_data);
        RC6.encryption(words);

    }

    public void nextScene ( ) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/encryption/FirstRound.fxml")));
        Main.primaryStage.setTitle("FirstRound");
        Main.primaryStage.setScene(new Scene(root, 773, 625));
    }
}
