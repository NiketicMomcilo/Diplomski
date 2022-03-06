package controllers.encryption.popups;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import sample.Main;
import sample.RC6;

import java.net.URL;
import java.util.ResourceBundle;

public class ShiftLeftU5 implements Initializable {
    public TextField shiftLeftStart;
    public TextField shiftLeftEnd;
    public TextField shiftLeftU;

    @Override
    public void initialize ( URL url, ResourceBundle resourceBundle ) {
        byte[] int_to_bytes;


        int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).u);
        shiftLeftU.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).AxorT);
        shiftLeftStart.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).AxorTrotU);
        shiftLeftEnd.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

    }
}
