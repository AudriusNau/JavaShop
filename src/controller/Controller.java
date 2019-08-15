package controller;

import db.DbStrategy;
import db.TextDb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;

public class Controller implements Initializable {


    public TextArea cashDeskArea;
    public TextArea itemArea;
    public TextField codeInput;
    private List<String[]> cartList;
    DbStrategy reader;
    @FXML
     ChoiceBox dbMode;
    @FXML
     TextField totalSumField;
    private double totalSum;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        dbMode.setItems(loadMode);
        dbMode.setValue("txt");
        totalSum = 0;
        this.cartList = new ArrayList<>();
        reader = new TextDb() {};
        reader.load();
        List<String []> data = ((TextDb) reader).getItems();
        printAllItems(data);


    }
    ObservableList<String> loadMode = FXCollections.observableArrayList("txt", "excel");

    public void setLoadMode(){
        String selectedChoice = dbMode.getValue().toString();
        Properties prop = new Properties();

        prop.setProperty("load.mode", selectedChoice);

        try{
            OutputStream output = new FileOutputStream("src//evaluation.properties");
            prop.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addToCart(){
        String code =codeInput.getText();
        List<String[]> items = reader.getItems();

        AtomicBoolean exists = new AtomicBoolean(false);
        items.forEach(a->{
            if(a[0].equals(code)){

                exists.set(true);
                int itemsStock = Integer.parseInt(a[4]);// count stock
                if(itemsStock > 0) {
                    a[4] = String.valueOf(itemsStock-1);

                    addItemToCartList(a);//add to cart list
                    totalSum+= Double.parseDouble(a[3]);// count total sum
                }else{
                    new Alert(Alert.AlertType.WARNING, "No items left!").showAndWait();
                }
            }
        });
        if(!exists.get())new Alert(Alert.AlertType.WARNING, "No items exists!").showAndWait();

        printItem(cartList);
        updateSum();



    }
    public void removeFromCart(){
        String code =codeInput.getText();
        AtomicBoolean exists = new AtomicBoolean(false);
        cartList.forEach(a->{
            if(a[0].equals(code)){
                exists.set(true);
                int stock = Integer.parseInt(a[4])+1;// count stock
                a[4] = String.valueOf(stock-1);
                totalSum-= Double.parseDouble(a[3]);// count total sum

            }
        });
        if(!exists.get())new Alert(Alert.AlertType.WARNING, "No items exists!").showAndWait();
        printItem(cartList);
        updateSum();
    }
    public void addItemToCartList(String[] item){
        AtomicBoolean exists = new AtomicBoolean(false);
        this.cartList.forEach(a->{
            if(a[0].equals(item[0])){
                exists.set(true);
                int stock = Integer.parseInt(a[4])+1;// count stock
                a[4]=(String.valueOf(stock));
            }
        });
        if(!exists.get()){
            item[4]="1";
            cartList.add(item);
        }
        updateSum();
    }
    public void printAllItems(List<String []> data){
        for (String [] s : data){
            itemArea.appendText(s[0]+" " +s[1]+" "+ s[2]+" "+ s[3]+" "+ s[4]+"\n");
        }
    }
    public void printItem(List<String[]> list){
        String toWrite="";
        for(String[] s: list){
            toWrite+= (" " +s[1]+"   "+ s[2]+"          "+ s[3]+"     "+s[4]+"\n");
        }
        cashDeskArea.setText(toWrite);
    }
    public void updateSum(){
        totalSumField.setText(Double.toString(this.totalSum));
    }



}
