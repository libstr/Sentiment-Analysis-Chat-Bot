/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circlechat_ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import circlechat_ui.loginModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.sql.SQLException;

/**
 *
 * @author libin
 */
public class MainController implements Initializable {
    public static Stage primaryStage;
    loginModel model = new loginModel();
    @FXML
    private Label label;
    
    
    
    private AnchorPane rootPane;
    @FXML
    public JFXTextField username;
    @FXML
    public JFXPasswordField password;
    @FXML
    private JFXButton b;
    
    @FXML
    private void handleClose() {
        
        System.exit(0);
    }
    
   
    @FXML
    private void registerClicked() throws IOException{
        primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Register_1.fxml"));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("Send Mail");
        Scene scene = new Scene(root);
        CircleChat_UI.drg(root, primaryStage);
        primaryStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.show();
        CircleChat_UI.MainLogin.hide();
    }
     
    private void LoginClicked() throws IOException{
        primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Register_1_1.fxml"));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("Send Mail");
        Scene scene = new Scene(root);
        CircleChat_UI.drg(root, primaryStage);
        primaryStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.show();
        CircleChat_UI.MainLogin.hide();
    }
    
    @FXML
    public void Login() throws SQLException
    {
        /*InsertRecords i2 = new InsertRecords();
        i2.selectDB(username.getText());*/
        try{
        if(model.isLogin(username.getText(),password.getText())){
            System.out.println("Hello");
            LoginClicked();
        }
        else{
            System.out.println("Username and password is not correct");
        }
            
        }catch(Exception e)
        {
            System.out.println("Username and password is not correct E");
           e.printStackTrace();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
