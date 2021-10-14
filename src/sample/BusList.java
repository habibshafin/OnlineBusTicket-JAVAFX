package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BusList implements Serializable{
    private List<Bus> buslist = new ArrayList<>();
    public BusList(){
        this.buslist = BusFormation(readBus());
    }
    public List<Bus> getBuslist() {
        return buslist;
    }

    public String[] readBus() {
        String [] Buses = new String[1000];

        try (BufferedReader br = new BufferedReader(new FileReader("G:\\Java practice\\Project 1-2\\src\\sample\\buses.txt"))){

            String line;
            int i = 0;
            while (true) {
                line = br.readLine();
                if (line == null) break;
                Buses[i] = line;
                i++;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return Buses;
    }
    public List<Bus> BusFormation (String[] s){
        List<Bus> templist = new ArrayList<>();
        String[] array = new String[7];
        String sss = new String();
        String[] seats = new String[40];
        for (String x : s) {
            if (x == null)
                break;
            else {
                array = x.split(",");
                sss=array[5];
                seats = sss.split("n");
                templist.add(new Bus(array[0],array[1],array[2],array[3],array[4],seats,array[6]));
            }
        }
        return templist;
    }
    public List<Bus> searchBus(String date, String start,String destination){
        List<Bus> allBuses = BusFormation(readBus());
        List<Bus> searchedBus = new ArrayList<>();
        System.out.println(allBuses.get(1).getName());

        for(int i = 0;i < allBuses.size(); i++){
            if(allBuses.get(i).getDate().equals(date)&&allBuses.get(i).getStart().equalsIgnoreCase(start)&&allBuses.get(i).getDestination().equalsIgnoreCase(destination)){
                searchedBus.add(allBuses.get(i));
            }
        }
        return searchedBus;
    }

    public BusList(int i ){
        this.buslist = BusFormation(readBus());
    }
    public BusList(List<Bus> arg){
        this.buslist = arg;
    }

    public Bus searchBusAdmin(String date, String start, String end, String name) {
        BusList listbus = new BusList(1);
        List<Bus> b = listbus.searchBus(date,start,end);
        Bus temp = null;
        for(int i=0;i<b.size();i++){
            if(b.get(i).getName().equals(name)) {
                temp = b.get(i);
                break;
            }
        }
        return temp;
    }
}