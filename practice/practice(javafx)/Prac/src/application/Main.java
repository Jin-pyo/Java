package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
//from w w  w . ja v  a2s  .co  m
public class Main extends Application {

  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    Group group = new Group();

    Rectangle rect = new Rectangle(100,20,300,200);
    
    rect.setArcHeight(15);
    rect.setArcWidth(15);

    rect.setStroke(Color.BLACK);
    group.getChildren().add(rect);
    
    Scene scene = new Scene(group, 500, 500);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}