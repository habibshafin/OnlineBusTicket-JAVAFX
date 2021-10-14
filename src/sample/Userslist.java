package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Userslist implements Serializable{
    public List<Users> userlists = new ArrayList<>();

    public Userslist() {

    }

    public List<Users> UserFormation (String[] s){
        List<Users> templist = new ArrayList<>();
        for (String x : s) {
            if (x == null)
                break;
            else {
                String[] array = x.split(",");
                templist.add(new Users(array[0],array[1]));
            }
        }
        return templist;
    }
    public List<Users> getUserslist(){
        return userlists;
    }

    public String[] readUser() {
        String [] userS = new String[1000];
        try (BufferedReader br = new BufferedReader(new FileReader("G:\\Java practice\\Project 1-2\\src\\sample\\users.txt"))){
            String line;
            int i = 0;
            while (true) {
                line = br.readLine();
                if (line == null) break;
                userS[i] = line;
                i++;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return userS;
    }

    public void writeUsers() throws IOException {
        FileWriter fw = new FileWriter("G:\\Java practice\\Project 1-2\\src\\sample\\users.txt");
        for (int z = 0; z < userlists.size(); z++) {
            fw.write(userlists.get(z).getUsername()+","+userlists.get(z).getPassword());
            fw.write(System.lineSeparator());
        }
        fw.close();
    }

    public Userslist(List<Users> arg){
        this.userlists = arg;
    };
    public Userslist(int i){
        this.userlists = UserFormation(readUser());
    };

}
