package controllers.decryption.popups;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import sample.Main;
import sample.RC6;

import java.net.URL;
import java.util.ResourceBundle;

public class MinusS0Popup implements Initializable {
    public TextField minusFirst;
    public TextField minusSmaller;
    public TextField minusResult;

    @Override
    public void initialize ( URL url, ResourceBundle resourceBundle ) {
        byte[] int_to_bytes;
        int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).Bshift);
        minusFirst.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).S0);
        minusSmaller.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).Bfinish);
        minusResult.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

    }
}
