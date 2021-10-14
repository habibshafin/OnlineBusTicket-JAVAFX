package sample;

import java.io.Serializable;

public class AdminBusSearch implements Serializable {
    private String start;
    private String end;
    private String date;
    private String name;

    public AdminBusSearch(String name,String start, String end, String date){
        this.date= date;
        this.name = name;
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

    public String getName() {
        return name;
    }
}

