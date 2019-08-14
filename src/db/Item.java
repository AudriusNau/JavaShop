package db;

import javafx.beans.property.SimpleStringProperty;

public class Item {
   private SimpleStringProperty id;
    private SimpleStringProperty description;
    private SimpleStringProperty group;
    private SimpleStringProperty price;
    private SimpleStringProperty stock;

    public Item(String id, String description, String group, String price, String stock ){
        this.id= new SimpleStringProperty(id);
        this.description= new SimpleStringProperty(description);
        this.group=new SimpleStringProperty(group);
        this.price=new SimpleStringProperty(price);
        this.stock= new SimpleStringProperty(stock);
    }
    public Item(){}

    public String getId() {
        return id.get();
    }

    public String getDescription() {
        return description.get();
    }

    public String getGroup() {
        return group.get();
    }


    public String getPrice() {
        return price.get();
    }


    public String getStock() {
        return stock.get();
    }

    public void setId(String id) {
        this.id=new SimpleStringProperty(id);
    }

    public void setDescription(String description) {
        this.description= new SimpleStringProperty(description);
    }

    public void setGroup(String group) {
        this.group= new SimpleStringProperty(group);
    }

    public void setPrice(String price) {
        this.price=new SimpleStringProperty(price);
    }

    public void setStock(String stock) {
        this.stock= new SimpleStringProperty(stock);
    }
}
