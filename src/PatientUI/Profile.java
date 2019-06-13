package PatientUI;

import application.HomeController;
import application.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Profile extends Home implements Initializable {
    @FXML
    private ImageView image;

    @FXML
    private Label email;

    @FXML
    private CheckBox emailEdit;

    @FXML
    private Label name;

    @FXML
    private CheckBox nameEdit;

    @FXML
    private Label contact;

    @FXML
    private CheckBox phoneEdit;

    @FXML
    private Label dob;

    @FXML
    private CheckBox dobEdit;

    @FXML
    void backClick(ActionEvent event) {
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
    void editClick(ActionEvent event) {

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        ArrayList<String> patient = new ArrayList<>();

        try {

            application.Patient pat = new Patient();
            patient = pat.getProfile(SignController.name);

            email.setText("Email :" + patient.get(0).toString());
            name.setText("Name :" + patient.get(1).toString());
            contact.setText("Contact :" + patient.get(2).toString());
            dob.setText("Date of Birth :" + patient.get(3).toString());

            Image images = new Image(patient.get(4));
            image.setImage(images);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.getStackTrace();
            e.getMessage();
        }


    }
}
