
package controllers.decryption.popups;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import sample.Main;
import sample.RC6;

import java.net.URL;
import java.util.ResourceBundle;

public class ShiftLeftLgWord implements Initializable {
    public TextField shiftLeftStart;
    public TextField shiftLeftEnd;
    public static boolean left;
    @Override
    public void initialize ( URL url, ResourceBundle resourceBundle ) {
        byte[] int_to_bytes;

        if(left == true){
            int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).f1);
            shiftLeftStart.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).t);
            shiftLeftEnd.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());
        }
        else{
            int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).f2);
            shiftLeftStart.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).u);
            shiftLeftEnd.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());
        }


    }
}