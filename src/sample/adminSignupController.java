package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class adminSignupController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField username;

    @FXML
    private PasswordField passworda;

    @FXML
    private PasswordField passwordb;

    @FXML
    private Button ok;

    @FXML
    private Button cancel;

    @FXML
    void initialize() {
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'adminSignup.fxml'.";
        assert passworda != null : "fx:id=\"passworda\" was not injected: check your FXML file 'adminSignup.fxml'.";
        assert passwordb != null : "fx:id=\"passwordb\" was not injected: check your FXML file 'adminSignup.fxml'.";
        assert ok != null : "fx:id=\"ok\" was not injected: check your FXML file 'adminSignup.fxml'.";
        assert cancel != null : "fx:id=\"cancel\" was not injected: check your FXML file 'adminSignup.fxml'.";

    }

    public void insideManager(Client client) {
        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                if(passworda.getText().equals(passwordb.getText())){
                NewAdmin newadmin = new NewAdmin(username.getText(), passworda.getText());
                client.boss.write(newadmin);
                Object o = client.boss.read();
                if(o.equals("done")){
                client.showAdminHomeScreen();
                }
                else {
                    client.showAdminSignupScreen();
                    System.out.println("passwords didnt match");
                }
                }
            }});
        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                client.showAdminLoginScreen();
            }
        });
    }
}
