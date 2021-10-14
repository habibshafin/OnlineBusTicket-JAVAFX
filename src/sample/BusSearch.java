package sample;

import java.io.Serializable;

public class BusSearch implements Serializable {
    private String start;
    private String end;
    private String date;

    public BusSearch(String start, String end, String date){
        this.date= date;
        this.start = start;
        this.end = end;
    }

    public String getStart() {
        return start;
    }

    public String getDate() {
        return date;
    }

    public String getEnd() {
        return end;
    }
}
