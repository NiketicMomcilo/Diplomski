package controllers.decryption;

import controllers.decryption.popups.FPopup;
import controllers.decryption.popups.MinusPopup;
import controllers.decryption.popups.ShiftLeftLgWord;
import controllers.decryption.popups.XorPopup;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class FirstRound implements Initializable {

    public TextField AStart;
    public TextField BStart;
    public TextField CStart;
    public TextField DStart;

    public TextField AFinish;
    public TextField BFinish;
    public TextField CFinish;
    public TextField DFinish;

    public Button nextButton;

    public TextField AminS2r2;
    public TextField CminS2r3;

    public TextField Ashift;
    public TextField Bshift;
    public TextField Cshift;
    public TextField Dshift;
    public Circle f21;
    public Circle f211;
    public Label roundCounter;

    public static final int WIDTH = 520,HEIGHT_1= 270, HEIGHT_2 = 204;

    @Override
    public void initialize ( URL url, ResourceBundle resourceBundle ) {
        Main.deselect(AStart);
        roundCounter.setText(String.valueOf(Main.roundCounter));
        byte[] int_to_bytes;

        int_to_bytes = Main.intToByteArray
                (RC6.dectyptionRoundData.get(Main.roundCounter).Astart);
        AStart.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray
                (RC6.dectyptionRoundData.get(Main.roundCounter).Bstart);
        BStart.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray
                (RC6.dectyptionRoundData.get(Main.roundCounter).Cstart);
        CStart.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray
                (RC6.dectyptionRoundData.get(Main.roundCounter).Dstart);
        DStart.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());



        int_to_bytes = Main.intToByteArray
                (RC6.dectyptionRoundData.get(Main.roundCounter).AminS2r2);
        AminS2r2.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray
                (RC6.dectyptionRoundData.get(Main.roundCounter).CminS2r3);
        CminS2r3.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());



        int_to_bytes = Main.intToByteArray
                (RC6.dectyptionRoundData.get(Main.roundCounter).Ashift);
        Ashift.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray
                (RC6.dectyptionRoundData.get(Main.roundCounter).Bshift);
        Bshift.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray
                (RC6.dectyptionRoundData.get(Main.roundCounter).Cshift);
        Cshift.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray
                (RC6.dectyptionRoundData.get(Main.roundCounter).Dshift);
        Dshift.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());



        int_to_bytes = Main.intToByteArray
                (RC6.dectyptionRoundData.get(Main.roundCounter).AendRound);
        AFinish.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray
                (RC6.dectyptionRoundData.get(Main.roundCounter).BendRound);
        BFinish.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray
                (RC6.dectyptionRoundData.get(Main.roundCounter).CendRound);
        CFinish.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray
                (RC6.dectyptionRoundData.get(Main.roundCounter).DendRound);
        DFinish.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

    }

    public void next ( ) throws IOException {
        Main.roundCounter++;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/decryption/MiddleRound.fxml")));
        Main.primaryStage.setTitle("FirstRound");
        Main.primaryStage.setScene(new Scene(root, 773, 683));
    }

    public void showMinus2r2() throws IOException {
        if(Main.popupStage == null){
            Main.popupStage = new Stage();
        }
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/decryption/popups/Minus2r2Popup.fxml")));
        Main.popupStage.setTitle("Minus");
        Main.popupStage.setScene(new Scene(root, WIDTH,HEIGHT_1));
        Main.popupStage.setResizable(false);
        Main.popupStage.show();
    }
    public void showMinus2r3() throws IOException {
        if(Main.popupStage == null){
            Main.popupStage = new Stage();
        }
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/decryption/popups/Minus2r3Popup.fxml")));
        Main.popupStage.setTitle("Minus");
        Main.popupStage.setScene(new Scene(root, WIDTH,HEIGHT_1));
        Main.popupStage.setResizable(false);
        Main.popupStage.show();
    }

    public void showMinusDownLeft() throws IOException {
        if(Main.popupStage == null){
            Main.popupStage = new Stage();
        }
        MinusPopup.left = true;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/decryption/popups/MinusPopup.fxml")));
        Main.popupStage.setTitle("Minus");
        Main.popupStage.setScene(new Scene(root, WIDTH,HEIGHT_1));
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
        Main.popupStage.setScene(new Scene(root, WIDTH,HEIGHT_1));
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
        Main.popupStage.setScene(new Scene(root, WIDTH,HEIGHT_2));
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
        Main.popupStage.setScene(new Scene(root, WIDTH,HEIGHT_2));
        Main.popupStage.setResizable(false);
        Main.popupStage.show();
    }
    public void showRightModT() throws IOException {
        if(Main.popupStage == null){
            Main.popupStage = new Stage();
        }
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/decryption/popups/ShiftRightT5Popup.fxml")));
        Main.popupStage.setTitle("Shift right");
        Main.popupStage.setScene(new Scene(root, WIDTH,HEIGHT_1));
        Main.popupStage.setResizable(false);
        Main.popupStage.show();
    }
    public void showRightModU() throws IOException {
        if(Main.popupStage == null){
            Main.popupStage = new Stage();
        }
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/decryption/popups/ShiftRightU5Popup.fxml")));
        Main.popupStage.setTitle("Shift right");
        Main.popupStage.setScene(new Scene(root, WIDTH,HEIGHT_1));
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
        Main.popupStage.setScene(new Scene(root, WIDTH,HEIGHT_2));
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
        Main.popupStage.setScene(new Scene(root, WIDTH,HEIGHT_2));
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
        Main.popupStage.setScene(new Scene(root, WIDTH,HEIGHT_1));
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
        Main.popupStage.setScene(new Scene(root, WIDTH,HEIGHT_1));
        Main.popupStage.setResizable(false);
        Main.popupStage.show();
    }




}
