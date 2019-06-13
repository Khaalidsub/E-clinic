package application;

import java.util.ArrayList;

public abstract class User {
    protected String name;
    protected String password;
    protected String phone;
    protected String image;

    public User() {
        // TODO Auto-generated constructor stub
    }

    public User(String name, String pass, String image, String phone) {
        this.setName(name);
        this.setPassword(pass);
        this.image = image;
        this.phone = phone;
    }

    public User(String name, String pass) {
        this.name = name;
        this.password = pass;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract void login(String name, String password);

    public abstract ArrayList<String> getProfile(String name);

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
