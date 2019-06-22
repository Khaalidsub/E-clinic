package application;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {

    private String qualification;
    private String specialization;
    private Date Time_start;
    private Date Time_end;
    private  String time;

    public Doctor() {

    }

    public Doctor(String name, String image, String phone, String password, String qualific, String special, Date start, Date end, String specialization, Date Time_end) {
        super(name, password, image, phone);
        this.qualification = qualific;
        this.specialization = specialization;
        this.Time_end = Time_end;
        this.Time_start = start;

    }
    public Doctor(String name,String specialization, String Time){
        this.name = name;
        this.specialization = specialization;
        this.time = Time;

    }

    @Override
    public void login(String name, String password) {
        // TODO Auto-generated method stub

    }

    @Override
    public ArrayList<String> getProfile(String name) {
        return null;
    }


    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Date getTime_start() {
        return Time_start;
    }

    public void setTime_start(Date time_start) {
        Time_start = time_start;
    }

    public Date getTime_end() {
        return Time_end;
    }

    public void setTime_end(Date time_end) {
        Time_end = time_end;
    }

}
