package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;


public class AdminSeatPlanController {
    @FXML
    private Button A4 = new Button("A4");

    @FXML
    private Button B4 = new Button("B4");

    @FXML
    private Button C4= new Button("C4");

    @FXML
    private Button D4 = new Button("D4");

    @FXML
    private Button E4 = new Button("E4");

    @FXML
    private Button F4 = new Button("F4");

    @FXML
    private Button G4 = new Button("G4");

    @FXML
    private Button H4 = new Button("H4");

    @FXML
    private Button I4= new Button("J4");

    @FXML
    private Button J4 = new Button("J4");

    @FXML
    private Button A3= new Button("A3");

    @FXML
    private Button B3 = new Button("B3");

    @FXML
    private Button C3 = new Button("C3");

    @FXML
    private Button D3 = new Button("D3");

    @FXML
    private Button E3= new Button("E3");

    @FXML
    private Button F3= new Button("F3");

    @FXML
    private Button G3 = new Button("G3");

    @FXML
    private Button H3 = new Button("H3");

    @FXML
    private Button I3 = new Button("I3");

    @FXML
    private Button J3 = new Button("J3");

    @FXML
    private Button A2 = new Button("A2");

    @FXML
    private Button A1 = new Button("A1");

    @FXML
    private Button B2 = new Button("B2");

    @FXML
    private Button B1 = new Button("B1");

    @FXML
    private Button C2 = new Button("C2");

    @FXML
    private Button C1 = new Button("C1");

    @FXML
    private Button D2 = new Button("D2") ;

    @FXML
    private Button D1 = new Button("D1");

    @FXML
    private Button E2 = new Button("E2");

    @FXML
    private Button E1 = new Button("E1");

    @FXML
    private Button F2 = new Button("F2");

    @FXML
    private Button F1 = new Button("F1");

    @FXML
    private Button G1 = new Button("G1");

    @FXML
    private Button G2 = new Button("G2");

    @FXML
    private Button H2 = new Button("H2");

    @FXML
    private Button H1 = new Button("H1");

    @FXML
    private Button I2 = new Button("I2");

    @FXML
    private Button I1 = new Button("I1");

    @FXML
    private Button J2 = new Button("J2");

    @FXML
    private Button J1= new Button("J1");

    @FXML
    private Button busname;

    @FXML
    private Button back;

    @FXML
    private Button time;


    public Button[] buttonS = {A1,A2,A3,A4,B1,B2,B3,B4,C1,C2,C3,C4,D1,D2,D3,D4,E1,E2,E3,E4,F1,F2,F3,F4,G1,G2,G3,G4,H1,H2,H3,H4,I1,I2,I3,I4,J1,J2,J3,J4};
    private boolean [] buttonState = new boolean[40];
    private boolean [] seatState = new boolean[40];
    private List<Button> selectedSeats = new ArrayList<>();
    private Bus slctdbus ;

    public void initialManager(Client client,Bus bus) {
        slctdbus = bus;
        busname.setText(slctdbus.getName());
        time.setText(slctdbus.getTime());
        showButtons();
        back.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                client.showAdminHomeScreen();
            }});

    }
    public void showButtons() {
        Button[] buttonS = {A1,A2,A3,A4,B1,B2,B3,B4,C1,C2,C3,C4,D1,D2,D3,D4,E1,E2,E3,E4,F1,F2,F3,F4,G1,G2,G3,G4,H1,H2,H3,H4,I1,I2,I3,I4,J1,J2,J3,J4};
        if(slctdbus.getSeats()!=null)
            FindBookedSeats();
        for (int i = 0; i < 40; i++) {
            if (buttonState[i]) {
                System.out.println("Inside showButtons " + buttonS[i].getText());
                makeDisabled(buttonS[i]);
            }
        }
    }

    public void FindBookedSeats(){
        String[] st = slctdbus.getSeats();
        if(st[0] != null&&!(st[0].equals(" "))){
        for(String x: st){
            int i;
            try {
                i = Integer.parseInt(x);
            }catch (NumberFormatException e){
                break;
            }
            System.out.println(i);
            buttonState[i] = true;
        }}
    }

    public void makeDisabled(Button b) {
        System.out.println("I am working on " + b.getText());
        b.setStyle("-fx-background-color:  #FF6347;");
        b.setDisable(true);
    }

}
