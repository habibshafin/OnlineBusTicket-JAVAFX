/*package sample;

import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import static sample.Client.searchedBus;

public class BusListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton radbus1;

    @FXML
    private Label busname1;

    @FXML
    private Label bus1time;

    @FXML
    private Label bus1seats;

    @FXML
    private RadioButton radbus11;

    @FXML
    private Label bus1name1;

    @FXML
    private Label bus1time1;

    @FXML
    private Label bus1seats1;

    @FXML
    private RadioButton radbus111;

    @FXML
    private Label bus1name11;

    @FXML
    private Label bus1time11;

    @FXML
    private Label bus1seats11;

    @FXML
    private Button back;


    public void initial(List<Bus> b){
        busname1.setText(b.get(0).getName());
        bus1name1.setText(b.get(1).getName());
        bus1name11.setText(b.get(2).getName());
        bus1time.setText(b.get(0).getTime());
        bus1time1.setText(b.get(0).getTime());
        bus1time11.setText(b.get(0).getTime());
        int i = 32-b.get(0).getSeats().length;
        bus1seats.setText("32 seats");
        bus1seats1.setText("32 seats");
        bus1seats11.setText("32 seats");
    }

    public void initialManager(Client loginmanager) {
        initial(searchedBus);
        back.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                loginmanager.showHomeScreen();
            }});
        radbus1.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
            loginmanager.showSeatPlan(searchedBus.get(0));
                }});
        radbus11.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                loginmanager.showSeatPlan(searchedBus.get(1)); }});
        radbus111.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                loginmanager.showSeatPlan(searchedBus.get(2));}});
    }



   //public int sec
    @FXML
    void initialize() {
        assert radbus1 != null : "fx:id=\"radbus1\" was not injected: check your FXML file 'BusList.fxml'.";
        assert busname1 != null : "fx:id=\"busname1\" was not injected: check your FXML file 'BusList.fxml'.";
        assert bus1time != null : "fx:id=\"bus1time\" was not injected: check your FXML file 'BusList.fxml'.";
        assert bus1seats != null : "fx:id=\"bus1seats\" was not injected: check your FXML file 'BusList.fxml'.";
        assert radbus11 != null : "fx:id=\"radbus11\" was not injected: check your FXML file 'BusList.fxml'.";
        assert bus1name1 != null : "fx:id=\"bus1name1\" was not injected: check your FXML file 'BusList.fxml'.";
        assert bus1time1 != null : "fx:id=\"bus1time1\" was not injected: check your FXML file 'BusList.fxml'.";
        assert bus1seats1 != null : "fx:id=\"bus1seats1\" was not injected: check your FXML file 'BusList.fxml'.";
        assert radbus111 != null : "fx:id=\"radbus111\" was not injected: check your FXML file 'BusList.fxml'.";
        assert bus1name11 != null : "fx:id=\"bus1name11\" was not injected: check your FXML file 'BusList.fxml'.";
        assert bus1time11 != null : "fx:id=\"bus1time11\" was not injected: check your FXML file 'BusList.fxml'.";
        assert bus1seats11 != null : "fx:id=\"bus1seats11\" was not injected: check your FXML file 'BusList.fxml'.";

    }

}
*/
package sample;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import static sample.Client.searchedBus;
import static sample.Client.selectedbus;

