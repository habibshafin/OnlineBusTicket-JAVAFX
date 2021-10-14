package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import sample.Client;

public class AdminHomescreenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker date;

    @FXML
    private Button search;

    @FXML
    private Button nbus;

    @FXML
    private ComboBox<String> busname;

    @FXML
    private ComboBox<String > start;

    @FXML
    private ComboBox<String> destination;

    @FXML
    private Button back;

    @FXML
    private Button admin;


    @FXML
    void initialize() {
        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'adminHomeScreen.fxml'.";
        assert search != null : "fx:id=\"search\" was not injected: check your FXML file 'adminHomeScreen.fxml'.";
        assert nbus != null : "fx:id=\"nbus\" was not injected: check your FXML file 'adminHomeScreen.fxml'.";
        assert busname != null : "fx:id=\"busname\" was not injected: check your FXML file 'adminHomeScreen.fxml'.";
        assert start != null : "fx:id=\"start\" was not injected: check your FXML file 'adminHomeScreen.fxml'.";
        assert destination != null : "fx:id=\"destination\" was not injected: check your FXML file 'adminHomeScreen.fxml'.";
    }


    public void insideManager(Client client) {
        start.getItems().addAll("Chittagong","Dhaka","Panchagarh","Rajshahi","Rangpur","Sylhet");
        destination.getItems().addAll("Chittagong","Dhaka","Panchagarh","Rajshahi","Rangpur","Sylhet");
        busname.getItems().addAll("GreenLine","Shohag Enterprise","Hanif Enterprise");
        admin.setText("Welcome admin");
        search.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override public void handle(javafx.event.ActionEvent event) {
            AdminBusSearch b = new AdminBusSearch(busname.getValue(),start.getValue(),destination.getValue(),date.getValue().toString());
            client.boss.write(b);
            Object o = client.boss.read();
            if(o instanceof Bus){
                Bus bus = (Bus)o;
                client.showAdminSeatPlan(bus);
            }
            }});
        nbus.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override public void handle(javafx.event.ActionEvent event) {
                client.showAddBusScreen();
            }});
        back.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override public void handle(javafx.event.ActionEvent event) {
                client.showLoginScreen();
            }});

    }
}
