package PatientUI;

import application.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Doctor extends  Home implements Initializable {

    @FXML
    private TableView<application.Doctor> Table;

    @FXML
    private TableColumn<application.Doctor,String> nameColumn;

    @FXML
    private TableColumn<application.Doctor,String> Specialcolumn;

    @FXML
    private TableColumn<application.Doctor,String> timeColumn;

    application.Patient c;

    ObservableList<application.Doctor> list = FXCollections.observableArrayList();

    @FXML
    void AppointClick(ActionEvent event) {
        // TODO: 6/15/2019 getting values and set appointmemnt
        try {
            root = FXMLLoader.load(getClass().getResource("appointment.fxml"));
            scene.setRoot(root);
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @FXML
    void ClinicClick(MouseEvent event) {

    }

    @FXML
    void backClick(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("Clinic.fxml"));
            scene.setRoot(root);
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {


            c = new Patient();
            list = c.getDoctor(Clinic.data);

            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            Specialcolumn.setCellValueFactory(new PropertyValueFactory<>("specialization"));
            timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
            Table.setItems(list);

    }
}
