package sample;

import java.io.Serializable;

public class BookedSeats implements Serializable {
    Bus bus;
    String bookedseats;

    public BookedSeats(Bus b, String s){
        this.bookedseats=s;
        this.bus = b;
    }
    public boolean check(){
        BusList b = new BusList(1);
        Bus need = b.searchBusAdmin(bus.getDate(),bus.getStart(),bus.getDestination(),bus.getName());
        String[] str = bookedseats.split("n");
        boolean valueSet = true;
        for(int i=1;i<str.length; i++){
            for(int j=0; j < need.getSeats().length; j++){
                if(str[i].equals(need.getSeats()[j])){
                    valueSet = false;
                    break;
                }
            }if(valueSet==false) break;
        }
        return valueSet;
    }
}
