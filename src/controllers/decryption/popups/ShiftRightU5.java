package controllers.decryption.popups;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import sample.Main;
import sample.RC6;

import java.net.URL;
import java.util.ResourceBundle;

public class ShiftRightU5 implements Initializable {
    public TextField shiftLeftStart;
    public TextField shiftLeftEnd;

    @Override
    public void initialize ( URL url, ResourceBundle resourceBundle ) {
        byte[] int_to_bytes;
        int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).AshiftMinS2i);
        shiftLeftStart.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).AshiftMinS2iRotU);
        shiftLeftEnd.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

    }
}
