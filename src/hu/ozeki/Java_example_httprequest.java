package hu.ozeki;

import java.net.*;

public class Java_example_httprequest {

    public static void main(String[] args) {
        String s = "+8801766905524";
        String sb = "hgv";

        smsrequest arr = new smsrequest(s,sb);
        System.out.println(arr);
    }

}