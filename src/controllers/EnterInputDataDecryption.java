package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import sample.RC6;

import java.net.URL;
import java.util.ResourceBundle;

public class EnterInputDataDecryption implements Initializable {
    public TextField encryptionKeyTextField;
    public TextField sArrayTextField;
    public TextField lArrayTextField;
    public TextField ciphertextTextField;

    @Override
    public void initialize ( URL url, ResourceBundle resourceBundle ) {

    }

    public void generateKey ( ActionEvent actionEvent ) {
        byte[] key = RC6.hexStringToByteArray(encryptionKeyTextField.getText().toString().replace(" ",""));

        new RC6().KeySchedule(key);

        StringBuilder sb = new StringBuilder();

        for ( int i = 0 ; i < RC6.S.length ; i++ ) {
            sb.append(RC6.S[i] + " ");
        }
        this.sArrayTextField.setText(sb.toString());

        sb = new StringBuilder();

        for ( int i = 0 ; i < RC6.L.length ; i++ ) {
            sb.append(RC6.L[i] + " ");
        }
        this.lArrayTextField.setText(sb.toString());
    }

    public void setDefaultDecryptionData ( ActionEvent actionEvent ) {
        this.encryptionKeyTextField.setText("01 23 45 67 89 ab cd ef 01 12 23 34 45 56 67 78 89 9a ab bc cd de ef f0 10 32 54 76 98 ba dc fe");
        this.ciphertextTextField.setText("87 f2 36 15 1c 59 96 ce aa 17 63 2e 88 c9 0d 4e");
    }

    public void nextScene ( ActionEvent actionEvent ) {
    }
}
