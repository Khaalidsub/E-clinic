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
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Clinic extends Home implements Initializable {
    @FXML
    private TableView<application.Clinic> Table;

    @FXML
    private TableColumn<application.Clinic,String> nameColumn;

    @FXML
    private TableColumn<application.Clinic,String> addressColumn;

    ObservableList<application.Clinic> list = FXCollections.observableArrayList();

    @FXML
    void ClinicClick(MouseEvent event) {

    }

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
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {


    application.Patient p = new application.Patient();
    list = p.getClinic();

    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
    Table.setItems(list);


    }
}
