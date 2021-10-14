package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Adminslist implements Serializable{
    public List<Admins> adminlists = new ArrayList<>();

    public Adminslist(){
        adminlists=AdminFormation(readAdmin());
    }
    public List<Admins> AdminFormation (String[] s){
        List<Admins> templist = new ArrayList<>();
        for (String x : s) {
            if (x == null)
                break;
            else {
                String[] array = x.split(",");
                templist.add(new Admins(array[0],array[1],"admin"));
            }
        }
        return templist;
    }

    public List<Admins> getAdminlists() {
        return adminlists;
    }

    public String[] readAdmin() {
        String [] admins = new String[1000];
        try (BufferedReader br = new BufferedReader(new FileReader("G:\\Java practice\\Project 1-2\\src\\sample\\admins.txt"))){
            String line;
            int i = 0;
            while (true) {
                line = br.readLine();
                if (line == null) break;
                admins[i] = line;
                i++;
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        return admins;
    }

    public void writeAdmins() throws IOException {
        FileWriter fw = new FileWriter("G:\\Java practice\\Project 1-2\\src\\sample\\admins.txt");
        for (int z = 0; z < adminlists.size(); z++) {
            fw.write(adminlists.get(z).getUsername()+","+adminlists.get(z).getPassword());
            fw.write(System.lineSeparator());
        }
        fw.close();
    }

}
