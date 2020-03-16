package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class MyJavaFX extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {

		final int ROWSIZE=4;
		final int BOARDSIZE=32;
		
		Rectangle [] rect = new Rectangle[BOARDSIZE];
		int cnt =0;
		
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<ROWSIZE;j++)
			{
				 if ((i%2) == 0) {
	                    rect[cnt] = new Rectangle(j*80+40, i*40,40,40);
	        
	                }
				 else {
	                    rect[cnt] = new Rectangle(j*80, i*40,40,40);
	                  
	                }
				 cnt++;
				
			}
		}
		
		Pane p = new Pane(rect);
		
		Scene scene = new Scene(p,320,320);
		primaryStage.setTitle("First Stage");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	
	}
	public static void main(String[] args) {
		launch(args);
	}

}
