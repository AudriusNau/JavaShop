package controller;

import db.DbStrategy;
import db.ExcelDb;
import db.Item;
import db.TextDb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public TextArea cashDeskArea;
    public TextArea itemArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        DbStrategy txtReader = new TextDb() {};
        DbStrategy xlsReader = new ExcelDb(){};
        //List<String []> loadData = txtReader.load();
        //txtReader.save(loadData);
        xlsReader.load();
        List<String []> data = ((ExcelDb) xlsReader).getItems();
         xlsReader.save();
        for (String [] s : data){
           // cashDeskArea.appendText(s[0]+" " +s[1]+" "+ s[2]+" "+ s[3]+" "+ s[4]+"\n");
            itemArea.appendText(s[0]+" " +s[1]+" "+ s[2]+" "+ s[3]+" "+ s[4]+"\n");
        }

    }


        }
