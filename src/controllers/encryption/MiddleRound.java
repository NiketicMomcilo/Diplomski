package controllers.encryption;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import util.Main;
import util.RC6;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MiddleRound implements Initializable {

    public TextField AStart;
    public TextField BStart;
    public TextField CStart;
    public TextField DStart;
    public TextField AxorT;
    public TextField CxorU;
    public Button next;
    public Button prev;
    public TextField AFinish;
    public TextField BFinish;
    public TextField CFinish;
    public TextField DFinish;

    @Override
    public void initialize ( URL url, ResourceBundle resourceBundle ) {

        Main.deselect(AStart);

        //Numbers displayed Hex signed 2's complement
        byte[] int_to_bytes;
        //Start
        int_to_bytes = Main.intToByteArray(RC6.roundData.get(Main.roundCounter).Astart);
        AStart.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.roundData.get(Main.roundCounter).Bstart);
        BStart.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.roundData.get(Main.roundCounter).Cstart);
        CStart.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.roundData.get(Main.roundCounter).Dstart);
        DStart.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        //Middle
        int_to_bytes = Main.intToByteArray(RC6.roundData.get(Main.roundCounter).AxorT);
        AxorT.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.roundData.get(Main.roundCounter).CxorU);
        CxorU.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());


        //Finish
        int_to_bytes = Main.intToByteArray(RC6.roundData.get(Main.roundCounter).Afinish);
        AFinish.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.roundData.get(Main.roundCounter).Bfinish);
        BFinish.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.roundData.get(Main.roundCounter).Cfinish);
        CFinish.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.roundData.get(Main.roundCounter).Dfinish);
        DFinish.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());
    }

    public void loadNextRound ( ) throws IOException {
        Main.roundCounter++;
        //loads final round
        Parent root;
        if ( Main.roundCounter == 19 ) {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../forms/FinalRound.fxml")));
            Main.primaryStage.setTitle("FinalRound");
        } else {//loads any middle round
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../forms/MiddleRound.fxml")));
            Main.primaryStage.setTitle("MiddleRound");
        }
        Main.primaryStage.setScene(new Scene(root, 773, 625));

    }

    public void loadPreviousRound ( ) throws IOException {
        Main.roundCounter--;
        Parent root;
        if ( Main.roundCounter == 0 ) {//loads first round
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../forms/FirstRound.fxml")));
            Main.primaryStage.setTitle("FirstRound");
        } else {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../forms/MiddleRound.fxml")));
            Main.primaryStage.setTitle("MiddleRound");
        }
        Main.primaryStage.setScene(new Scene(root, 773, 625));
    }
}
