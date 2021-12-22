package controllers.encryption;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import util.Main;
import util.RC6;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class FirstRound implements Initializable {

    public TextField AStart;
    public TextField BStart;
    public TextField CStart;
    public TextField DStart;
    public TextField AFinish;
    public TextField BFinish;
    public TextField CFinish;
    public TextField DFinish;
    public Rectangle BaddS0;
    public TextField AxorT;
    public Rectangle AddS2i;
    public Rectangle DaddS1;
    public Circle f2;
    public Circle u;
    public Circle AxorTrotU;
    public TextField CxorU;
    public Button nextButton;


    @Override
    public void initialize ( URL url, ResourceBundle resourceBundle ) {
        //Numbers displayed Hex signed 2's complement

        Main.deselect(AStart);

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

    public void next ( ) throws IOException {
        Main.roundCounter++;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../forms/MiddleRound.fxml")));
        Main.primaryStage.setTitle("FirstRound");
        Main.primaryStage.setScene(new Scene(root, 773, 625));
    }

}
