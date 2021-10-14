package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;


import static sample.Client.searchedBus;

public class HomeScreenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField start;

    @FXML
    private TextField end;

    @FXML
    private DatePicker dates;

    @FXML
    private Button search;


    @FXML
    private Label label;

    @FXML
    private ComboBox<String>  from = new ComboBox<>();

    @FXML
    private ComboBox<String> to = new ComboBox<>();

    @FXML
    private Button back;

    @FXML
    private Button user;

    @FXML
    void initialize() {
        assert start != null : "fx:id=\"start\" was not injected: check your FXML file 'HomeScreen.fxml'.";
        assert end != null : "fx:id=\"end\" was not injected: check your FXML file 'HomeScreen.fxml'.";
        assert dates != null : "fx:id=\"dates\" was not injected: check your FXML file 'HomeScreen.fxml'.";
        assert search != null : "fx:id=\"search\" was not injected: check your FXML file 'HomeScreen.fxml'.";

    }

   public void insideManager(Client loginManager){
       from.getItems().addAll("Chittagong","Dhaka","Panchagarh","Rajshahi","Rangpur","Sylhet");
       to.getItems().addAll("Chittagong","Dhaka","Panchagarh","Rajshahi","Rangpur","Sylhet");
       user.setText("Welcome "+ loginManager.userID.getUsername());
       search.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent event){
                String date = new String();
                String f = new String();
                String t = new String();
                try{
                    date = dates.getValue().toString();
                f = from.getValue();
                t = to.getValue();
                }catch(Exception e){
                    loginManager.showHomeScreen();
                }
                if(f==null||t==null||date==null)
                    label.setText("Invalid Input");
                else{
                BusSearch b = new BusSearch(f, t,date);
                loginManager.boss.write(b);
                Object o = loginManager.boss.read();
                if(o instanceof BusList){
                    BusList bbb = (BusList)o;
                    searchedBus = bbb.getBuslist();
                }
                }
                loginManager.showBusListScreen();

                for(int i=0; i<searchedBus.size(); i++){
                    System.out.println(searchedBus.get(i).getName());
                }
        }});
       back.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
           @Override
           public void handle(javafx.event.ActionEvent event) {
               loginManager.showLoginScreen();
           }});
    }}
