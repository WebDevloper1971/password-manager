package models;

public class PasswordData{

    private int id;
    private String website_name;
    private String email;
    private String password;
    private String date;

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setWebsite(String website_name){
        this.website_name = website_name;
    }

    public String getWebsite(){
        return this.website_name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getDate(){
        return this.date;
    }

    public PasswordData(){
        
    }

    public PasswordData(int id, String website_name, String email, String password, String date) {
        this.id = id;
        this.website_name = website_name;
        this.email = email;
        this.password = password;
        this.date = date;
    }

    @Override
    public String toString() {
        return "PasswordData [id=" + id + ", website_name=" + website_name + ", email=" + email + ", password="
                + password + ", date=" + date + "]";
    }

    
}