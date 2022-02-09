package controllers.input;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import sample.Main;
import sample.RC6;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

public class EnterInputDataDecryption implements Initializable {
    public TextField ciphertextTextField;
    public Button nextButton;
    public Button setDefaultEncryptionDataId;
    public Button generateKeyid;
    public Label errorLabel;

    public TextField S0;
    public TextField S1;
    public TextField S2;
    public TextField S3;
    public TextField S8;
    public TextField S9;
    public TextField S10;
    public TextField S11;
    public TextField S4;
    public TextField S5;
    public TextField S6;
    public TextField S7;
    public TextField S12;
    public TextField S13;
    public TextField S14;
    public TextField S15;
    public TextField S16;
    public TextField S17;
    public TextField S18;
    public TextField S19;
    public TextField S24;
    public TextField S25;
    public TextField S26;
    public TextField S27;
    public TextField S20;
    public TextField S21;
    public TextField S22;
    public TextField S23;
    public TextField S28;
    public TextField S29;
    public TextField S30;
    public TextField S31;
    public TextField S32;
    public TextField S33;
    public TextField S34;
    public TextField S35;
    public TextField S36;
    public TextField S37;
    public TextField S38;
    public TextField S39;
    public TextField S40;
    public TextField S41;
    public TextField S42;
    public TextField S43;

    public TextField L0;
    public TextField L1;
    public TextField L2;
    public TextField L3;
    public TextField L4;
    public TextField L5;
    public TextField L6;
    public TextField L7;

    public ArrayList <TextField> SarrayTextFields = new ArrayList <>();
    public ArrayList<TextField> LarrayTextFields = new ArrayList <>();
    public TextField decryptionKeyTextField;

    @Override
    public void initialize ( URL url, ResourceBundle resourceBundle ) {
        SarrayTextFields.add(S0);
        SarrayTextFields.add(S1);
        SarrayTextFields.add(S2);
        SarrayTextFields.add(S3);
        SarrayTextFields.add(S4);
        SarrayTextFields.add(S5);
        SarrayTextFields.add(S6);
        SarrayTextFields.add(S7);
        SarrayTextFields.add(S8);
        SarrayTextFields.add(S9);

        SarrayTextFields.add(S10);
        SarrayTextFields.add(S11);
        SarrayTextFields.add(S12);
        SarrayTextFields.add(S13);
        SarrayTextFields.add(S14);
        SarrayTextFields.add(S15);
        SarrayTextFields.add(S16);
        SarrayTextFields.add(S17);
        SarrayTextFields.add(S18);
        SarrayTextFields.add(S19);

        SarrayTextFields.add(S20);
        SarrayTextFields.add(S21);
        SarrayTextFields.add(S22);
        SarrayTextFields.add(S23);
        SarrayTextFields.add(S24);
        SarrayTextFields.add(S25);
        SarrayTextFields.add(S26);
        SarrayTextFields.add(S27);
        SarrayTextFields.add(S28);
        SarrayTextFields.add(S29);

        SarrayTextFields.add(S30);
        SarrayTextFields.add(S31);
        SarrayTextFields.add(S32);
        SarrayTextFields.add(S33);
        SarrayTextFields.add(S34);
        SarrayTextFields.add(S35);
        SarrayTextFields.add(S36);
        SarrayTextFields.add(S37);
        SarrayTextFields.add(S38);
        SarrayTextFields.add(S39);

        SarrayTextFields.add(S40);
        SarrayTextFields.add(S41);
        SarrayTextFields.add(S42);
        SarrayTextFields.add(S43);

        LarrayTextFields.add(L0);
        LarrayTextFields.add(L1);
        LarrayTextFields.add(L2);
        LarrayTextFields.add(L3);
        LarrayTextFields.add(L4);
        LarrayTextFields.add(L5);
        LarrayTextFields.add(L6);
        LarrayTextFields.add(L7);
    }
    public void generateKey ( ) {
        if(errorCheck()){
            byte[] key = RC6.hexStringToByteArray(decryptionKeyTextField.getText().replace(" ",""));
            RC6.KeySchedule(key);

            for ( int i = 0 ; i < RC6.S.length ; i++ ) {
                SarrayTextFields.get(i).setText(RC6.byteArrayToHex(Main.intToByteArray(RC6.S[ i ])).toUpperCase(Locale.ROOT));
            }
            for ( int i = 0 ; i < RC6.L.length ; i++ ) {
                LarrayTextFields.get(i).setText(RC6.byteArrayToHex(Main.intToByteArray(RC6.L[ i ])).toUpperCase(Locale.ROOT));
            }

            System.out.println(RC6.L.length);

            String text_data = ciphertextTextField.getText();
            text_data = text_data.replace(" ", "");
            byte[] words = RC6.hexStringToByteArray(text_data);
            RC6.decryption(words);
        }
    }

    public void setDefaultDecryptionData ( ) {
        this.decryptionKeyTextField.setText("01 23 45 67 89 AB CD EF 01 12 23 34 45 56 67 78 89 9A AB BC CD DE EF F0 10 32 54 76 98 BA DC FE");
        this.ciphertextTextField.setText("87 F2 36 15 1C 59 96 CE AA 17 63 2E 88 C9 0D 4E");
    }

    boolean errorCheck(){
        String key = this.decryptionKeyTextField.getText().replace(" ", "");
        String cyphertext = this.ciphertextTextField.getText().replace(" ", "");

        if(key.length() != 64){
            errorLabel.setTextFill(Color.RED);
            errorLabel.setText("Key must have 64 characters (256b) not including spaces");
            return false;
        }
        if(!key.matches("^[0-9A-F]+$")){
            errorLabel.setTextFill(Color.RED);
            errorLabel.setText("Key must be hex number consisting only of 0-9, A-F");
            return false;
        }

        if(cyphertext.length() != 32){
            errorLabel.setTextFill(Color.RED);
            errorLabel.setText("Cyphertext must have 32 characters not including spaces");
            return false;
        }
        if(!cyphertext.matches("^[0-9A-F]+$")){
            errorLabel.setTextFill(Color.RED);
            errorLabel.setText("Cyphertext must be hex number consisting only of 0-9, A-F");
            return false;
        }
        return true;
    }

    public void nextScene ( ) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/decryption/FirstRound.fxml")));
        Main.primaryStage.setTitle("FirstRound");
        Main.primaryStage.setScene(new Scene(root, 773, 683));
    }

}
