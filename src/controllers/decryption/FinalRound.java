package controllers.decryption;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import sample.Main;
import sample.RC6;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class FinalRound implements Initializable {
    public TextField AStart;
    public TextField BStart;
    public TextField CStart;
    public TextField DStart;
    public TextField AFinish;
    public TextField BFinish;
    public TextField CFinish;
    public TextField DFinish;
    public TextField Bshift;
    public TextField Cshift;
    public TextField Dshift;
    public TextField Ashift;
    public Circle f21;
    public Circle f211;
    public Label roundCounter;

    @Override
    public void initialize ( URL url, ResourceBundle resourceBundle ) {

        Main.deselect(AStart);
        roundCounter.setText(String.valueOf(Main.roundCounter));
        //Numbers displayed Hex signed 2's complement
        byte[] int_to_bytes;

        int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).Astart);
        AStart.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).Bstart);
        BStart.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).Cstart);
        CStart.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).Dstart);
        DStart.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());



        int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).Ashift);
        Ashift.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).Bshift);
        Bshift.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).Cshift);
        Cshift.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).Dshift);
        Dshift.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());



        int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).Afinish);
        AFinish.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).Bfinish);
        BFinish.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).Cfinish);
        CFinish.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).Dfinish);
        DFinish.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

    }

    public void goToPreviousRound ( ) throws IOException {
        Main.roundCounter--;
        Parent root;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/decryption/MiddleRound.fxml")));
        Main.primaryStage.setTitle("MiddleRound");
        Main.primaryStage.setScene(new Scene(root, 773, 625));

    }
}
