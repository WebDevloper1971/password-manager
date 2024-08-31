package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import models.PasswordData;

public class FileReadWrite {
    
    private final static String file_path = "utils/PasswordManagerData.txt";


    public FileReadWrite(){

    }

    public static PasswordData search_password_data(String website_name){
        PasswordData req_data = null;
       try {
        ArrayList<PasswordData> pds = read_file();
        for (PasswordData p : pds) {
            if(p.getWebsite().equals(website_name)){
                req_data = p;
            }
        }
       } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return req_data;
    }

     public static ArrayList<PasswordData> read_file() {
        Path path = Paths.get(file_path);
        ArrayList<PasswordData> data = new ArrayList<PasswordData>();
        try {
            int len = Files.readAllLines(path).size();
            for(int index = 1; index < len; index ++){
                String read = Files.readAllLines(path).get(index);
                // System.out.println(read);
                String[]data_array = read.split(",");

                PasswordData psd = new PasswordData();
                psd.setId(Integer.parseInt(data_array[0]));
                psd.setWebsite(data_array[1]);
                psd.setEmail(data_array[2]);
                psd.setPassword(data_array[3]);
                psd.setDate(data_array[4]);

                data.add(psd);

            }
        } catch (NumberFormatException e) {
           
            e.printStackTrace();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        return data;
    }

    public static String write_file(String website, String email, String password)  {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String date_saved = df.format(new Date()).toString();

        try {
            ArrayList<PasswordData> pd = read_file();
            PasswordData p = pd.get(pd.size()-1);
            int last_id = p.getId();
            int current_id = last_id+1;

            String str = current_id+","+website+","+email+","+password+","+date_saved;
            BufferedWriter writer = new BufferedWriter(new FileWriter(file_path, true));
            writer.append("\n");
            writer.append(str);
            writer.close();
        } catch (IOException e) {
            e.getLocalizedMessage();
        }

        return "Password Saved Successfully";
    }

}
