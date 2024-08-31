package utils;

import java.util.Random;

public class PasswordGenerator {
    
    public PasswordGenerator(){

    }

    public static String generatePassword(String website_name, String email){
        String password = "";
        Random rand = new Random();
        String s1 = "";
        String s2 = "";
        String [] special_character_arr = {"!","@","#","$","%","&"};
        String [] num_arr = {"0","1","2","3","4","5","6","7","8","9"};
        if(website_name.length() < 3){
            s1 = website_name.substring(0, rand.nextInt(1,3));
            s2 = email.substring(0, rand.nextInt(1,3));
        }else{
            s1 = website_name.substring(0, rand.nextInt(1,website_name.length()/2 + 1));
            s2 = email.substring(0, rand.nextInt(1,website_name.length()/2 + 1));
        }

        String password_arr[] = {s1,s2,special_character_arr[rand.nextInt(0,special_character_arr.length)], num_arr[rand.nextInt(0,num_arr.length)]};
        
        while(password.length() < 8){
            password += password_arr[rand.nextInt(0, password_arr.length)];
        }

        return password;
    }

}
