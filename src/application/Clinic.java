package application;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Clinic extends User {
    private String email;
    private String address;


    private ArrayList<Doctor> doc;


    public Clinic() {

    }

    public Clinic(String name, String email, String address, String password, String image, String phone) {
        super(name, password, image, phone);
        this.email = email;
        this.address = address;
    }

    Clinic(String name,String address){
        this.name = name;
        this.address = address;
    }

    @Override
    public void login(String name, String password) {
        // TODO Auto-generated method stub

    }

    @Override
    public ArrayList<String> getProfile(String name) {
        return null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Doctor> getDoc() {
        return doc;
    }

    public void setDoc(ArrayList<Doctor> doc) {
        this.doc = doc;
    }


}
