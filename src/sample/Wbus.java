package sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Wbus implements Serializable {
    private String price;
    private String date;
    private String destination;
    private String start;
    private String name;
    private String time;
    private String seats;


    public Wbus(String date,String start, String destination,String name, String time, String seats, String price){
        this.date= date;
        this.name = name;
        this.destination = destination;
        this.seats = seats;
        this.time = time;
        this.start = start;
        this.price = price;
    }

    public String getSeats() {
        return seats;
    }

    public String getDate() {
        return date;
    }

    public String getStart() {
        return start;
    }

    public String getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public String getDestination() {
        return destination;
    }

    public String getPrice() {
        return price;
    }
}
