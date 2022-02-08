package controllers.encryption.popups;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import sample.Main;
import sample.RC6;

import java.net.URL;
import java.util.ResourceBundle;

public class XORPopup implements Initializable {

    public static int left; // 0 levo 1 desno
    public TextField xorA;
    public TextField xorB;
    public TextField xorEnd;

    @Override
    public void initialize ( URL url, ResourceBundle resourceBundle ) {
        byte[] int_to_bytes;
        if ( left == 0 ) {//gore levo
            int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).Astart);
            xorA.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).t);
            xorB.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).AxorT);
            xorEnd.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());
        } else if ( left == 1 ) {//gore levo
            int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).Cstart);
            xorA.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).u);
            xorB.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).CxorU);
            xorEnd.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());
        }

    }
}
