/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circlechat_ui;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author libin
 */
public class RegisterController implements Initializable {
    
   
    @FXML
    private JFXTextField username;
     @FXML
    private JFXTextField first;
              @FXML
    private JFXTextField last;
               @FXML
    private JFXPasswordField password;
    
    private AnchorPane rootPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     @FXML
    private void handleClose() {
        
        MainController.primaryStage.hide();
        CircleChat_UI.MainLogin.show();
    }
    @FXML
    private void inserting(){
        InsertRecords i = new InsertRecords();
        i.insert(first.getText(),last.getText(),username.getText(),password.getText());
        handleClose();
    }
}
