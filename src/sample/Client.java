package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import util.NetworkUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Client extends Application{
    public static List<Bus> searchedBus = new ArrayList<>();
    public NetworkUtil boss ;
    public Users userID;
    public static Bus selectedbus;
    Scene scene;
    public static String USERname;

    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage PrimaryStage) throws Exception {
        String serverAddress = "127.0.0.1";
        int serverPort = 33333;

        try{
            boss = new NetworkUtil(serverAddress, serverPort);
            //new ClientReadThread(boss);
        } catch(Exception e) {
            e.printStackTrace();
        }
        scene = new Scene(new Pane(),630,400);
        showLoginScreen();
        PrimaryStage.setMaxHeight(450);
        PrimaryStage.setMaxWidth(650);
        PrimaryStage.setTitle("Online Ticket Management System");
        PrimaryStage.setScene(scene);
        PrimaryStage.show();
    }
    //shows customer login screen and loads its controller
    public void showLoginScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            scene.setRoot(loader.load());
            LoginController controller = loader.<LoginController>getController();
            controller.insideManager(this);
            //new ClientReadThread(nc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //shows customer signup screen and loads its controller
    public void showSignupScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("signup.fxml"));
            scene.setRoot((loader.load()));
            signupController controller = loader.<signupController>getController();
            controller.insideManager(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //shows customer home screen and loads its controller
    public void showHomeScreen(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Homescreen.fxml"));
            scene.setRoot((loader.load()));
            HomeScreenController controller = loader.<HomeScreenController>getController();
            controller.insideManager(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //shows screen listing buses as per searched and loads its controller
    public void showBusListScreen()  {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BusList.fxml"));
            scene.setRoot((loader.load()));
            BusListController controller = loader.<BusListController>getController();
            controller.initialManager(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //shows screen showing seat plan of selected bus with booked and free seats and loads its controller
    public void showSeatPlan(Bus b) {
        try{
            selectedbus = b;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BusSeat.fxml"));
            scene.setRoot((loader.load()));
            BusSeatController controller = loader.<BusSeatController>getController();
            controller.initialManager(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //shows condirmation and ticket details and loads its controller
    public void showConfirmScreen(Bus b, int seatnum,String s) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Confirmation.fxml"));
            scene.setRoot((loader.load()));
            ConfirmationController controller = loader.<ConfirmationController>getController();
            controller.initialManager(this, b,seatnum,s);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //shows admin login and loads its controller
    public void showAdminLoginScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("adminLogin.fxml"));
            scene.setRoot(loader.load());
            adminLoginController controller = loader.<adminLoginController>getController();
            controller.insideManager(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //shows admin home screen and loads its controller
    public void showAdminHomeScreen() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("adminHomeScreen.fxml"));
            scene.setRoot((loader.load()));
            AdminHomescreenController controller = loader.<AdminHomescreenController>getController();
            controller.insideManager(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //shows admin signup and loads its controller
    public void showAdminSignupScreen() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("adminSignup.fxml"));
            scene.setRoot((loader.load()));
            adminSignupController controller = loader.<adminSignupController>getController();
            controller.insideManager(this);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    //Screen adding a trip
    public void showAddBusScreen() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("addBus.fxml"));
            scene.setRoot((loader.load()));
            addBusController controller = loader.<addBusController>getController();
            controller.insideManager(this);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void showAdminSeatPlan(Bus bus) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("adminSeatPlan.fxml"));
            scene.setRoot((loader.load()));
            AdminSeatPlanController controller = loader.<AdminSeatPlanController>getController();
            controller.initialManager(this,bus);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

