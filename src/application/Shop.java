package application;

import db.DbStrategy;
import db.ExcelDb;
import db.TextDb;
import javafx.scene.control.TextArea;

import java.util.List;

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
        for (String [] s : data){
            itemArea.appendText(s[0]+" " +s[1]+" "+ s[2]+" "+ s[3]+" "+ s[4]+"\n");
        }
    }
    public void addToCart(int id){


    }

}
