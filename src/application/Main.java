package application;

import db.DbStrategy;
import db.TextDb;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {
    public TextArea cashDeskArea;
    public TextArea itemArea;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("cashDesk.fxml"));
        primaryStage.setTitle("Cash Desk View");
        primaryStage.setScene(new Scene(root, 750, 500));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
