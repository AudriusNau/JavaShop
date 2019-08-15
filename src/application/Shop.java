package application;

import db.DbStrategy;
import db.ExcelDb;
import db.TextDb;
import javafx.scene.control.TextArea;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class Shop {

    public TextArea itemArea;
    public void startCheckOut(){
        DbStrategy txtReader = new TextDb() {};
        DbStrategy xlsReader = new ExcelDb(){};
        txtReader.load();
        List<String []> data = ((TextDb) txtReader).getItems();
        txtReader.save();
       /* xlsReader.load();
        List<String []> data = ((ExcelDb) xlsReader).getItems();
         xlsReader.save();*/

    }
    public void addToCart(int id){


    }
    public void loadData(){
        String loadMode="";
        try{
            InputStream input = new FileInputStream("src//evaluation.properties");
            Properties prop = new Properties();
            prop.load(input);
            loadMode=prop.getProperty("load.mode");
            input.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();  }

    }
}


