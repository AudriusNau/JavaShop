package controller;

import db.DbStrategy;
import db.ExcelDb;
import db.TextDb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;


import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.Properties;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public TextArea cashDeskArea;
    public TextArea itemArea;

    @FXML
     ChoiceBox dbMode;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        dbMode.setItems(loadMode);
        dbMode.setValue("txt");





    }
    ObservableList<String> loadMode = FXCollections.observableArrayList("txt", "excel");

    public void setLoadMode(){
        String selectedChoice = dbMode.getValue().toString();
        Properties prop = new Properties();
        try{
            InputStream input = new FileInputStream("src//evaluation.properties");

            prop.load(input);
            prop.setProperty("load.mode", selectedChoice);
            System.out.println(selectedChoice);
            input.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();  }

        try{
            OutputStream output = new FileOutputStream("src//evaluation.properties");
            prop.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
