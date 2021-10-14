package sample;

import java.net.ServerSocket;
import java.net.Socket;

import util.NetworkUtil;

public class Server {

    public static Userslist ulist = new Userslist(1);
    public static BusList blist = new BusList(1);
    public static Adminslist alist = new Adminslist();

    private ServerSocket serverSocket;
    public NetworkUtil nc;
    Server() {
        try {
            serverSocket = new ServerSocket(33333);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) {
        nc = new NetworkUtil(clientSocket);
        new ServerThread(nc);
        //new ServerBusThread(nc);
    }

    public static void main(String args[]) {
        Server server = new Server();
        BusList b = new BusList();
        System.out.println("done");
        //System.out.println(b.getBuslist().get(0).getName());
    }
}
