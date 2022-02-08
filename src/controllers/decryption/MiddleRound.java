package controllers.decryption;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.Main;
import sample.RC6;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MiddleRound implements Initializable {
    public TextField AStart;
    public TextField BStart;
    public TextField CStart;
    public TextField DStart;
    public TextField AFinish;
    public TextField BFinish;
    public TextField CFinish;
    public TextField DFinish;
    public Button nextButton;
    public TextField Bshift;
    public TextField Cshift;
    public TextField Dshift;
    public TextField Ashift;
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



        int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).AendRound);
        AFinish.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).BendRound);
        BFinish.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).CendRound);
        CFinish.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).DendRound);
        DFinish.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());
    }

    public void prev ( ) throws IOException {
        Main.roundCounter--;
        Parent root;
        if ( Main.roundCounter == 0 ) {//loads first round
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/decryption/FirstRound.fxml")));
            Main.primaryStage.setTitle("FirstRound");
        } else {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/decryption/MiddleRound.fxml")));
            Main.primaryStage.setTitle("MiddleRound");
        }
        Main.primaryStage.setScene(new Scene(root, 773, 625));

    }

    public void next ( ) throws IOException {
        Main.roundCounter++;
        //loads final round
        Parent root;
        if ( Main.roundCounter == 19 ) {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/decryption/FinalRound.fxml")));
            Main.primaryStage.setTitle("FinalRound");
        } else {//loads any middle round
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/decryption/MiddleRound.fxml")));
            Main.primaryStage.setTitle("MiddleRound");
        }
        Main.primaryStage.setScene(new Scene(root, 773, 625));
    }

}
