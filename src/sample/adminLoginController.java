package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class adminLoginController {

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
    private Label fake;

    @FXML
    void initialize() {
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'adminLogin.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'adminLogin.fxml'.";
        assert login != null : "fx:id=\"login\" was not injected: check your FXML file 'adminLogin.fxml'.";
        assert signup != null : "fx:id=\"signup\" was not injected: check your FXML file 'adminLogin.fxml'.";
        assert fake != null : "fx:id=\"fake\" was not injected: check your FXML file 'adminLogin.fxml'.";

    }

    public void insideManager(Client client) {
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                Admins a = new Admins(username.getText(),password.getText(),"admin");
                client.boss.write(a);
                Object o = client.boss.read();
                if(o.equals("true")){
                    client.showAdminHomeScreen();
                }else if(o.equals("false")) fake.setText("    WRONG USERNAME AND PASSWORD");
            }
        });
        signup.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent event){
                client.showAdminSignupScreen();
            }
        });
    }
}
