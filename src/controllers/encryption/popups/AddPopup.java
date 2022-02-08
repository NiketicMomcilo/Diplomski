package controllers.encryption.popups;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import sample.Main;
import sample.RC6;

import java.net.URL;
import java.util.ResourceBundle;

public class AddPopup implements Initializable {
    public TextField addA;
    public TextField addB;
    public TextField addEnd;
    public static String code;

    @Override
    public void initialize ( URL url, ResourceBundle resourceBundle ) {
        byte[] int_to_bytes;
        if(AddPopup.code.equals("S0")){
            int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).Bstart);
            addA.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).S0);
            addB.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).BS0);
            addEnd.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        }
        else if(AddPopup.code.equals("S1")){
            int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).Dstart);
            addA.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).S1);
            addB.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).DS1);
            addEnd.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        }
        else if(AddPopup.code.equals("S2i")){
            int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).AxorTrotU);
            addA.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).S2i);
            addB.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).Dfinish);
            addEnd.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());
        }
        else if(AddPopup.code.equals("S2i1")){
            int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).CxorUrotT);
            addA.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).S2i1);
            addB.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).Bfinish);
            addEnd.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());
        }
        else if(AddPopup.code.equals("S2r2")){
            int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).Bstart);
            addA.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).S2r2);
            addB.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).Afinish);
            addEnd.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        }
        else if(AddPopup.code.equals("S2r3")){
            int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).Dstart);
            addA.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).S2r3);
            addB.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).Cfinish);
            addEnd.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());
        }
    }
}
