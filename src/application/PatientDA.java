package application;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class PatientDA {

    public Statement stmt;
    public Connection conn;
    PreparedStatement ps = null;
    ResultSet re = null;
    String url = "jdbc:mysql://localhost:3306/e-clinic?useTimezone=true&serverTimezone=UTC";
    String user = "root";
    String password = "";
    String query;
    ArrayList<String> patient;
    ObservableList<Doctor> list = FXCollections.observableArrayList();
    ObservableList<Clinic> list2 = FXCollections.observableArrayList();

    public static Connection getConnect() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/e-clinic?useTimezone=true&serverTimezone=UTC", "root", "");

        return con;
    }

    public void Sign(String name, String pass) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = getConnect();
            stmt = conn.createStatement();
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        } catch (SQLException e) {

            e.printStackTrace();
        }

        query = "select * from Patient where name=? and password=?";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, pass);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            re = ps.executeQuery();
            if (re.next()) {


                JOptionPane.showMessageDialog(null, "correct Username Or Password",

                        "Login worked", 1);
            } else {

                JOptionPane.showMessageDialog(null, "Incorrect Username Or Password",

                        "Login Failed", 2);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public void Register(String name, String pass) {
        // TODO Auto-generated method stub

    }

    public ArrayList<String> Profile(String name) {
        patient = new ArrayList<>();

        query = "SELECT * FROM patient WHERE name=?";
        try {
            conn = getConnect();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            re = ps.executeQuery();
            while (re.next()) {
                patient.add(re.getString("email"));
                patient.add(re.getString("name"));
                patient.add(re.getString("phone"));
                patient.add(re.getString("dob"));
                patient.add(re.getString("image"));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return patient;
    }


    public ObservableList<Clinic> getView() {

        query = "SELECT * FROM clinic";
        try {
            conn = getConnect();
            ps = conn.prepareStatement(query);
            re = ps.executeQuery();
            while (re.next()) {


                String name = re.getString("name");
                String address = re.getString("address");

                list2.add(new Clinic(name,address));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list2;
    }

    public ObservableList<Doctor> getDoctor(String data) {

        String query2 = "SELECT * FROM clinic WHERE name=?";
        String ID = null;
        try {
            conn = getConnect();
            ps = conn.prepareStatement(query2);
            ps.setString(1, data);
            re = ps.executeQuery();
            while (re.next()) {

                ID = re.getString("ID");
            }
            conn.close();

        }catch (SQLException e){
            e.printStackTrace();
        }


        query = "SELECT * FROM doc WHERE Clinic_ID =?";
        try {
            conn = getConnect();
            ps = conn.prepareStatement(query);
            ps.setString(1, ID);
            re = ps.executeQuery();
            while (re.next()) {

                String name = re.getString("name");
                String specialization = re.getString("specialization");
                Time time1= re.getTime("time_start");
                System.out.println(time1.toString());

                Time time2 = re.getTime("time_end");
                System.out.println(time2.toString());
                String time = time1.toString() + "  -  " + time2.toString();
                System.out.println(time);
                list.add(new Doctor(name,specialization,time));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
