package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

//import static sample.ClientReadThread.listusers;

public class signupController {

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

    public void insideManager(Client Manager){
        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                if(passworda.getText().equals(passwordb.getText())) {
                    if (username.getText() != null && passworda.getText() != null) {
                        NewUsers newuser = new NewUsers(username.getText(), passworda.getText());
                        Manager.boss.write(newuser);
                        Object o = Manager.boss.read();
                        if (o.equals("done")) {
                            Manager.showHomeScreen();
                        }
                    } else {
                        Manager.showSignupScreen();
                        System.out.println("passwords didnt match");

                    }
                }
                else
                {
                    Manager.showSignupScreen();
                    System.out.println("passwords didnt match");
                }
            }
        });
        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Manager.showLoginScreen();
            }
        });
        }
    /*public static void writeUsers(List<Users> b) throws IOException {
        FileWriter fw = new FileWriter("G:\\Java practice\\login - thread try\\src\\sample\\users.txt");
        for (int z = 0; z < b.size(); z++) {
            fw.write(b.get(z).getUsername()+","+b.get(z).getPassword());
            fw.write(System.lineSeparator());
        }
        fw.close();
    }
    public String[] readUser() {
        String [] userS = new String[1000];

        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader("G:\\Java practice\\login - thread try\\src\\sample\\users.txt"));
            int i = 0;
            while (true) {
                line = br.readLine();
                if (line == null) break;
                userS[i] = line;
                i++;
            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return userS;
    }
    public List<Users> UserFormation (String[] s){
        List<Users> templist = new ArrayList<>();
        for (String x : s) {
            if (x == null)
                break;
            else {
                String[] array = x.split(",");
                templist.add(new Users(array[0],array[1]));
            }
        }
        return templist;
    }*/

    @FXML
    void initialize() {
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'signup.fxml'.";
        assert passworda != null : "fx:id=\"passworda\" was not injected: check your FXML file 'signup.fxml'.";
        assert passwordb != null : "fx:id=\"passwordb\" was not injected: check your FXML file 'signup.fxml'.";
        assert ok != null : "fx:id=\"ok\" was not injected: check your FXML file 'signup.fxml'.";
        assert cancel != null : "fx:id=\"cancel\" was not injected: check your FXML file 'signup.fxml'.";

    }
}

