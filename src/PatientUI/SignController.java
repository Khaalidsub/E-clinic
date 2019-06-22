package PatientUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class SignController extends application.Main implements Initializable {

    static String name;
    @FXML
    private TextField PatientName;
    @FXML
    private Label label;
    @FXML
    private PasswordField PatientPassword;

    @FXML
    void SignedIn(ActionEvent event) {
        String username = PatientName.getText();
        String userpass = PatientPassword.getText();
        

        new application.Patient(username, userpass);

        name = username;
        try {
            root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            scene.setRoot(root);
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void Register(ActionEvent event){
// TODO: 6/15/2019 registration patient
    }

    @FXML
    void backClick(ActionEvent e) {

        try {
            root = FXMLLoader.load(getClass().getResource("/application/Home.fxml"));
            scene.setRoot(root);
            window.setScene(scene);
            window.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        label.setText("Patient Sign-in");

    }

}
