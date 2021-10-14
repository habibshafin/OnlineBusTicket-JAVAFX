package sample;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Boolean;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;


public class LoginController {
    @FXML
    private Label fake;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button login;

    @FXML
    private Button signup;

    @FXML
    private Button admin;

    public void insideManager(Client Manager){
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                System.out.println(username.getText());
                Manager.userID = new Users(username.getText(),password.getText());
                Manager.boss.write(Manager.userID);
                Object o = Manager.boss.read();
                if(o.equals("true")){
                        Manager.showHomeScreen();
                        System.out.println(Manager.userID.getUsername());
                    }else if(o.equals("false")) fake.setText("    WRONG USERNAME AND PASSWORD");
                }
        });
        signup.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent event){
                System.out.println("sign up start");
                Manager.showSignupScreen();
            }
        });
        admin.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent event){
                Manager.showAdminLoginScreen();
            }
        });

    }


    @FXML
    void initialize() {
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'signup.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'signup.fxml'.";
        assert login != null : "fx:id=\"login\" was not injected: check your FXML file 'signup.fxml'.";
        assert signup != null : "fx:id=\"signup\" was not injected: check your FXML file 'signup.fxml'.";

    }
}

