package controllers.encryption.popups;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import sample.Main;
import sample.RC6;

import java.net.URL;
import java.util.ResourceBundle;

public class FPopup implements Initializable {
    public static int left;
    public static boolean firstRound;
    public TextField fStart;
    public TextField fEnd;
    @Override
    public void initialize ( URL url, ResourceBundle resourceBundle ) {
        byte[] int_to_bytes;
        if(firstRound){
            if ( left == 0 ) {
                int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).BS0);
                fStart.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

                int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).f1);
                fEnd.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            } else {
                int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).DS1);
                fStart.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

                int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).f2);
                fEnd.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            }
        }
        else{
            if ( left == 0 ) {
                int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).Bstart);
                fStart.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

                int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).f1);
                fEnd.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            } else {
                int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).Dstart);
                fStart.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

                int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).f2);
                fEnd.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            }
        }
    }
}
