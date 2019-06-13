package PatientUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.time.ZonedDateTime;
import java.util.ResourceBundle;

public class Home extends SignController implements Initializable {

    @FXML
    private Label labelling;

    @FXML
    private Label time;

    @FXML
    void CheckClinic(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("Clinic.fxml"));
            scene.setRoot(root);
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void CheckProfile(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("Profile.fxml"));
            scene.setRoot(root);
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void LogOut(ActionEvent event) {

        try {
            root = FXMLLoader.load(getClass().getResource("/application/Home.fxml"));
            scene.setRoot(root);
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {


        labelling.setText("Welcome " + SignController.name + "!");
        ZonedDateTime zone = ZonedDateTime.now();
        time.setText("Logged in time is :" + zone.toString());
    }
}
