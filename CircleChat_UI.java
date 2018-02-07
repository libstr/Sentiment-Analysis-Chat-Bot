 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circlechat_ui;

import java.sql.Connection;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author libin
 */
public class CircleChat_UI extends Application  implements EventHandler<ActionEvent>{
    public static Stage MainLogin;
    Button button;
    Connection conn;
    public static double offsetX =0,offsetY = 0;
    public static void drg(Parent root,Stage stage){
        
        root.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                offsetX = event.getSceneX();
                offsetY = event.getSceneY();
            }
        });
       
       root.setOnMouseDragged(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                stage.setX(event.getScreenX() - offsetX);
                stage.setY(event.getScreenY() - offsetY);
            }
        });
    }
   
    @Override
    public void start(Stage stage) throws Exception {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("Main_1.fxml"));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initStyle(StageStyle.TRANSPARENT);
        drg(root, stage);
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        MainLogin = stage;
        stage.setScene(scene);
        stage.show();
        CheckConnection();
        }catch(Exception e){
            e.printStackTrace();
        }}
    public void CheckConnection(){ 
        conn = SqlConnection.DbConnector();
        if(conn != null){
            System.out.println("Connection successful");
        }
        else{
            System.out.println("Connection not successful");
            System.exit(1);
        
        }
    }
    
    
    
    @Override
    public void handle(ActionEvent event){
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
