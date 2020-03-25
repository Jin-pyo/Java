package application;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Main extends Application {
	
	//////Property
	private int year;
	private char gender;
	private String name;
	private int ranking;
	
	//////TEXTFIELD
	private TextField txtName=new TextField();
	
	//////Label
	private Label lbl = new Label();
	
	//////BUTTON
	private Button btnSubmit = new Button("Submit Query");
	private Button btnResearch = new Button("Research");
	private Button btnExit = new Button("Exit");
	
	//////ChoiceBOx
	private ChoiceBox<String> cbYear=new ChoiceBox<>();
	private ChoiceBox<Character> cbGender=new ChoiceBox<>();	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			GridPane find = new GridPane();
			
			find.setPadding(new Insets(30,30,20,50));
			find.setVgap(15);
			find.setHgap(15);
			
			ColumnConstraints colCon = new ColumnConstraints();
			colCon.setPercentWidth(55);
			find.getColumnConstraints().addAll(colCon,colCon);
			
			
			//////////set up the Label of year
			find.add(new Label("Enter the Year: "), 0, 0);
			find.add(cbYear, 1, 0);
			 cbYear.getItems().addAll("2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010");
			 
			 
			/////////set up the label of gender
			find.add(new Label("Enter the Gender: "), 0, 1);
			find.add(cbGender, 1, 1);
			cbGender.getItems().addAll('M','F');
			
			/////////set up the label of Name
			find.add(new Label("Enter the Name: "), 0, 2);
			find.add(txtName, 1, 2);
			
			
			////set up LABEL finally
			find.add(lbl, 0, 3, 2, 1);
			
			///// set up the buttons
			HBox btn = new HBox(10);
			btnSubmit.setPrefWidth(100);
			btnResearch.setPrefWidth(80);
			btnExit.setPrefWidth(70);
			btn.getChildren().addAll(btnSubmit,btnResearch,btnExit);
			find.add(btn, 0, 4, 2, 1);
			
			
			///Execute when submit button is pressed
			btnSubmit.setOnAction(e->{
				lbl.setText("");
				
				try {
					//////get the value from user
					year=Integer.valueOf(cbYear.getValue());
					gender=cbGender.getValue();
					name=txtName.getText();
					
					////Name is empty
	                if(name.isEmpty()) {
	                    lbl.setText("Please enter a name.");
	                }
					else
					{
						////modify name for uppercase and lowercase
						name = txtName.getText().substring(0,1).toUpperCase() + txtName.getText().substring(1).toLowerCase();
						////get the ranking from files through "FindRanking" method
						ranking=Methods.findRanking(year, gender, name);
					
						
						
						if(ranking==0) //fail to find
						{
							lbl.setText("Can't find "+name+" in files");
							System.out.println("Can't Find "+name+" In resource ");
						}
						else if(ranking==-1) // path is wrong
						{
							lbl.setText("The path of file is wrong!!");
						}
						else 
						{
							if(gender=='M')
							{
								lbl.setText("Boy name "+name+" is ranked #"+ranking+" in "+year+" years");
							}
							else 
							{
								lbl.setText("Girl name "+name+" is ranked #"+ranking+" in "+year+" years");
							}
						}
					}
				} catch (NumberFormatException x) {
	                lbl.setText("Please choose a year.");
	            } catch(NullPointerException y) {
	                lbl.setText("Please choose a gender.");
	            }
			});
			
			//////Execute when research button is pressed
			btnResearch.setOnAction(e->{
				txtName.setText("");
				cbYear.getSelectionModel().clearSelection();
				cbGender.getSelectionModel().clearSelection();
				lbl.setText("");
				
			});
		
			///////Execute when exit button is pressed
			btnExit.setOnAction(e-> Platform.exit() );
			
			Scene scene = new Scene(find,350,250);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Search Name Ranking Application");
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
