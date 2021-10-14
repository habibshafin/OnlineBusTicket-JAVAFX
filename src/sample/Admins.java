package sample;

import java.io.Serializable;

import static sample.Server.alist;


public class Admins implements Serializable {
    private String username;
    private String password;
    private String ad;
    public Admins(String text, String text1, String admin){
        this.username = text;
        this.password = text1;
        this.ad = admin;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAd() {
        return ad;
    }

    public boolean authorize (){
        int invalidlogin = 1;
        for(int i=0; i<alist.getAdminlists().size(); i++){
            if(alist.getAdminlists().get(i).getUsername().equals(username)&&alist.getAdminlists().get(i).getPassword().equals(password))
                invalidlogin = 0;
        }
        if (invalidlogin == 0) return true;
        else return false;
    }
}
