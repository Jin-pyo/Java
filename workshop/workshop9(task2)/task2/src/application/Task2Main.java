/**********************************************
Workshop 9 Task2
Course: JAC444NAB
Last Name:Ju
First Name:Jinpyo
ID: 134444181
This assignment represents my own work in accordance with Seneca
Academic Policy.
Signature
Due Date : April 3, 2020
**********************************************/

package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.Map;

public class Task2Main extends Application {
    private final Label lblState = new Label("Enter the country:");
    private Label lblAnswer = new Label();

    private TextField txtState = new TextField();

    private final Button btnSubmit = new Button("submit");

    private static Map<String,String> database = new HashMap<>();

    public void start(Stage primaryStage) {
        VBox main = new VBox(10);
        main.setAlignment(Pos.CENTER);

        HBox states = new HBox(10);
        states.setAlignment(Pos.CENTER);
        states.getChildren().addAll(lblState,txtState);

        main.getChildren().addAll(states,lblAnswer,btnSubmit);

        initialize();

        txtState.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER) {
                btnSubmit.fire();
            }
        });

        btnSubmit.setOnAction(e -> {
            lblAnswer.setText("");
            String query = txtState.getText();

            if(database.containsKey(query.toUpperCase())) {
                lblAnswer.setText("The capital of " + query + " is " + database.get(query.toUpperCase()));
            }
            else if(query.isEmpty()) {
                lblAnswer.setText("Please enter a country.");
            }
            else {
                lblAnswer.setText("country not found.");
            }
        });

        Scene scene = new Scene(main,300,200);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Search capital");
        primaryStage.show();
    }

    private static void initialize() {
    	database.put("CANADA", "OTTAWA");
    	database.put("UNITED STATES", "WASHINGTON, D.C.");
    	database.put("UNITED KINGDOM", "LONDON");
    	database.put("FRANCE", "PARIS");
    	database.put("GERMANY", "BERLIN");
    	database.put("SOUTH KOREA", "SEOUL");
    	database.put("JAPAN", "TOKYO");
    	database.put("CHINA", "BEIJING");
    	database.put("PHILIPPINES", "MANILA");
    	database.put("RUSSIA", "MOSCOW");
    	database.put("NETHERLANDS", "AMSTERDAM");
    	database.put("NORWAY", "OSLO");
    	database.put("MEXICO", "MEXICO CITY");
    	database.put("BRAZIL", "BRASILIA");
    	database.put("URUGUAY", "MONTEVIDEO");
    	database.put("IRAN", "TEHRAN");
    	database.put("PAKISTAN", "ISLAMABAD");
        database.put("AUSTRALIA", "CANBERRA");
        database.put("ARGENTINA", "BUENOS AIRES");
        database.put("BELGIUM", "BRUSSELS");
        database.put("COLOMBIA", "BOGOTÁ");
        database.put("CROATIA", "ZAGREB");
        database.put("CUBA", "HAVANA");
        database.put("CHILE", "SANTIAGO");
        database.put("DENMARK", "COPENHAGEN");
        
    }

    public static void main(String[] args) { launch(args); }
}