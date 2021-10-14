package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class addBusController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> name;

    @FXML
    private ComboBox<String> start;

    @FXML
    private ComboBox<String> destination;

    @FXML
    private TextField time;

    @FXML
    private DatePicker date;

    @FXML
    private TextField price;

    @FXML
    private Button add;

    @FXML
    private Button add1;

    @FXML
    void initialize() {
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'BusAdd.fxml'.";
        assert start != null : "fx:id=\"start\" was not injected: check your FXML file 'BusAdd.fxml'.";
        assert destination != null : "fx:id=\"destination\" was not injected: check your FXML file 'BusAdd.fxml'.";
        assert time != null : "fx:id=\"time\" was not injected: check your FXML file 'BusAdd.fxml'.";
        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'BusAdd.fxml'.";
        assert price != null : "fx:id=\"price\" was not injected: check your FXML file 'BusAdd.fxml'.";
        assert add != null : "fx:id=\"add\" was not injected: check your FXML file 'BusAdd.fxml'.";
        assert add1 != null : "fx:id=\"add1\" was not injected: check your FXML file 'BusAdd.fxml'.";

    }

    public void insideManager(Client client) {
        start.getItems().addAll("Chittagong","Dhaka","Panchagarh","Rajshahi","Rangpur","Sylhet");
        destination.getItems().addAll("Chittagong","Dhaka","Panchagarh","Rajshahi","Rangpur","Sylhet");
        name.getItems().addAll("GreenLine","Shohag Enterprise","Hanif Enterprise");
        add.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                Wbus newbus = new Wbus(date.getValue().toString(),start.getValue(),destination.getValue(),name.getValue(),time.getText(),"0n1",price.getText());
                client.boss.write(newbus);
                String[] seats = new String[40];
                Bus bbb = new Bus(date.getValue().toString(),start.getValue(),destination.getValue(),name.getValue(),time.getText(),seats,price.getText());
                client.showAdminSeatPlan(bbb);
                System.out.println("Your Bus is Added");
            }});
        add1.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                client.showAdminHomeScreen();
            }});
            }
}
