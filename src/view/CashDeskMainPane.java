package view;


import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;




public class CashDeskMainPane extends BorderPane {
	public CashDeskMainPane(){
	    TabPane tabPane = new TabPane(); 	    
        Tab cashDeskTab = new Tab("Cash Desk");
        Tab itemTab = new Tab("Items");
        Tab adjustmentTab = new Tab("Settings");
        Tab logTab = new Tab("Log");
        tabPane.getTabs().add(cashDeskTab);
        tabPane.getTabs().add(itemTab);
        tabPane.getTabs().add(adjustmentTab);
        tabPane.getTabs().add(logTab);
	    this.setCenter(tabPane);





    }
}
