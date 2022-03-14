package controllers.encryption.rounds;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import sample.Main;
import sample.RC6;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import controllers.encryption.popups.*;

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
    public Label roundCounter;

    public static final int WIDTH = 520,HEIGHT_1= 270, HEIGHT_2 = 204;




    @Override
    public void initialize ( URL url, ResourceBundle resourceBundle ) {
        //Numbers displayed Hex signed 2's complement

        Main.deselect(AStart);
        roundCounter.setText(String.valueOf(Main.roundCounter));
        byte[] int_to_bytes;
        //Start
        int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).Astart);
        AStart.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).Bstart);
        BStart.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).Cstart);
        CStart.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).Dstart);
        DStart.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        //Middle
        int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).AxorT);
        AxorT.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).CxorU);
        CxorU.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());


        //Finish
        int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).Afinish);
        AFinish.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).Bfinish);
        BFinish.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).Cfinish);
        CFinish.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

        int_to_bytes = Main.intToByteArray(RC6.encryptionRoundData.get(Main.roundCounter).Dfinish);
        DFinish.setText(RC6.byteArrayToHex(int_to_bytes).replaceAll("..", "$0 ").toUpperCase());

    }

    public void next ( ) throws IOException {
        Main.roundCounter++;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/encryption/rounds/MiddleRound.fxml")));
        Main.primaryStage.setTitle("Middle Round");
        Main.primaryStage.setScene(new Scene(root, 773, 625));
    }

    public void showUpperLeftXOR() throws IOException{
        if(Main.popupStage == null){
            Main.popupStage = new Stage();
        }
        XORPopup.left = 0;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/encryption/popups/XORPopup.fxml")));
        Main.popupStage.setTitle("XOR");
        Main.popupStage.setScene(new Scene(root, WIDTH,HEIGHT_1));
        Main.popupStage.setResizable(false);
        Main.popupStage.show();
    }
    public void showUpperRightXOR() throws IOException{
        if(Main.popupStage == null){
            Main.popupStage = new Stage();
        }
        XORPopup.left = 1;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/encryption/popups/XORPopup.fxml")));
        Main.popupStage.setTitle("XOR");
        Main.popupStage.setScene(new Scene(root, WIDTH,HEIGHT_1));
        Main.popupStage.setResizable(false);
        Main.popupStage.show();
    }

    public void showUpperLeftSL() throws IOException{
        if(Main.popupStage == null){
            Main.popupStage = new Stage();
        }
        ShiftLeftLgWordPopup.left = 0;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/encryption/popups/ShiftLeftLgWordPopup.fxml")));
        Main.popupStage.setTitle("Shift left");
        Main.popupStage.setScene(new Scene(root, WIDTH,HEIGHT_2));
        Main.popupStage.setResizable(false);
        Main.popupStage.show();
    }


    public void showUpperRightSL() throws IOException{
        if(Main.popupStage == null){
            Main.popupStage = new Stage();
        }
        ShiftLeftLgWordPopup.left = 1;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/encryption/popups/ShiftLeftLgWordPopup.fxml")));
        Main.popupStage.setTitle("Shift left");
        Main.popupStage.setScene(new Scene(root, WIDTH,HEIGHT_2));
        Main.popupStage.setResizable(false);
        Main.popupStage.show();
    }

    public void showDownLeftSL() throws IOException{
        if(Main.popupStage == null){
            Main.popupStage = new Stage();
        }
        ShiftLeftLgWordPopup.left = 0;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/encryption/popups/ShiftLeftU5.fxml")));
        Main.popupStage.setTitle("Shift left U ");
        Main.popupStage.setScene(new Scene(root, WIDTH,HEIGHT_1));
        Main.popupStage.setResizable(false);
        Main.popupStage.show();
    }


    public void showDownRightSL() throws IOException{
        if(Main.popupStage == null){
            Main.popupStage = new Stage();
        }
        ShiftLeftLgWordPopup.left = 1;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/encryption/popups/ShiftLeftT5.fxml")));
        Main.popupStage.setTitle("Shift left T");
        Main.popupStage.setScene(new Scene(root, WIDTH,HEIGHT_1));
        Main.popupStage.setResizable(false);
        Main.popupStage.show();
    }

    public void showAddS0() throws IOException{
        if(Main.popupStage == null){
            Main.popupStage = new Stage();
        }
        AddPopup.code = "S0";
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/encryption/popups/AddPopup.fxml")));
        Main.popupStage.setTitle("Add");
        Main.popupStage.setScene(new Scene(root, WIDTH,HEIGHT_1));
        Main.popupStage.setResizable(false);
        Main.popupStage.show();
    }

    public void showAddS1() throws IOException{
        if(Main.popupStage == null){
            Main.popupStage = new Stage();
        }
        AddPopup.code = "S1";
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/encryption/popups/AddPopup.fxml")));
        Main.popupStage.setTitle("Add");
        Main.popupStage.setScene(new Scene(root, WIDTH,HEIGHT_1));
        Main.popupStage.setResizable(false);
        Main.popupStage.show();
    }


    public void showAdd2i() throws IOException{
        if(Main.popupStage == null){
            Main.popupStage = new Stage();
        }
        AddPopup.code = "S2i";
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/encryption/popups/AddPopup.fxml")));
        Main.popupStage.setTitle("Add");
        Main.popupStage.setScene(new Scene(root, WIDTH,HEIGHT_1));
        Main.popupStage.setResizable(false);
        Main.popupStage.show();
    }

    public void showAdd2i1() throws IOException{
        if(Main.popupStage == null){
            Main.popupStage = new Stage();
        }
        AddPopup.code = "S2i1";
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/encryption/popups/AddPopup.fxml")));
        Main.popupStage.setTitle("Add");
        Main.popupStage.setScene(new Scene(root, WIDTH,HEIGHT_1));
        Main.popupStage.setResizable(false);
        Main.popupStage.show();
    }

    public void showUpperLeftF() throws IOException{
        if(Main.popupStage == null){
            Main.popupStage = new Stage();
        }
        FPopup.left = 0;
        FPopup.firstRound = true;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/encryption/popups/FPopup.fxml")));
        Main.popupStage.setTitle("F");
        Main.popupStage.setScene(new Scene(root, WIDTH,HEIGHT_2));
        Main.popupStage.setResizable(false);
        Main.popupStage.show();
    }

    public void showUpperRightF() throws IOException{
        if(Main.popupStage == null){
            Main.popupStage = new Stage();
        }
        FPopup.left = 1;
        FPopup.firstRound = true;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/forms/encryption/popups/FPopup.fxml")));
        Main.popupStage.setTitle("F");
        Main.popupStage.setScene(new Scene(root, WIDTH,HEIGHT_2));
        Main.popupStage.setResizable(false);
        Main.popupStage.show();
    }

}
