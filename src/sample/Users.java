package sample;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static sample.Server.ulist;

public class Users implements Serializable {
    private String username;
    private String password;

    public Users(String name, String password) {
        this.username = name;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean authorize (){
        int invalidlogin = 1;
        for(int i=0; i<ulist.getUserslist().size(); i++){
            if(ulist.getUserslist().get(i).getUsername().equals(username)&&ulist.getUserslist().get(i).getPassword().equals(password))
                invalidlogin = 0;
        }
        if (invalidlogin == 0) return true;
        else return false;
    }
}

