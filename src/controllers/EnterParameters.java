package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EnterParameters implements Initializable {


    public TextField wordLengthInputField;
    public TextField numberOfRoundsInputField;
    public TextField keyLengthInputField;
    public CheckBox Encryption;

    public static int wordLength;
    public static int numberOfRounds;
    public static int keyLength;


    @Override
    public void initialize( URL location, ResourceBundle resources)
    {

    }

    public static byte[] hexStringToByteArray(String s) {
        int string_len = s.length();
        byte[] data = new byte[string_len / 2];
        for (int i = 0; i < string_len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character
                    .digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    public void Button_goToEncryptionDescription ( ActionEvent actionEvent ) throws IOException {


        keyLength =  Integer.parseInt(this.keyLengthInputField.getText().toString());
        wordLength = Integer.parseInt(this.wordLengthInputField.getText().toString());
        numberOfRounds = Integer.parseInt(this.numberOfRoundsInputField.getText().toString());


        this.changeScene();
    }

    public void setDefault ( ActionEvent actionEvent ) {

        wordLengthInputField.setText("32");
        numberOfRoundsInputField.setText("20");
        keyLengthInputField.setText("192");

    }

    private void changeScene() throws IOException {

        if(this.Encryption.isSelected()){
            Parent root = FXMLLoader.load(getClass().getResource("../forms/EnterInputDataEncryption.fxml"));

            Main.primaryStage.setTitle("Encryption");
            Main.primaryStage.setScene(new Scene(root, 600, 400));
        }
        else{
            Parent root = FXMLLoader.load(getClass().getResource("../forms/EnterInputDataDecryption.fxml"));

            Main.primaryStage.setTitle("Decryption");
            Main.primaryStage.setScene(new Scene(root, 600, 400));
        }

    }
}
