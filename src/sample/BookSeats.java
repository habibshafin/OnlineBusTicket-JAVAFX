package sample;

import java.io.Serializable;

public class BookSeats implements Serializable {
    private String seats;
    private Bus bookBus;
    public BookSeats(Bus b , String arg){
        this.bookBus = b;
        this.seats = arg;
    }

    public Bus getBookBus() {
        return bookBus;
    }

    public String getSeats() {
        return seats;
    }

    public String makeString(String[] seats) {
        String res = new String();
        int i=0;
        for(String x: seats){
            if(i==0){
                res = x + getSeats();
                i++;
            }
            else{
                res = res + "n"+ x;
            }
        }
        return res;
    }

    public void FinaliseBooking(){
        String sts = makeString(bookBus.getSeats());
        System.out.println(sts);


    }


}

