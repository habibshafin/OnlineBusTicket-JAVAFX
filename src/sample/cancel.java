package sample;

import java.io.Serializable;
import java.util.Arrays;

public class cancel implements Serializable {
    private Bus slctd;
    private String command;
    private String seats;

    public cancel(Bus b , String seats, String command){
        this.slctd = b;
        this.command = command;
        this.seats = seats;
    }

    public void kop() throws Exception {
        String[] s = seats.split("n");
        String[] bs = slctd.getSeats();
        String res = minus(bs , s);
        System.out.println(res);
        WBusList wb = new WBusList();
        wb.writeWBus(slctd,res);
    }


    private static String minus(String[] bs, String[] s) {
        String res = new String();
        int i=0;
        for(String x: bs){
            System.out.println(Arrays.asList(s).contains(x));
            boolean b=Arrays.asList(s).contains(x);
            if(!b){
                if(i==0){
                    res=x;
                    i++;
                } else res = res + "n"+x;
            }
        }
        return res;

    }
}
