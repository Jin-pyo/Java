package two;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class Task2 extends Application {
    public void start (Stage primaryStage) throws Exception {
        
    	GridPane pane=new GridPane();
    	pane.setPadding(new Insets(10,10,10,10));
    	pane.setHgap(3);
    	pane.setVgap(10);
    	
    	 pane.add(new Label("First Name"), 0, 0);
         pane.add(new TextField(),1,0,5,1);

         pane.add(new Label("Last Name"), 0, 1);
         pane.add(new TextField(), 1, 1,5,1);
         
         Label city = new Label("City");
         pane.add(city,0,2);
         //GridPane.setHalignment(city, HPos.CENTER);
         pane.add(new TextField(), 1, 2);
         
         
         ////////////////////////////////////////////////
         ChoiceBox<String> cbprov=new ChoiceBox();
         cbprov.getItems().addAll("Alberta","hhah");
         
         pane.add(new Label(" Province "),2,2);
         pane.add(cbprov, 3, 2);
         //////////////////////////////////////////////////
         
         
         //////////////////////////////////////////////////
         pane.add(new Label(" postal Code "), 4, 2);
         pane.add(new TextField(), 5, 2);
         //////////////////////////////////////////////////
         
         //////////////////////////////////////////////
         /////////////////////////////////////////////////
         /////////////////////////////////////////////////
         
         Button btnAdd = new Button("Add");
         btnAdd.setPrefWidth(200);
         pane.add(btnAdd, 0,3);
         Scene scene = new Scene(pane,600,175);
         
         //Button btnFirst= new Button("First");
         
         
         primaryStage.setTitle("Address Book");
         primaryStage.setScene(scene);
         primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }
}