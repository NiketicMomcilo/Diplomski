package controllers.decryption.popups;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import sample.Main;
import sample.RC6;

import java.net.URL;
import java.util.ResourceBundle;

public class XorPopup implements Initializable {
    public TextField xorA;
    public TextField xorB;
    public TextField xorEnd;
    public static boolean left;
    @Override
    public void initialize ( URL url, ResourceBundle resourceBundle ) {
        byte[] int_to_bytes;
        if(left == true){
            int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).AshiftMinS2iRotU);
            xorA.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).t);
            xorB.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).AendRound);
            xorEnd.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());
            System.out.println("a");
        }
        else{
            System.out.println("ab");
            int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).CshiftMinS2r3RotT);
            xorA.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).u);
            xorB.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

            int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).CendRound);
            xorEnd.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());
        }
    }
}
