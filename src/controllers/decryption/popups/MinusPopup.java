
package controllers.decryption.popups;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import sample.Main;
import sample.RC6;

import java.net.URL;
import java.util.ResourceBundle;

public class MinusPopup implements Initializable {
    public TextField minusFirst;
    public TextField minusResult;
    public TextField minusSmaller;
    public static boolean left;

    @Override
    public void initialize ( URL url, ResourceBundle resourceBundle ) {
        byte[] int_to_bytes;
        if( left ){

            int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).Ashift);
            minusFirst.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).S2i);
            minusSmaller.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).AshiftMinS2i);
            minusResult.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        }
        else{
            int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).Cshift);
            minusFirst.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).S2i1);
            minusSmaller.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).CshiftMinS2i1);
            minusResult.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        }

    }
}
