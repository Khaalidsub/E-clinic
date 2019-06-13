package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HomeController extends Main implements Initializable {

    Stage stage;
    @FXML
    private ToggleGroup User;
    private RadioButton user;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

    }

    @FXML
    void SignIn(ActionEvent event) {

        user = (RadioButton) User.getSelectedToggle();
        //User option
        if (user.getText().equals("Patient")) {

            try {
                root = FXMLLoader.load(getClass().getResource("/PatientUI/PatientSignIn.fxml"));
                scene.setRoot(root);
                window.setScene(scene);
                window.show();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } else if (user.getText().equals("Clinic")) {

            try {
                root = FXMLLoader.load(getClass().getResource("/ClinicUI/PatientSignIn.fxml"));
                scene.setRoot(root);
                window.setScene(scene);
                window.show();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        } else if (user.getText().equals("Doctor")) {

            try {
                root = FXMLLoader.load(getClass().getResource("/DoctorUI/PatientSignIn.fxml"));
                scene.setRoot(root);
                window.setScene(scene);
                window.show();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } else {

        }
    }

    @FXML
    void SignUp(ActionEvent event) {

        user = (RadioButton) User.getSelectedToggle();
        //User option
        if (user.getText().equals("Patient")) {

        } else if (user.getText().equals("Clinic")) {

        } else if (user.getText().equals("Doctor")) {

        } else {

        }
    }


}
