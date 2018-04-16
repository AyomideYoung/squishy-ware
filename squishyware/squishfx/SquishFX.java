package squishyware.squishfx;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Bakare Ayomide
 */
public class SquishFX extends Application {

    public static void main(String[] args){
    SquishFX.launch(args);
    }
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        
        GridPane pane = loadLoginPane();
        
        
        Scene scene = new Scene(pane);
        transformScene(scene);
        
        
        primaryStage.setScene(scene);
       
        primaryStage.show();
    }

    private GridPane loadLoginPane() {
      Label usernameLabel = new Label("Username: "); 
      Label passwordLabel = new Label("Password: ");
      
      TextField usernameField = new TextField();
      PasswordField passwordField = new PasswordField();
      usernameField.setPrefColumnCount(15);
      passwordField.setPrefColumnCount(15);
      
      GridPane pane = new GridPane();
      pane.addRow(0, usernameLabel,usernameField);
      pane.addRow(1, passwordLabel,passwordField);
      pane.setHgap(10);
      pane.setVgap(10);
      
      return pane;
    }

    private void transformScene(Scene scene) {
     
    }
    
}
