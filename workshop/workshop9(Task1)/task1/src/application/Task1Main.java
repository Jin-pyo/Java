/**********************************************
Workshop 9 Task1
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

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashSet;
import java.util.Set;


public class Task1Main extends Application {
	
	private Label numbers = new Label("Two randomly generated numbers are " + num1 + " and " + num2);
    private Label addition = new Label("What is the addition of "  + num1 + " and " + num2 + "?");
    private Label subtraction = new Label("What is the subtraction of "  + num1 + " and " + num2 + "?");
    private Label multiply = new Label("What is the multiplication of "  + num1 + " and " + num2 + "?");
    private Label division = new Label("What is the division of "  + num1 + " and " + num2 + "?");
    private Label correct = new Label();
    private Label wrong = new Label();
    private Label status = new Label();
    
    private Label Addstatus=new Label();
    private Label MinStatus=new Label();
    private Label MulStatus=new Label();
    private Label DivStatus=new Label();

    private final Button btnSubmit = new Button("Submit");
    private final Button btnReset = new Button("Reset");

    private TextField sum = new TextField();
    private TextField subtract = new TextField();
    private TextField product = new TextField();
    private TextField divided = new TextField();
    
    private static Set<Double> answers = new HashSet<>();
    private static int num1 = (int)(Math.random()*10)+1;
    private static int num2 = (int)(Math.random()*10)+1;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			 VBox main = new VBox(5);
		        main.setAlignment(Pos.CENTER);

		        HBox add = new HBox(5);
		        add.setAlignment(Pos.CENTER);
		        add.getChildren().addAll(addition, sum);

		        HBox minus = new HBox(5);
		        minus.setAlignment(Pos.CENTER);
		        minus.getChildren().addAll(subtraction, subtract);

		        HBox times = new HBox(5);
		        times.setAlignment(Pos.CENTER);
		        times.getChildren().addAll(multiply, product);

		        HBox divide = new HBox(5);
		        divide.setAlignment(Pos.CENTER);
		        divide.getChildren().addAll(division, divided);

		        HBox buttons = new HBox(5);
		        buttons.setAlignment(Pos.CENTER);
		        buttons.getChildren().addAll(btnSubmit,btnReset);
	        
		        //////////////EXECUTE
		        btnSubmit.setOnAction(e->{
		        	answers.clear();
		        	status.setText(" ");
		        	correct.setText(" ");
	                 wrong.setText(" ");
	                 Addstatus.setText(" ");
	                 MinStatus.setText(" ");
	                 MulStatus.setText(" ");
	                 DivStatus.setText(" ");
		        	int count=0;
		        
		        	answers = Validator.validateInput(sum.getText(), subtract.getText(), product.getText(), divided.getText());
		        	
		        	 if(!answers.isEmpty()) {
		        		 ///////ADD
		        		double inputAdd=Double.valueOf(sum.getText());
		        		if(!Validator.checkAdd(num1, num2,inputAdd))
		        		{
		        			if(Validator.checkAddContain(inputAdd))
		        			{
		        				Addstatus.setText("ADD: You already answer"+sum.getText()+" Try a different answer." );
		        			}
		        		}
		        		else {count++;}
		        		//////////ADD-END
		        		
		        		////////Minus
		        		double inputMinus=Double.valueOf(subtract.getText());
		        		if(!Validator.checkMinus(num1, num2,inputMinus))
		        		{
		        			if(Validator.checkMinusContain(inputMinus))
		        			{
		        				MinStatus.setText("MIN: You already answer"+subtract.getText()+" Try a different answer." );
		        			}
		        		}
		        		else {count++;}
		        		
		        		////////Minus-END
		        		
		        		///////multiple
		        		double inputMul=Double.valueOf(product.getText());
		        		if(!Validator.checkMul(num1, num2,inputMul))
		        		{
		        			if(Validator.checkMulContain(inputMul))
		        			{
		        				MulStatus.setText("Mul: You already answer"+product.getText()+" Try a different answer." );
		        			}
		        		}
		        		else {count++;}
		        		///////multiple-END
		        		
		        		///////Division
		        		double inputDiv=Double.valueOf(divided.getText());
		        		if(!Validator.checkDiv(num1, num2,inputDiv))
		        		{
		        			if(Validator.checkDivContain(inputDiv))
		        			{
		        				DivStatus.setText("Div: You already answer"+divided.getText()+" Try a different answer." );
		        			}
		        		}
		        		else {count++;}
		        		///////Division-END
		        		
		        		
		        		////////RESULT 
		        		correct.setText("Number of Correct : "+count);
			            wrong.setText("Number of Wrong : "+ (4-count)); 
		             }
		             else {
		                 correct.setText("");
		                 wrong.setText("");
		                 status.setText("Please enter valid doubles.");
		                 Addstatus.setText(" ");
		                 MinStatus.setText(" ");
		                 MulStatus.setText(" ");
		                 DivStatus.setText(" ");
		             }
		        });
		      

		        btnReset.setOnAction(e -> {
		            num1 = (int)(Math.random()*10)+1;
		            num2 = (int)(Math.random()*10)+1;
		            answers.clear();
		            Validator.clearSet();
		            
		            sum.setText("");
		            subtract.setText("");
		            product.setText("");
		            divided.setText("");

		            correct.setText("");
		            wrong.setText("");
		            status.setText("");
		            
		            Addstatus.setText(" ");
	                 MinStatus.setText(" ");
	                 MulStatus.setText(" ");
	                 DivStatus.setText(" ");

		            numbers.setText("Two randomly generated numbers are " + num1 + " and " + num2);
		            addition.setText("What is the addition of "  + num1 + " and " + num2 + "?");
		            subtraction.setText("What is the subtraction of "  + num1 + " and " + num2 + "?");
		            multiply.setText("What is the multiplication of "  + num1 + " and " + num2 + "?");
		            division.setText("What is the division of "  + num1 + " and " + num2 + "?");
		        });
		         main.getChildren().addAll(numbers,add,minus,times,divide,correct,wrong,status,buttons,Addstatus,MinStatus,MulStatus,DivStatus);


		    Scene scene = new Scene(main, 380, 380);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