public class BusListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton radbus1;

    @FXML
    private Label busname1;

    @FXML
    private Label bus1time;

    @FXML
    private Label bus1seats;

    @FXML
    private RadioButton radbus11;

    @FXML
    private RadioButton radbus121;

    @FXML
    private RadioButton radbus12;

    @FXML
    private Label bus1name1;

    @FXML
    private Label bus1time1;

    @FXML
    private Label bus1seats1;

    @FXML
    private RadioButton radbus111;

    @FXML
    private Label bus1name11;

    @FXML
    private Label bus1time11;

    @FXML
    private Label bus1seats11;

    @FXML
    private Label busname11;

    @FXML
    private Label bus1time2;

    @FXML
    private Label bus1seats2;

    @FXML
    private Label busname111;

    @FXML
    private Label bus1time21;

    @FXML
    private Label bus1seats21;

    @FXML
    private Button back;

    private static int seat1;
    private static int seat2;
    private static int seat3;

    public void initial(List<Bus> b) {

        if(b.size()!=0){
        bus1name11.setText(b.get(0).getName());
        bus1time11.setText(b.get(0).getTime());
        System.out.println(b.get(0).getSeats().length);
        if(b.get(0).getSeats()[0].equals(" "))
            seat1 = 40;
        else
            seat1 = 40 - b.get(0).getBookedSeatsnum();
        bus1seats11.setText(String.valueOf(seat1));}
        if (b.size()>=2) {
            bus1name1.setText(b.get(1).getName());
            bus1time1.setText(b.get(1).getTime());
            seat2 = 40 - b.get(1).getBookedSeatsnum();
            bus1seats1.setText(String.valueOf(seat2));
        }
        if (b.size()>=3) {
            busname1.setText(b.get(2).getName());
            bus1time.setText(b.get(2).getTime());
            seat3 = 40 - b.get(2).getBookedSeatsnum();
            bus1seats.setText(String.valueOf(seat3));
        }
        if (b.size()>=4) {
            busname11.setText(b.get(3).getName());
            bus1time2.setText(b.get(3).getTime());
            seat3 = 40 - b.get(3).getBookedSeatsnum();
            bus1seats2.setText(String.valueOf(seat3));
        }
        if (b.size()>=5) {
            busname111.setText(b.get(3).getName());
            bus1time21.setText(b.get(3).getTime());
            seat3 = 40 - b.get(3).getBookedSeatsnum();
            bus1seats21.setText(String.valueOf(seat3));
        }
    }

    public void initialManager(Client loginmanager) {
        initial(searchedBus);
        back.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) { loginmanager.showHomeScreen(); }});
        radbus1.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                if(searchedBus.size()>=3)
                loginmanager.showSeatPlan(searchedBus.get(2));
            }});
        radbus11.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                if (searchedBus.size()>=2)
                loginmanager.showSeatPlan(searchedBus.get(1)); }});
        radbus111.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                if (searchedBus.size()!=0)
                    loginmanager.showSeatPlan(searchedBus.get(0));}});
        radbus12.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                if (searchedBus.size()>=4)
                    loginmanager.showSeatPlan(searchedBus.get(3));}});
        radbus121.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                if (searchedBus.size()>=5)
                    loginmanager.showSeatPlan(searchedBus.get(4));}});

    }

    @FXML
    void initialize() {
        assert radbus1 != null : "fx:id=\"radbus1\" was not injected: check your FXML file 'BusList.fxml'.";
        assert busname1 != null : "fx:id=\"busname1\" was not injected: check your FXML file 'BusList.fxml'.";
        assert bus1time != null : "fx:id=\"bus1time\" was not injected: check your FXML file 'BusList.fxml'.";
        assert bus1seats != null : "fx:id=\"bus1seats\" was not injected: check your FXML file 'BusList.fxml'.";
        assert radbus11 != null : "fx:id=\"radbus11\" was not injected: check your FXML file 'BusList.fxml'.";
        assert bus1name1 != null : "fx:id=\"bus1name1\" was not injected: check your FXML file 'BusList.fxml'.";
        assert bus1time1 != null : "fx:id=\"bus1time1\" was not injected: check your FXML file 'BusList.fxml'.";
        assert bus1seats1 != null : "fx:id=\"bus1seats1\" was not injected: check your FXML file 'BusList.fxml'.";
        assert radbus111 != null : "fx:id=\"radbus111\" was not injected: check your FXML file 'BusList.fxml'.";
        assert bus1name11 != null : "fx:id=\"bus1name11\" was not injected: check your FXML file 'BusList.fxml'.";
        assert bus1time11 != null : "fx:id=\"bus1time11\" was not injected: check your FXML file 'BusList.fxml'.";
        assert bus1seats11 != null : "fx:id=\"bus1seats11\" was not injected: check your FXML file 'BusList.fxml'.";
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'BusList.fxml'.";

    }
}
