package util;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    public static Stage primaryStage;
    public static int roundCounter = 0;

    public static byte[] intToByteArray( int value){
        return new byte[] {
                (byte)value,
                (byte)(value >>> 8),
                (byte)(value >>> 16),
                (byte)(value >>> 24)
        };
    }

    public static void deselect( TextField textField) {
        Platform.runLater(() -> {
            if (textField.getText().length() > 0 &&
                    textField.selectionProperty().get().getEnd() == 0) {
                deselect(textField);
            }else{
                textField.selectEnd();
                textField.deselect();
            }
        });
    }
    //TODO prebaci dbljinu linije na 2
    @Override
    public void start(Stage primaryStage) throws Exception{
        Main.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../forms/EnterParameters.fxml")));

        primaryStage.setTitle("Enter parameters");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
