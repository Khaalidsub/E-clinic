package PatientUI;

import application.Doctor;
import application.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
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


    static  String data = null;

    @FXML
    void ClinicClick(MouseEvent event) {
        TablePosition pos = Table.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        System.out.println(event.getPickResult().toString());


        // Item here is the table view type:
        application.Clinic item = Table.getItems().get(row);

        TableColumn col = pos.getTableColumn();

        // this gives the value in the selected cell:
        data = (String) col.getCellObservableValue(item).getValue();
        if (data != null){
            try {
                root = FXMLLoader.load(getClass().getResource("Doctor.fxml"));
                scene.setRoot(root);
                window.setScene(scene);
                window.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else{
                // TODO: 6/14/2019
        }

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
