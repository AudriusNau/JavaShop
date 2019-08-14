package view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CashDeskView {
	private Stage stage = new Stage();		
		
	public CashDeskView(){
		stage.setTitle("Cash Desk view");
		stage.setResizable(false);		
		stage.setX(20);
		stage.setY(20);
		Group root = new Group();
		Scene scene = new Scene(root, 750, 500);
		BorderPane borderPane = new CashDeskMainPane();
		borderPane.prefHeightProperty().bind(scene.heightProperty());
		borderPane.prefWidthProperty().bind(scene.widthProperty());
		root.getChildren().add(borderPane);
		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();		
	}
}
