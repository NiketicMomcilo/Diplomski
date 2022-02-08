package controllers.encryption.popups;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import sample.Main;
import sample.RC6;

import java.net.URL;
import java.util.ResourceBundle;

public class ShiftLeftLgWordPopup implements Initializable {

    public static int left; // 0 levo 1 desno
    public TextField shiftLeftStart;
    public TextField shiftLeftEnd;

    @Override
    public void initialize ( URL url, ResourceBundle resourceBundle ) {
        byte[] int_to_bytes;
        if(left == 0 ){
            int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).f1);
            shiftLeftStart.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).t);
            shiftLeftEnd.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());
        }
        else if(left == 1 ){
            int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).f2);
            shiftLeftStart.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).u);
            shiftLeftEnd.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());
        }
    }
}
