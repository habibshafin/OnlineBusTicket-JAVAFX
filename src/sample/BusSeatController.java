package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

import static sample.Client.selectedbus;

public class BusSeatController {
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
    private Label busname;

    @FXML
    private Button confirm;

    @FXML
    private Button back;

    @FXML
    private Label bustime;

    @FXML
    private Label noseats;

    @FXML
    private Button datess;

    @FXML
    private Button trip;

    public Button[] buttonS = {A1,A2,A3,A4,B1,B2,B3,B4,C1,C2,C3,C4,D1,D2,D3,D4,E1,E2,E3,E4,F1,F2,F3,F4,G1,G2,G3,G4,H1,H2,H3,H4,I1,I2,I3,I4,J1,J2,J3,J4};
    private boolean [] buttonState = new boolean[40];
    private boolean [] seatState = new boolean[40];
    private List<Button> selectedSeats = new ArrayList<>();
    public static String bookedseats;


    public void initialManager(Client client) {
        busname.setText(selectedbus.getName());
        bustime.setText(selectedbus.getTime());
        datess.setText("Date: "+selectedbus.getDate());
        trip.setText(selectedbus.getStart()+" to "+ selectedbus.getDestination());
        if(selectedbus.getSeats().length>0)
        showButtons();

        confirm.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                try{
                    bookedseats = PrepareBSeats();
                }catch (IndexOutOfBoundsException e){
                    noseats.setText("NO SEATS SELECTED");
                }


                if (bookedseats != null) {
                    BookedSeats b = new BookedSeats(selectedbus,bookedseats);
                    client.boss.write(b);
                    Object o = client.boss.read();
                    if(o.equals("ase")) {
                        BookSeats obj = new BookSeats(selectedbus, bookedseats);
                        client.boss.write(obj);
                        client.showConfirmScreen(selectedbus, selectedSeats.size(), bookedseats);
                    }
                    else{
                        System.out.println("your tickets are gone");
                        noseats.setText("Your seats have already been booked");
                    }
                }

            }});
        back.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
            client.showBusListScreen();
            }});

    }
    public String PrepareBSeats(){
        String temp = new String();
        int z = 0;
        for(int i = 0; i < 40; i++){
            if(selectedSeats.get(z).getText().equals(buttonS[i].getText())){
                if(temp!=null) {
                    temp = temp + "n" + Integer.toString(i);
                    z++;
                }
                if(z==selectedSeats.size())
                    break;
            }
        }
        return temp;
    }

    public void showButtons() {
        Button[] buttonS = {A1,A2,A3,A4,B1,B2,B3,B4,C1,C2,C3,C4,D1,D2,D3,D4,E1,E2,E3,E4,F1,F2,F3,F4,G1,G2,G3,G4,H1,H2,H3,H4,I1,I2,I3,I4,J1,J2,J3,J4};
        FindBookedSeats();
        for (int i = 0; i < 40; i++) {
            if (buttonState[i]) {
                System.out.println("Inside showButtons " + buttonS[i].getText());
                makeDisabled(buttonS[i]);
            }
        }
    }

    public void FindBookedSeats(){
        String[] st = selectedbus.getSeats();
        if(st[0]!=null&&(!(st[0].equals(" ")))){
        for(String x: st) {
            int i;
                try{
                    i = Integer.parseInt(x);
                }
                catch(NumberFormatException e){
                    break;
                }
                System.out.println(i);
                buttonState[i] = true;

        }
        }
    }

    public void makeDisabled(Button b) {
        System.out.println("I am working on " + b.getText());
        b.setStyle("-fx-background-color:  ff6347;");
        b.setDisable(true);
    }
    public void seatClicked(Button b) {
        int searchIndex = 0;
        for(int i = 0; i < buttonS.length; i++) {
            if(buttonS[i].getText().equalsIgnoreCase(b.getText())) {
                searchIndex = i;
                break;
            }
        }

        if (seatState[searchIndex]) {
            System.out.println(searchIndex + " no seat " + buttonS[searchIndex].getText() + " is removed from the list");
            b.setStyle("-fx-background-color: #ADD8E6;");
            seatState[searchIndex] = false;
            selectedSeats.remove(b);
        } else {
            System.out.println(searchIndex + " no seat " + buttonS[searchIndex].getText() + " is added to the list");
            b.setStyle("-fx-background-color: green;");
            seatState[searchIndex] = true;
            selectedSeats.add(b);
        }
        //showPaymentButton();
    }
    @FXML
    void A1Action(ActionEvent event) {
        seatClicked(A1);
    }

    @FXML
    void A2Action(ActionEvent event) {
        seatClicked(A2);
    }

    @FXML
    void A3Action(ActionEvent event) {
        seatClicked(A3);
    }

    @FXML
    void A4Action(ActionEvent event) {
        seatClicked(A4);
    }

    @FXML
    void B1Action(ActionEvent event) {
        seatClicked(B1);
    }

    @FXML
    void B2Action(ActionEvent event) {
        seatClicked(B2);
    }

    @FXML
    void B3Action(ActionEvent event) {
        seatClicked(B3);
    }

    @FXML
    void B4Action(ActionEvent event) {
        seatClicked(B4);
    }

    @FXML
    void C1Action(ActionEvent event) {
        seatClicked(C1);
    }

    @FXML
    void C2Action(ActionEvent event) {
        seatClicked(C2);
    }

    @FXML
    void C3Action(ActionEvent event) {
        seatClicked(C3);
    }

    @FXML
    void C4Action(ActionEvent event) {
        seatClicked(C4);
    }

    @FXML
    void D1Action(ActionEvent event) {
        seatClicked(D1);
    }

    @FXML
    void D2Action(ActionEvent event) {
        seatClicked(D2);
    }

    @FXML
    void D3Action(ActionEvent event) {
        seatClicked(D3);
    }

    @FXML
    void D4Action(ActionEvent event) {
        seatClicked(D4);
    }

    @FXML
    void E1Action(ActionEvent event) {
        seatClicked(E1);
    }

    @FXML
    void E2Action(ActionEvent event) {
        seatClicked(E2);
    }

    @FXML
    void E3Action(ActionEvent event) {
        seatClicked(E3);
    }

    @FXML
    void E4Action(ActionEvent event) {
        seatClicked(E4);
    }

    @FXML
    void F1Action(ActionEvent event) {
        seatClicked(F1);
    }

    @FXML
    void F2Action(ActionEvent event) {
        seatClicked(F2);
    }

    @FXML
    void F3Action(ActionEvent event) {
        seatClicked(F3);
    }

    @FXML
    void F4Action(ActionEvent event) {
        seatClicked(F4);
    }

    @FXML
    void G1Action(ActionEvent event) {
        seatClicked(G1);
    }

    @FXML
    void G2Action(ActionEvent event) {
        seatClicked(G2);
    }

    @FXML
    void G3Action(ActionEvent event) {
        seatClicked(G3);
    }

    @FXML
    void G4Action(ActionEvent event) {
        seatClicked(G4);
    }

    @FXML
    void H1Action(ActionEvent event) {
        seatClicked(H1);
    }

    @FXML
    void H2Action(ActionEvent event) {
        seatClicked(H2);
    }

    @FXML
    void H3Action(ActionEvent event) {
        seatClicked(H3);
    }

    @FXML
    void H4Action(ActionEvent event) {
        seatClicked(H4);
    }

    @FXML
    void I1Action(ActionEvent event) {
        seatClicked(I1);
    }

    @FXML
    void I2Action(ActionEvent event) {
        seatClicked(I2);
    }

    @FXML
    void I3Action(ActionEvent event) {
        seatClicked(I3);
    }

    @FXML
    void I4Action(ActionEvent event) {
        seatClicked(I4);
    }

    @FXML
    void J1Action(ActionEvent event) {
        seatClicked(J1);
    }

    @FXML
    void J2Action(ActionEvent event) {
        seatClicked(J2);
    }

    @FXML
    void J3Action(ActionEvent event) {
        seatClicked(J3);
    }

    @FXML
    void J4Action(ActionEvent event) {
        seatClicked(J4);
    }
}
