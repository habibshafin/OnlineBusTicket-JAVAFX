package sample;

import java.io.Serializable;

public class Bus implements Serializable {
    private String date;
    private String destination;
    private String start;
    private String name;
    private String time;
    private String[] seats;
    private String price;

    public Bus(String date,String start, String destination,String name, String time, String[] seats, String price){
        this.price = price;
        this.date= date;
        this.name = name;
        this.destination = destination;
        this.seats = seats;
        this.time = time;
        this.start = start;
    }

    public Bus() {

    }

    public String getDate() {
        return date;
    }

    public String getDestination() {
        return destination;
    }

    public String getName() {
        return name;
    }

    public String getStart() {
        return start;
    }

    public String getTime() {
        return time;
    }

    public String[] getSeats() {
        return seats;
    }

    public String getPrice() {
        return price;
    }

    public int getBookedSeatsnum(){
        System.out.println(seats[0]);
        if(seats[0]!=" ")
        return seats.length;
        else return (seats.length - 1);
    }
}
