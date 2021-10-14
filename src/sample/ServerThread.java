package sample;

import util.NetworkUtil;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

import static sample.Server.alist;
import static sample.Server.blist;
import static sample.Server.ulist;

public class ServerThread implements Runnable {
    Thread thr;
    private NetworkUtil nc;

    public ServerThread(NetworkUtil nc) {
        this.nc = nc;
        this.thr = new Thread(this);
        this.thr.start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                Object o = nc.read();
                if (o instanceof Users) {
                    Users u = (Users) o;
                    // authorises whether the user is valid or not
                    if (u.authorize()) {
                        nc.write("true");
                    } else
                        nc.write("false");
                } else if (o instanceof NewUsers) {
                    NewUsers n = (NewUsers) o;
                    Users u = new Users(n.getUsername(), n.getPassword());
                    ulist.getUserslist().add(u);
                    ulist.writeUsers();
                    nc.write("done");
                }
                else if (o instanceof NewAdmin){
                    NewAdmin newadmin = (NewAdmin)o;
                    Admins ad = new Admins(newadmin.getUsername(),newadmin.getPassword(),"admin");
                    alist.getAdminlists().add(ad);
                    alist.writeAdmins();
                    nc.write("done");
                }
                else if (o instanceof BusSearch) {
                    BusSearch b = (BusSearch) o;
                    List<Bus> src = blist.searchBus(b.getDate(), b.getStart(), b.getEnd());
                    // gives buses that matches the requirements of search
                    BusList search = new BusList(src);
                    nc.write(search);
                }
                else if(o instanceof BookSeats){
                    BookSeats bs = (BookSeats)o;
                    System.out.println(bs.getSeats());
                    System.out.println(bs.makeString(bs.getBookBus().getSeats()));
                    // makes seats as are required to be printed in files as strings
                    String bkdsts = bs.makeString(bs.getBookBus().getSeats());
                    WBusList wb = new WBusList();
                    wb.writeWBus(bs.getBookBus(),bkdsts);
                    }
                else if(o instanceof cancel){
                    cancel c = (cancel)o;
                    c.kop();
                }
                else if (o instanceof Admins){
                    Admins s = (Admins)o;
                    if (s.authorize()) {
                        nc.write("true");
                    } else
                        nc.write("false");

                }
                else if(o instanceof AdminBusSearch){
                    AdminBusSearch ad = (AdminBusSearch)o;
                    Bus bus = blist.searchBusAdmin(ad.getDate(),ad.getStart(),ad.getEnd(),ad.getName());
                    nc.write(bus);
                }
                else if(o instanceof Wbus){
                    Wbus newbus = (Wbus)o;
                    WBusList wb = new WBusList();
                    wb.writeWBus(newbus);
                }
                else if(o instanceof BookedSeats){
                    BookedSeats b = (BookedSeats)o;
                    if(b.check())
                        nc.write("ase");
                    else
                        nc.write("nai");
                }
                }
        } catch (
                Exception e)

        {
            e.printStackTrace();
        } finally

        {
            nc.closeConnection();
        }

    }
}