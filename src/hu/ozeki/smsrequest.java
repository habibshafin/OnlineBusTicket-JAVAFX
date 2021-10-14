package hu.ozeki;

import java.io.*;
import java.util.Scanner;

public class smsrequest implements Runnable{


    private String message;
    private String mob;

    public smsrequest(String message,String m) {
        this.message = message;
        this.mob=m;
        Thread thread=new Thread(this);
        thread.start();
       }


 public void run(){
        try {
            Scanner sc = new Scanner(System.in);
            String host = "localhost";
            int port = 9500;
            String username = "admin";
            String password = "abc123";



            MyOzSmsClient osc = new MyOzSmsClient(host, port);
            osc.login(username, password);;
            System.out.println("SMS message:");


            if(osc.isLoggedIn()) {

                osc.sendMessage("+8801766905524", "Test Message");

            }
            else
            {
                System.out.println("logged out");
                String s= osc.sendMessage(mob, message);
                System.out.println(s);
            }

            //sc.nextLine();
            osc.logout();

            /**
             * Receiving message:
             *
             * If you want to receive messages you can use doOnMessageReceived in MyOzSmsClient.java
             * That's an event, which runs automatically when a message is received.
             */

        } catch (IOException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
}