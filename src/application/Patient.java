package application;

import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends User {
    private String email;

    private Date dob;
    private PatientDA patient;
    private ArrayList<String> patient_profile;


    public Patient() {
        // TODO Auto-generated constructor stub
    }

    public Patient(String name, String email, String phone, Date dob, String password, String image) {
        super(name, password, image, phone);
    }

    public Patient(String name, String pass) {
        super(name, pass);
        new PatientDA().Sign(name, pass);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public ArrayList<String> getProfile(String name) {
        patient = new PatientDA();
        patient_profile = patient.Profile(name);

        return patient_profile;
    }

    @Override
    public void login(String name, String password) {


    }


    public ObservableList<Clinic> getClinic() {
        patient = new PatientDA();
        return patient.getView();
    }
}

