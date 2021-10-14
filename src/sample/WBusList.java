package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WBusList implements Serializable {

    private List<Wbus> wbuslist = new ArrayList<>();
    public WBusList(){
        this.wbuslist = WBusFormation(readBus());
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
    public List<Wbus> WBusFormation (String[] s){
        List<Wbus> templist = new ArrayList<>();
        String[] array = new String[7];

        for (String x : s) {
            if (x == null)
                break;
            else {
                array = x.split(",");
                templist.add(new Wbus(array[0],array[1],array[2],array[3],array[4],array[5],array[6]));
            }
        }
        return templist;
    }

    public List<Wbus> getWbuslist() {
        return wbuslist;
    }

    public void writeWBus(Bus b, String s) throws Exception{
        FileWriter fw = new FileWriter("G:\\Java practice\\Project 1-2\\src\\sample\\buses.txt");
        for (int z = 0; z < wbuslist.size(); z++) {
            if(wbuslist.get(z).getDate().equals(b.getDate())&&wbuslist.get(z).getTime().equals(b.getTime())&&wbuslist.get(z).getStart().equals(b.getStart())&&wbuslist.get(z).getDestination().equals(b.getDestination())&&wbuslist.get(z).getName().equals(b.getName())){
                System.out.println("Got u");
                fw.write(wbuslist.get(z).getDate()+","+wbuslist.get(z).getStart()+","+wbuslist.get(z).getDestination()+","+wbuslist.get(z).getName()+","+wbuslist.get(z).getTime()+","+s+","+wbuslist.get(z).getPrice());
                fw.write(System.lineSeparator());
            }
            else {
                fw.write(wbuslist.get(z).getDate() + "," + wbuslist.get(z).getStart() + "," + wbuslist.get(z).getDestination() + "," + wbuslist.get(z).getName() + "," + wbuslist.get(z).getTime() + "," + wbuslist.get(z).getSeats()+","+ wbuslist.get(z).getPrice());
                fw.write(System.lineSeparator());
            }
        }
        fw.close();
    }
    public void writeWBus(Wbus b) throws Exception{
        FileWriter fw = new FileWriter("G:\\Java practice\\Project 1-2\\src\\sample\\buses.txt");
        for (int z = 0; z < wbuslist.size(); z++) {
                fw.write(wbuslist.get(z).getDate() + "," + wbuslist.get(z).getStart() + "," + wbuslist.get(z).getDestination() + "," + wbuslist.get(z).getName() + "," + wbuslist.get(z).getTime() + "," + wbuslist.get(z).getSeats()+","+ wbuslist.get(z).getPrice());
                fw.write(System.lineSeparator());
            }
            System.out.println("I am a meatball");
        fw.write(b.getDate()+","+b.getStart()+","+b.getDestination()+","+b.getName()+","+b.getTime()+","+","+b.getPrice());
        fw.write(System.lineSeparator());
        fw.close();
    }
}
