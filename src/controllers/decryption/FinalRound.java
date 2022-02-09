package controllers.decryption;

import com.sun.javafx.charts.Legend;
import controllers.decryption.popups.FPopup;
import controllers.decryption.popups.MinusPopup;
import controllers.decryption.popups.ShiftLeftLgWord;
import controllers.decryption.popups.XorPopup;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
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

    public TextField AFinishRotate;
    public TextField BFinishRotate;
    public TextField CFinishRotate;
    public TextField DFisnihRotate;

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

        //Finish rotate
        byte temp;
        int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).Afinish);
        temp = int_to_bytes[ 0 ];
        int_to_bytes[0] = int_to_bytes[ 3 ];
        int_to_bytes[3] = temp;
        temp = int_to_bytes[ 1 ];
        int_to_bytes[1] = int_to_bytes[ 2 ];
        int_to_bytes[2] = temp;
        AFinishRotate.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).Bfinish);
        temp = int_to_bytes[ 0 ];
        int_to_bytes[0] = int_to_bytes[ 3 ];
        int_to_bytes[3] = temp;
        temp = int_to_bytes[ 1 ];
        int_to_bytes[1] = int_to_bytes[ 2 ];
        int_to_bytes[2] = temp;
        BFinishRotate.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).Cfinish);
        temp = int_to_bytes[ 0 ];
        int_to_bytes[0] = int_to_bytes[ 3 ];
        int_to_bytes[3] = temp;
        temp = int_to_bytes[ 1 ];
        int_to_bytes[1] = int_to_bytes[ 2 ];
        int_to_bytes[2] = temp;
        CFinishRotate.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.dectyptionRoundData.get(Main.roundCounter).Dfinish);
        temp = int_to_bytes[ 0 ];
        int_to_bytes[0] = int_to_bytes[ 3 ];
        int_to_bytes[3] = temp;
        temp = int_to_bytes[ 1 ];
        int_to_bytes[1] = int_to_bytes[ 2 ];
        int_to_bytes[2] = temp;
        DFisnihRotate.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());



    }

    public void goToPreviousRound ( ) throws IOException {
        Main.roundCounter--;
        Parent root;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/decryption/MiddleRound.fxml")));
        Main.primaryStage.setTitle("MiddleRound");
        Main.primaryStage.setScene(new Scene(root, 773, 683));

    }

    public void showMinusDownLeft() throws IOException {
        if(Main.popupStage == null){
            Main.popupStage = new Stage();
        }
        MinusPopup.left = true;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/decryption/popups/MinusPopup.fxml")));
        Main.popupStage.setTitle("Minus");
        Main.popupStage.setScene(new Scene(root, 521,204));
        Main.popupStage.setResizable(false);
        Main.popupStage.show();
    }

    public void showMinusDownRight() throws IOException {
        if(Main.popupStage == null){
            Main.popupStage = new Stage();
        }
        MinusPopup.left = false;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/decryption/popups/MinusPopup.fxml")));
        Main.popupStage.setTitle("Minus");
        Main.popupStage.setScene(new Scene(root, 521,204));
        Main.popupStage.setResizable(false);
        Main.popupStage.show();
    }


    public void showShiftleftLgWordLeft() throws IOException {
        if(Main.popupStage == null){
            Main.popupStage = new Stage();
        }
        ShiftLeftLgWord.left = true;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/decryption/popups/ShiftLeftLgWordPopup.fxml")));
        Main.popupStage.setTitle("Minus");
        Main.popupStage.setScene(new Scene(root, 521,204));
        Main.popupStage.setResizable(false);
        Main.popupStage.show();
    }
    public void showShiftleftLgWordRight() throws IOException {
        if(Main.popupStage == null){
            Main.popupStage = new Stage();
        }
        ShiftLeftLgWord.left = false;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/decryption/popups/ShiftLeftLgWordPopup.fxml")));
        Main.popupStage.setTitle("Minus");
        Main.popupStage.setScene(new Scene(root, 521,204));
        Main.popupStage.setResizable(false);
        Main.popupStage.show();
    }
    public void showShiftRightModT() throws IOException {
        if(Main.popupStage == null){
            Main.popupStage = new Stage();
        }
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/decryption/popups/ShiftRightT5Popup.fxml")));
        Main.popupStage.setTitle("Shift right");
        Main.popupStage.setScene(new Scene(root, 521,204));
        Main.popupStage.setResizable(false);
        Main.popupStage.show();
    }
    public void showShiftRightModU() throws IOException {
        if(Main.popupStage == null){
            Main.popupStage = new Stage();
        }
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/decryption/popups/ShiftRightU5Popup.fxml")));
        Main.popupStage.setTitle("Shift right");
        Main.popupStage.setScene(new Scene(root, 521,204));
        Main.popupStage.setResizable(false);
        Main.popupStage.show();
    }

    public void showLeftF() throws IOException {
        if(Main.popupStage == null){
            Main.popupStage = new Stage();
        }
        FPopup.left = true;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/decryption/popups/FPopup.fxml")));
        Main.popupStage.setTitle("F");
        Main.popupStage.setScene(new Scene(root, 521,204));
        Main.popupStage.setResizable(false);
        Main.popupStage.show();
    }
    public void showRightF() throws IOException {
        if(Main.popupStage == null){
            Main.popupStage = new Stage();
        }
        FPopup.left = false;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/decryption/popups/FPopup.fxml")));
        Main.popupStage.setTitle("F");
        Main.popupStage.setScene(new Scene(root, 521,204));
        Main.popupStage.setResizable(false);
        Main.popupStage.show();
    }
    public void showXorLeft() throws IOException {
        if(Main.popupStage == null){
            Main.popupStage = new Stage();
        }
        XorPopup.left = true;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/decryption/popups/XorPopup.fxml")));
        Main.popupStage.setTitle("XOR");
        Main.popupStage.setScene(new Scene(root, 521,204));
        Main.popupStage.setResizable(false);
        Main.popupStage.show();
    }

    public void showXorRight() throws IOException {
        if(Main.popupStage == null){
            Main.popupStage = new Stage();
        }
        XorPopup.left = false;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/decryption/popups/XorPopup.fxml")));
        Main.popupStage.setTitle("XOR");
        Main.popupStage.setScene(new Scene(root, 521,204));
        Main.popupStage.setResizable(false);
        Main.popupStage.show();
    }

    public void showMinusS0() throws IOException {
        if(Main.popupStage == null){
            Main.popupStage = new Stage();
        }
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/decryption/popups/MinusS0Popup.fxml")));
        Main.popupStage.setTitle("XOR");
        Main.popupStage.setScene(new Scene(root, 521,204));
        Main.popupStage.setResizable(false);
        Main.popupStage.show();
    }
    public void showMinusS1() throws IOException {
        if(Main.popupStage == null){
            Main.popupStage = new Stage();
        }
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/decryption/popups/MinusS1Popup.fxml")));
        Main.popupStage.setTitle("XOR");
        Main.popupStage.setScene(new Scene(root, 521,204));
        Main.popupStage.setResizable(false);
        Main.popupStage.show();
    }

}
